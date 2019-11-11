package ua.khpi.bibik.hospital_system.db.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import ua.khpi.bibik.hospital_system.db.connectionpool.ConnectionPool;
import ua.khpi.bibik.hospital_system.db.connectionpool.exception.ConnectionPoolException;
import ua.khpi.bibik.hospital_system.db.dao.exception.DAOException;
import ua.khpi.bibik.hospital_system.db.sql.SQLField;
import ua.khpi.bibik.hospital_system.db.sql.SQLQuery;
import ua.khpi.bibik.hospital_system.entity.medcard.MedicalCard;

public class MedicalCardDAO extends AbstractDAO<MedicalCard> {

	@Override
	public MedicalCard insert(MedicalCard entity) throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MedicalCard update(MedicalCard entity) throws DAOException {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		String sql = SQLQuery.UPDATE_MED_CARD;
		try {
			ConnectionPool connectionPool = ConnectionPool.getInstance();
			connection = connectionPool.takeConnection();
			if (entity.getDoctorID() == 0) {
				sql = SQLQuery.UPDATE_MED_CARD_DEFF;
				statement = connection.prepareStatement(sql);
				statement.setInt(1, entity.getPatientID());
			}else {
				statement = connection.prepareStatement(sql);
				statement.setInt(1, entity.getDoctorID());
				statement.setInt(2, entity.getPatientID());
			}
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

		return entity;
	}

	@Override
	public MedicalCard delete(MedicalCard entity) throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<MedicalCard> select(MedicalCard entity) throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MedicalCard selectById(int id) throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}

	public MedicalCard selectByPatientId(int patientId) throws DAOException {
		MedicalCard card = new MedicalCard();
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		String sql = SQLQuery.SELECT_MED_CARD_FOR_PATIENT;
		try {
			ConnectionPool connectionPool = ConnectionPool.getInstance();
			connection = connectionPool.takeConnection();
			statement = connection.prepareStatement(sql);
			statement.setInt(1, patientId);
			resultSet = statement.executeQuery();
			if (resultSet.next()) {
				card.setId(resultSet.getInt(SQLField.MED_CARD_ONLY_ID));
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

		return card;
	}

}
