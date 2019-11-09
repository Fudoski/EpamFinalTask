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
import ua.khpi.bibik.hospital_system.entity.user.Patient;

public class PatientDAO extends AbstractDAO<Patient> {

	@Override
	public Patient insert(Patient entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Patient update(Patient entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Patient delete(Patient entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Patient> select(Patient entity) throws DAOException {
		List<Patient> patients = new ArrayList<Patient>();
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		String sql = SQLQuery.SELECT_ALL_PATIENTS;
		try {
			ConnectionPool connectionPool = ConnectionPool.getInstance();
			connection = connectionPool.takeConnection();
			statement = connection.prepareStatement(sql);
			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				Patient patient = new Patient();
				patient.setId(resultSet.getInt(SQLField.USER_ID));
				patient.setLogin(resultSet.getString(SQLField.USER_LOGIN));
				patient.setPassword(resultSet.getString(SQLField.USER_PASSWORD));
				patient.setName(resultSet.getString(SQLField.USER_NAME));
				patient.setMname(resultSet.getString(SQLField.USER_MIDDLENAME));
				patient.setSname(resultSet.getString(SQLField.USER_SURNAME));
				patient.setPhoneNum(resultSet.getString(SQLField.USER_PHONE_NUM));
				patient.setDob(resultSet.getString(SQLField.USER_DOB));
				patients.add(patient);
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
		return patients;
	}

	@Override
	public Patient selectById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Patient> select(Doctor doctor) throws DAOException {
		List<Patient> patients = new ArrayList<Patient>();
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		String sql = SQLQuery.SLECT_DOC_PATIENTS;
		try {
			ConnectionPool connectionPool = ConnectionPool.getInstance();
			connection = connectionPool.takeConnection();
			statement = connection.prepareStatement(sql);
			statement.setInt(1, doctor.getId());
			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				Patient patient = new Patient();
				patient.setId(resultSet.getInt(SQLField.USER_ID));
				patient.setLogin(resultSet.getString(SQLField.USER_LOGIN));
				patient.setPassword(resultSet.getString(SQLField.USER_PASSWORD));
				patient.setName(resultSet.getString(SQLField.USER_NAME));
				patient.setMname(resultSet.getString(SQLField.USER_MIDDLENAME));
				patient.setSname(resultSet.getString(SQLField.USER_SURNAME));
				patient.setPhoneNum(resultSet.getString(SQLField.USER_PHONE_NUM));
				patient.setDob(resultSet.getString(SQLField.USER_DOB));
				patients.add(patient);
			}
		} catch (SQLException | ConnectionPoolException e) {
			throw new DAOException(e);
		} finally {
			try {
				closeConnection(connection, statement, resultSet);
			} catch (ConnectionPoolException e) {
				e.printStackTrace();
			}
		}
		return patients;
	}

}
