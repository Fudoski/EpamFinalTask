package ua.khpi.bibik.hospital_system.db.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import ua.khpi.bibik.hospital_system.db.connectionpool.ConnectionPool;
import ua.khpi.bibik.hospital_system.db.connectionpool.exception.ConnectionPoolException;
import ua.khpi.bibik.hospital_system.db.dao.exception.DAOException;
import ua.khpi.bibik.hospital_system.db.sql.SQLField;
import ua.khpi.bibik.hospital_system.db.sql.SQLQuery;
import ua.khpi.bibik.hospital_system.entity.medcard.appointment.Procedure;
import ua.khpi.bibik.hospital_system.entity.model.ProcedureDataModel;

public class ProcedureDAO extends AbstractDAO<Procedure> {

	@Override
	public Procedure insert(Procedure entity) throws DAOException {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		String sql = SQLQuery.ADD_PROC;
		try {
			ConnectionPool connectionPool = ConnectionPool.getInstance();
			connection = connectionPool.takeConnection();
			statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			statement.setString(1, entity.getDiscription());
			int rows = statement.executeUpdate();
			
			resultSet = statement.getGeneratedKeys();
			if (resultSet.next()) {
				entity.setId(resultSet.getInt(1));
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

	public int insertToList(List<Procedure> pList) throws DAOException {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		String sql = SQLQuery.INSERT_PROCEDURE_TO_LIST_DEFAULT;
		int listId = -1;
		try {
			ConnectionPool connectionPool = ConnectionPool.getInstance();
			connection = connectionPool.takeConnection();
			for(int i = 0; i <pList.size(); i++) {
				Procedure p = pList.get(i);
				if (i == 0) {
					statement = connection.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
					statement.setInt(1, p.getId());
					statement.executeUpdate();
					resultSet = statement.getGeneratedKeys();
					if (resultSet.next()) {
						listId = resultSet.getInt(1);
					}
				}else {
					sql = SQLQuery.INSERT_PROCEDURE_TO_LIST;
					statement = connection.prepareStatement(sql);
					statement.setInt(1, listId);
					statement.setInt(2, p.getId());
				}
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
		return listId;
	}

	public List<ProcedureDataModel> selectFromProcView() throws DAOException {
		List<ProcedureDataModel> procedures = new ArrayList<ProcedureDataModel>();
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		String sql = SQLQuery.SELECT_PROC_VIEW;
		try {
			ConnectionPool connectionPool = ConnectionPool.getInstance();
			connection = connectionPool.takeConnection();
			statement = connection.prepareStatement(sql);
			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				ProcedureDataModel model = new ProcedureDataModel();
				
				model.setPatientID(resultSet.getInt(SQLField.VIEW_MODEL_PATIEN_ID));
				model.setDoctorID(resultSet.getInt(SQLField.VIEW_MODEL_DOC_ID));
				model.setProcDesc(resultSet.getString(SQLField.VIEW_MODEL_DESCRIPTION));
				model.setProcID(resultSet.getInt(SQLField.VIEW_MODEL_APPOINTMENT_ID));
				
				procedures.add(model);
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
