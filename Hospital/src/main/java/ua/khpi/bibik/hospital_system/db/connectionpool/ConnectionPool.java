package ua.khpi.bibik.hospital_system.db.connectionpool;

import java.sql.Array;
import java.sql.Blob;
import java.sql.CallableStatement;
import java.sql.Clob;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.NClob;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLClientInfoException;
import java.sql.SQLException;
import java.sql.SQLWarning;
import java.sql.SQLXML;
import java.sql.Savepoint;
import java.sql.Struct;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.locks.ReentrantLock;

import ua.khpi.bibik.hospital_system.db.DBPropertyKey;
import ua.khpi.bibik.hospital_system.db.DBPropertyReader;
import ua.khpi.bibik.hospital_system.db.connectionpool.exception.ConnectionPoolException;

public class ConnectionPool {
	
	private static final int DEFAULT_POOL_SIZE = 10;
	private static final ReentrantLock lock = new ReentrantLock();
	private BlockingQueue<Connection> connectionQueue;
	private BlockingQueue<Connection> givenAwayConQueue;
	private String driverName;
	private String url;
	private String user;
	private String password;
	private int poolSize;

	private static volatile ConnectionPool conPool = null;

	public static ConnectionPool getInstance() throws ConnectionPoolException {
		if (conPool == null) {
			try {
				lock.lock();
				if (conPool == null) {
					conPool = new ConnectionPool();
				}
			} finally {
				lock.unlock();
			}
		}
		return conPool;
	}

	private ConnectionPool() {
		DBPropertyReader propertyReader = DBPropertyReader.getInstanse();
		this.driverName = propertyReader.getValue(DBPropertyKey.DB_DRIVER);
		this.url = propertyReader.getValue(DBPropertyKey.DB_URL);
		this.user = propertyReader.getValue(DBPropertyKey.DB_USER);
		this.password = propertyReader.getValue(DBPropertyKey.DB_PASSWORD);
		try {
			this.poolSize = Integer.parseInt(propertyReader.getValue(DBPropertyKey.DB_POOL_SIZE));
		} catch (NumberFormatException e) {
			this.poolSize = DEFAULT_POOL_SIZE;
		}
		try {
			initPoolData();
		} catch (ConnectionPoolException e) {
//			logger.log(Level.ERROR, "Error initializing connection pool", e);
		}
	}

	public void initPoolData() throws ConnectionPoolException {

		try {
			Class.forName(driverName);
			connectionQueue = new ArrayBlockingQueue<Connection>(poolSize);
			givenAwayConQueue = new ArrayBlockingQueue<Connection>(poolSize);
			for (int i = 0; i < poolSize; i++) {
				Connection connection = DriverManager.getConnection(url, user, password);
				PooledConnection pooledConnection = new PooledConnection(connection);
				connectionQueue.add(pooledConnection);
			}
		} catch (SQLException e) {
			throw new ConnectionPoolException();
		} catch (ClassNotFoundException e) {
			throw new ConnectionPoolException();
		}
	}

	public void dispose() {
		clearConnectionQueue();
	}

	private void clearConnectionQueue() {
		try {
			closeConnectionsQueue(givenAwayConQueue);
			closeConnectionsQueue(connectionQueue);
		} catch (SQLException e) {
//			logger.log(Level.ERROR, "Error closing connection", e);
		}
	}

	public Connection takeConnection() throws ConnectionPoolException {
		Connection connection = null;
		try {
			connection = connectionQueue.take();
			givenAwayConQueue.offer(connection);
		} catch (InterruptedException e) {
			throw new ConnectionPoolException("Error connecting to the data source", e);
		}

		return connection;
	}

	public void closeConnection(Connection con, java.sql.Statement st, ResultSet rs) {
		try {
			con.close();
		} catch (SQLException e) {
//			logger.log(Level.ERROR, "Connection isn't return to the pool");
		}

		try {
			rs.close();
		} catch (SQLException e) {
//			logger.log(Level.ERROR, "ResultSet isn't closed");
		}

		try {
			st.close();
		} catch (SQLException e) {
//			logger.log(Level.ERROR, "Statement isn't closed");
		}
	}

