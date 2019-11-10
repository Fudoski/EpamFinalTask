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
import ua.khpi.bibik.hospital_system.entity.medcard.MedicalCard;
import ua.khpi.bibik.hospital_system.entity.user.Doctor;
import ua.khpi.bibik.hospital_system.entity.user.Patient;

public class PatientDAO extends AbstractDAO<Patient> {

	@Override
	public Patient insert(Patient patient) throws DAOException {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		String sql = SQLQuery.ADD_NEW_PATIENT;
		try {
			ConnectionPool connectionPool = ConnectionPool.getInstance();
			connection = connectionPool.takeConnection();
			statement = connection.prepareStatement(sql);
			statement.setString(1, patient.getLogin());
			statement.setString(2, patient.getPassword());
			statement.setString(3, patient.getName());
			statement.setString(4, patient.getSname());
			statement.setString(5, patient.getMname());
			statement.setString(6, patient.getPhoneNum());
			statement.setString(7, patient.getDob());
			int rows = statement.executeUpdate();
			
			if (rows != 1) {
				
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
		return patient;
	}

	@Override
	public Patient update(Patient patient) throws DAOException {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		String sql = SQLQuery.UPDATE_PATIENT;
		try {
			ConnectionPool connectionPool = ConnectionPool.getInstance();
			connection = connectionPool.takeConnection();
			statement = connection.prepareStatement(sql);
			statement.setString(1, patient.getLogin());
			statement.setString(2, patient.getPassword());
			statement.setString(3, patient.getName());
			statement.setString(4, patient.getSname());
			statement.setString(5, patient.getMname());
			statement.setString(6, patient.getPhoneNum());
			statement.setString(7, patient.getDob());
			statement.setInt(8, patient.getId());
			int rows = statement.executeUpdate();
			
			if (rows != 1) {
				throw new DAOException();
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

		return patient;
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
	public Patient selectById(int id) throws DAOException {
		Patient patient = new Patient();
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		String sql = SQLQuery.SELECT_PATIENT_INFO_BY_ID;
		try {
			ConnectionPool connectionPool = ConnectionPool.getInstance();
			connection = connectionPool.takeConnection();
			statement = connection.prepareStatement(sql);
			statement.setInt(1, id);
			resultSet = statement.executeQuery();
			if (resultSet.next()) {
				patient.setId(resultSet.getInt(SQLField.USER_ID));
				patient.setLogin(resultSet.getString(SQLField.USER_LOGIN));
				patient.setPassword(resultSet.getString(SQLField.USER_PASSWORD));
				patient.setName(resultSet.getString(SQLField.USER_NAME));
				patient.setMname(resultSet.getString(SQLField.USER_MIDDLENAME));
				patient.setSname(resultSet.getString(SQLField.USER_SURNAME));
				patient.setPhoneNum(resultSet.getString(SQLField.USER_PHONE_NUM));
				patient.setDob(resultSet.getString(SQLField.USER_DOB));
				MedicalCard card = new MedicalCard();
				card.setId(resultSet.getInt(SQLField.MED_CARD_ID));
				card.setDoctorID(resultSet.getInt(SQLField.MED_CARD_DOC_ID));
				patient.setCard(card);
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

		return patient;
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
