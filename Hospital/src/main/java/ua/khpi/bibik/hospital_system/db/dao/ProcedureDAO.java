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
import ua.khpi.bibik.hospital_system.entity.medcard.appointment.Medicine;
import ua.khpi.bibik.hospital_system.entity.medcard.appointment.Procedure;

public class ProcedureDAO extends AbstractDAO<Procedure> {

	@Override
	public Procedure insert(Procedure entity) throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Procedure update(Procedure entity) throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Procedure delete(Procedure entity) throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Procedure> select(Procedure entity) throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Procedure selectById(int id) throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Procedure> selectFromList(int procListID) throws DAOException {
		List<Procedure> procedures = new ArrayList<Procedure>();
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		String sql = SQLQuery.SELECT_PROCEDURE_FROM_LIST;
		try {
			ConnectionPool connectionPool = ConnectionPool.getInstance();
			connection = connectionPool.takeConnection();
			statement = connection.prepareStatement(sql);
			statement.setInt(1, procListID);
			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				Procedure procedure = new Procedure();
				
				procedure.setId(resultSet.getInt(SQLField.PROC_ID));
				procedure.setDiscription(resultSet.getString(SQLField.PROC_DESCRIPTION));
				procedure.setMedStaffID(resultSet.getInt(SQLField.PROCEDURE_MED_STAFF_ID));
				
				procedures.add(procedure);
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

		return procedures;
	}

}