	public void closeConnection(Connection con, PreparedStatement ps, ResultSet rs) {
		try {
			con.close();
		} catch (SQLException e) {
//			logger.log(Level.ERROR, "Connection isn't return to the pool");
		}

		try {
			rs.close();
		} catch (SQLException e) {
//			logger.log(Level.ERROR, "ResultSet isn't closed");
		}

		try {
			ps.close();
		} catch (SQLException e) {
//			logger.log(Level.ERROR, "Statement isn't closed");
		}
	}

	public void closeConnection(Connection con, java.sql.Statement st) {
		try {
			con.close();
		} catch (SQLException e) {
//			logger.log(Level.ERROR, "Connection isn't return to the pool");
		}

		try {
			st.close();
		} catch (SQLException e) {
//			logger.log(Level.ERROR, "Statement isn't closed");
		}
	}

	public void closeConnection(Connection con) {
		try {
			con.close();
		} catch (SQLException e) {
//			logger.log(Level.ERROR, "Connection isn't return to the pool");
		}
	}

	@SuppressWarnings("null")
	private void closeConnectionsQueue(BlockingQueue<Connection> queue) throws SQLException {
		Connection connection;
		while ((connection = queue.poll()) != null) {
			connection.commit();
		}
		((PooledConnection) connection).reallyClose();
	}

	private class PooledConnection implements Connection {
		private Connection connection;

		public PooledConnection(Connection con) throws SQLException {
			this.connection = con;
			this.connection.setAutoCommit(true);
		}

		public void reallyClose() throws SQLException {
			connection.close();
		}

		public void clearWarnings() throws SQLException {
			connection.clearWarnings();
		}

		public void close() throws SQLException {
			if (connection.isClosed()) {
				throw new SQLException("Attempting to close closed connection");
			}

			if (connection.isReadOnly()) {
				connection.setReadOnly(false);
			}

			if (!givenAwayConQueue.remove(this)) {
				throw new SQLException("Error deleting connection from the " + "given away connection pool");
			}

			if (!connectionQueue.offer(this)) {
				throw new SQLException("Error allocating connection in the pool");
			}

		}

		public void commit() throws SQLException {
			connection.commit();
		}

		public Array createArrayOf(String typeName, Object[] elements) throws SQLException {
			return connection.createArrayOf(typeName, elements);
		}

		public Blob createBlob() throws SQLException {
			return connection.createBlob();
		}

		public Clob createClob() throws SQLException {
			return connection.createClob();
		}

		public NClob createNClob() throws SQLException {
			return connection.createNClob();
		}

		public SQLXML createSQLXML() throws SQLException {
			return connection.createSQLXML();
		}

		public java.sql.Statement createStatement() throws SQLException {
			return connection.createStatement();
		}

		public java.sql.Statement createStatement(int resultSetType, int resultSetConcurrency) throws SQLException {
			return connection.createStatement(resultSetType, resultSetConcurrency);
		}

		public java.sql.Statement createStatement(int resultSetType, int resultSetConcurrency, int resultSetHoldability)
				throws SQLException {
			return connection.createStatement(resultSetType, resultSetConcurrency, resultSetHoldability);
		}

		public Struct createStruct(String typeName, Object[] attributes) throws SQLException {
			return connection.createStruct(typeName, attributes);
		}

		@Override
		public boolean isWrapperFor(Class<?> iface) throws SQLException {
			return connection.isWrapperFor(iface);
		}

		@Override
		public <T> T unwrap(Class<T> iface) throws SQLException {
			return connection.unwrap(iface);
		}

		@Override
		public void abort(Executor executor) throws SQLException {
			connection.abort(executor);
		}

		@Override
		public boolean getAutoCommit() throws SQLException {
			return connection.getAutoCommit();
		}

		@Override
		public String getCatalog() throws SQLException {
			return connection.getCatalog();
		}

		@Override
		public Properties getClientInfo() throws SQLException {
			return connection.getClientInfo();
		}

		@Override
		public String getClientInfo(String name) throws SQLException {
			return connection.getClientInfo(name);
		}

		@Override
		public int getHoldability() throws SQLException {
			return connection.getHoldability();
		}

		@Override
		public DatabaseMetaData getMetaData() throws SQLException {
			return connection.getMetaData();
		}

		@Override
		public int getNetworkTimeout() throws SQLException {
			return connection.getNetworkTimeout();
		}

		@Override
		public String getSchema() throws SQLException {
			return connection.getSchema();
		}

