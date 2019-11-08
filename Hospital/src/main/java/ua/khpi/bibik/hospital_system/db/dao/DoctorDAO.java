package ua.khpi.bibik.hospital_system.db.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ua.khpi.bibik.hospital_system.db.connectionpool.ConnectionPool;
import ua.khpi.bibik.hospital_system.db.connectionpool.exception.ConnectionPoolException;
import ua.khpi.bibik.hospital_system.db.dao.exception.DAOException;
import ua.khpi.bibik.hospital_system.db.sql.SQLField;
import ua.khpi.bibik.hospital_system.db.sql.SQLQuery;
import ua.khpi.bibik.hospital_system.entity.user.Doctor;

public class DoctorDAO extends AbstractDAO<Doctor> {

	@Override
	public Doctor insert(Doctor entity) throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Doctor update(Doctor entity) throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Doctor delete(Doctor entity) throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Doctor selectById(int id) throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Doctor> select(Doctor entity) throws DAOException {

		List<Doctor> doctors = new ArrayList<Doctor>();
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		String sql = SQLQuery.SELECT_ALL_DOCTORS;
		try {
			ConnectionPool connectionPool = ConnectionPool.getInstance();
			connection = connectionPool.takeConnection();
			statement = connection.prepareStatement(sql);
			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				Doctor doctor = new Doctor();
				doctor.setId(resultSet.getInt(SQLField.USER_ID));
				doctor.setLogin(resultSet.getString(SQLField.USER_LOGIN));
				doctor.setPassword(resultSet.getString(SQLField.USER_PASSWORD));
				doctor.setName(resultSet.getString(SQLField.USER_NAME));
				doctor.setMname(resultSet.getString(SQLField.USER_MIDDLENAME));
				doctor.setSname(resultSet.getString(SQLField.USER_SURNAME));
				doctor.setPhoneNum(resultSet.getString(SQLField.USER_PHONE_NUM));
				doctor.setDoctorSpecialisation(resultSet.getString(SQLField.DOCTOR_SPEC));
				doctor.setAmountOfPatients(resultSet.getInt(SQLField.DOCTOR_PATIENTS));
				doctors.add(doctor);
			}
		} catch (SQLException | ConnectionPoolException e) {
			throw new DAOException();
		} finally {
			try {
				closeConnection(connection, statement, resultSet);
			} catch (ConnectionPoolException e) {
				e.printStackTrace();
			}
		}

		return doctors;
	}

}
