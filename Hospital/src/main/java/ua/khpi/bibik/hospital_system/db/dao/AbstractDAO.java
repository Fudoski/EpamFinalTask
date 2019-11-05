package ua.khpi.bibik.hospital_system.db.dao;

import java.sql.Connection;
import java.sql.ResultSet;

import ua.khpi.bibik.hospital_system.db.connectionpool.ConnectionPool;
import ua.khpi.bibik.hospital_system.db.connectionpool.exception.ConnectionPoolException;
import ua.khpi.bibik.hospital_system.db.dao.exception.DAOException;
import ua.khpi.bibik.hospital_system.entity.Entity;

public abstract class AbstractDAO<E extends Entity> {

	public abstract E insert(E entity) throws DAOException;

	public abstract E update(E entity) throws DAOException;

	public abstract E delete(E entity) throws DAOException;

	public abstract E find(E entity) throws DAOException;

	public abstract E selectById(int id) throws DAOException;
	
	protected static void closeConnection(Connection connection,
			java.sql.PreparedStatement statement, ResultSet rs)
			throws ConnectionPoolException {
		ConnectionPool.getInstance().closeConnection(connection, statement, rs);

	}

}