		@Override
		public int getTransactionIsolation() throws SQLException {
			return connection.getTransactionIsolation();
		}

		@Override
		public Map<String, Class<?>> getTypeMap() throws SQLException {
			return connection.getTypeMap();
		}

		@Override
		public SQLWarning getWarnings() throws SQLException {
			return connection.getWarnings();
		}

		@Override
		public boolean isClosed() throws SQLException {
			return connection.isClosed();
		}

		@Override
		public boolean isReadOnly() throws SQLException {
			return connection.isReadOnly();
		}

		@Override
		public boolean isValid(int timeout) throws SQLException {
			return connection.isValid(timeout);
		}

		@Override
		public String nativeSQL(String sql) throws SQLException {
			return connection.nativeSQL(sql);
		}

		@Override
		public CallableStatement prepareCall(String sql) throws SQLException {
			return connection.prepareCall(sql);
		}

		@Override
		public CallableStatement prepareCall(String sql, int resultSetType, int resultSetConcurrency)
				throws SQLException {
			return connection.prepareCall(sql, resultSetType, resultSetConcurrency);
		}

		@Override
		public CallableStatement prepareCall(String sql, int resultSetType, int resultSetConcurrency,
				int resultSetHoldability) throws SQLException {
			return connection.prepareCall(sql, resultSetType, resultSetConcurrency, resultSetHoldability);
		}

		@Override
		public PreparedStatement prepareStatement(String sql) throws SQLException {
			return connection.prepareStatement(sql);
		}

		@Override
		public PreparedStatement prepareStatement(String sql, int autoGeneratedKeys) throws SQLException {
			return connection.prepareStatement(sql, autoGeneratedKeys);
		}

		@Override
		public PreparedStatement prepareStatement(String sql, int[] columnIndexes) throws SQLException {
			return connection.prepareStatement(sql, columnIndexes);
		}

		@Override
		public PreparedStatement prepareStatement(String sql, String[] columnNames) throws SQLException {
			return connection.prepareStatement(sql, columnNames);
		}

		@Override
		public PreparedStatement prepareStatement(String sql, int resultSetType, int resultSetConcurrency)
				throws SQLException {
			return connection.prepareStatement(sql, resultSetType, resultSetConcurrency);
		}

		@Override
		public PreparedStatement prepareStatement(String sql, int resultSetType, int resultSetConcurrency,
				int resultSetHoldability) throws SQLException {
			return connection.prepareStatement(sql, resultSetType, resultSetConcurrency, resultSetHoldability);
		}

		@Override
		public void releaseSavepoint(Savepoint savepoint) throws SQLException {
			connection.releaseSavepoint(savepoint);

		}

		@Override
		public void rollback() throws SQLException {
			connection.rollback();

		}

		@Override
		public void rollback(Savepoint savepoint) throws SQLException {
			connection.rollback(savepoint);

		}

		@Override
		public void setAutoCommit(boolean autoCommit) throws SQLException {
			connection.setAutoCommit(autoCommit);

		}

		@Override
		public void setCatalog(String catalog) throws SQLException {
			connection.setCatalog(catalog);

		}

		@Override
		public void setClientInfo(Properties properties) throws SQLClientInfoException {
			connection.setClientInfo(properties);

		}

		@Override
		public void setClientInfo(String name, String value) throws SQLClientInfoException {
			connection.setClientInfo(name, value);

		}

		@Override
		public void setHoldability(int holdability) throws SQLException {
			connection.setHoldability(holdability);

		}

		@Override
		public void setNetworkTimeout(Executor executor, int milliseconds) throws SQLException {
			connection.setNetworkTimeout(executor, milliseconds);

		}

		@Override
		public void setReadOnly(boolean readOnly) throws SQLException {
			connection.setReadOnly(readOnly);

		}

		@Override
		public Savepoint setSavepoint() throws SQLException {
			return connection.setSavepoint();
		}

		@Override
		public Savepoint setSavepoint(String name) throws SQLException {

			return connection.setSavepoint(name);
		}

		@Override
		public void setSchema(String schema) throws SQLException {
			connection.setSchema(schema);

		}

		@Override
		public void setTransactionIsolation(int level) throws SQLException {
			connection.setTransactionIsolation(level);

		}

		@Override
		public void setTypeMap(Map<String, Class<?>> map) throws SQLException {
			connection.setTypeMap(map);

		}

	}

}
