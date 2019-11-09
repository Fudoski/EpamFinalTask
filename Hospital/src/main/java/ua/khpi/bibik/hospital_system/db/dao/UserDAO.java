package ua.khpi.bibik.hospital_system.db.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collections;
import java.util.List;

import ua.khpi.bibik.hospital_system.db.connectionpool.ConnectionPool;
import ua.khpi.bibik.hospital_system.db.connectionpool.exception.ConnectionPoolException;
import ua.khpi.bibik.hospital_system.db.dao.exception.DAOException;
import ua.khpi.bibik.hospital_system.db.sql.SQLField;
import ua.khpi.bibik.hospital_system.db.sql.SQLQuery;
import ua.khpi.bibik.hospital_system.entity.user.User;

public class UserDAO extends AbstractDAO<User> {

	@Override
	public User insert(User entity) {
		throw new UnsupportedOperationException();
	}

	@Override
	public User update(User entity) {
		throw new UnsupportedOperationException();
	}

	@Override
	public User delete(User entity) {
		throw new UnsupportedOperationException();
	}

	@Override
	public List<User> select(User entity) throws DAOException {
		User user = null;
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		String sql = SQLQuery.SELECT_USER_BY_LOGIN;
		try {
			ConnectionPool connectionPool = ConnectionPool.getInstance();
			connection = connectionPool.takeConnection();
			statement = connection.prepareStatement(sql);
			statement.setString(1, entity.getLogin());
			resultSet = statement.executeQuery();
			if (resultSet.next()) {
				user = new User();
				
				user.setId(resultSet.getInt(SQLField.USER_ID));
				user.setLogin(resultSet.getString(SQLField.USER_LOGIN));
				user.setPassword(resultSet.getString(SQLField.USER_PASSWORD));
				user.setName(resultSet.getString(SQLField.USER_NAME));;
				user.setMname(resultSet.getString(SQLField.USER_MIDDLENAME));
				user.setSname(resultSet.getString(SQLField.USER_SURNAME));
				user.setPhoneNum(resultSet.getString(SQLField.USER_PHONE_NUM));
				user.setType(resultSet.getString(SQLField.USER_TYPE));
				user.setDob(resultSet.getString(SQLField.USER_DOB));
			}
		}catch (SQLException | ConnectionPoolException e) {
			throw new DAOException();
		} finally {
			try {
				closeConnection(connection, statement, resultSet);
			}catch (ConnectionPoolException e) {
				e.printStackTrace();
			}
		}
		return Collections.singletonList(user);
	}

	@Override
	public User selectById(int id) {
		// TODO Auto-generated meethod stub
		return null;
	}

}
