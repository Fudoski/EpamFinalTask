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
import ua.khpi.bibik.hospital_system.entity.medcard.appointment.Appointment;
import ua.khpi.bibik.hospital_system.entity.medcard.appointment.Operation;

public class AppointmentDAO extends AbstractDAO<Appointment> {

	@Override
	public Appointment insert(Appointment entity) throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Appointment update(Appointment entity) throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Appointment delete(Appointment entity) throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Appointment> select(Appointment entity) throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Appointment selectById(int id) throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Appointment> select(MedicalCard card) throws DAOException {
		List<Appointment> appointments = new ArrayList<Appointment>();
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		String sql = SQLQuery.SELECT_MED_CARD_APPOINTMENTS;
		try {
			ConnectionPool connectionPool = ConnectionPool.getInstance();
			connection = connectionPool.takeConnection();
			statement = connection.prepareStatement(sql);
			statement.setInt(1, card.getId());
			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				Appointment appointment = new Appointment();
				appointment.setId(resultSet.getInt(SQLField.APPOINTMENT_ID));
				appointment.setDoctorID(resultSet.getInt(SQLField.APPOINTMENT_DOC_ID));
				appointment.setMedcardID(resultSet.getInt(SQLField.APPOINTMENT_MC_ID));
				appointment.setMedListID(resultSet.getInt(SQLField.APPOINTMENT_MEDLIST_ID));
				appointment.setProcListID(resultSet.getInt(SQLField.APPOINTMENT_PROCLIST_ID));
				appointment.getOperation().setId(resultSet.getInt(SQLField.APPOINTMENT_OPERATION_ID));
				appointment.setOperatineDate(resultSet.getString(SQLField.APPOINTMENT_DATE));
				appointment.setDiagnosis(resultSet.getString(SQLField.APPOINTMENT_DIAGNOSIS));
				
				Operation op = getOperation(appointment.getOperation().getId());
				appointment.setOperation(op);
				appointments.add(appointment);
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

		return appointments;
	}

	private Operation getOperation(int id) throws DAOException {
		Operation operation = null;
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		String sql = SQLQuery.SELECT_OPERATION_BY_ID;
		try {
			ConnectionPool connectionPool = ConnectionPool.getInstance();
			connection = connectionPool.takeConnection();
			statement = connection.prepareStatement(sql);
			statement.setInt(1, id);
			resultSet = statement.executeQuery();
			if (resultSet.next()) {
				operation = new Operation();
				
				operation.setDiscription(resultSet.getString(SQLField.OPERATION_DESCRIPTION));
				operation.setId(resultSet.getInt(SQLField.OPERATION_ID));
				operation.setOperationStartDateTime(resultSet.getString(SQLField.OPERATION_STAR_DT));
				operation.setOperationEndDateTime(resultSet.getString(SQLField.OPERATION_ENT_DT));
				operation.setDoctorID(resultSet.getInt(SQLField.OPERATION_DOC_ID));
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

		return operation;
	}

}
