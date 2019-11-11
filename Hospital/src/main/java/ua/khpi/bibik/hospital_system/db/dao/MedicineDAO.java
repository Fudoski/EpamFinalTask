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
import ua.khpi.bibik.hospital_system.entity.medcard.appointment.Medicine;
import ua.khpi.bibik.hospital_system.entity.model.MedicineDataModel;
import ua.khpi.bibik.hospital_system.entity.model.ProcedureDataModel;

public class MedicineDAO extends AbstractDAO<Medicine> {

	@Override
	public Medicine insert(Medicine entity) throws DAOException {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		String sql = SQLQuery.ADD_MEDICINE;
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
			throw new DAOException();
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
	public Medicine update(Medicine entity) throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Medicine delete(Medicine entity) throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Medicine> select(Medicine entity) throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Medicine selectById(int id) throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Medicine> selectFromList(int medListID) throws DAOException {
		List<Medicine> medicines = new ArrayList<Medicine>();
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		String sql = SQLQuery.SELECT_MEDICINE_FROM_LIST;
		try {
			ConnectionPool connectionPool = ConnectionPool.getInstance();
			connection = connectionPool.takeConnection();
			statement = connection.prepareStatement(sql);
			statement.setInt(1, medListID);
			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				Medicine medicine = new Medicine();

				medicine.setId(resultSet.getInt(SQLField.MEDICINE_ID));
				medicine.setDiscription(resultSet.getString(SQLField.MEDICINE_DESCRIPTION));
				medicine.setMedStaffID(resultSet.getInt(SQLField.MEDICINE_MED_STAFF_ID));

				medicines.add(medicine);
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

		return medicines;
	}

	public int insertToList(List<Medicine> mList) throws DAOException {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		String sql = SQLQuery.INSERT_MEDICINE_TO_LIST_DEFAULT;
		int listId = -1;
		try {
			ConnectionPool connectionPool = ConnectionPool.getInstance();
			connection = connectionPool.takeConnection();
			for(int i = 0; i <mList.size(); i++) {
				Medicine m = mList.get(i);
				if (i == 0) {
					statement = connection.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
					statement.setInt(1, m.getId());
					statement.executeUpdate();
					resultSet = statement.getGeneratedKeys();
					if (resultSet.next()) {
						listId = resultSet.getInt(1);
					}
				}else {
					sql = SQLQuery.INSERT_MEDICINE_TO_LIST;
					statement = connection.prepareStatement(sql);
					statement.setInt(1, listId);
					statement.setInt(2, m.getId());
					statement.executeUpdate();
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

	public List<MedicineDataModel> selectFromProcView() throws DAOException {
		List<MedicineDataModel> medicineDataModels = new ArrayList<MedicineDataModel>();
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
				MedicineDataModel model = new MedicineDataModel();
				
				model.setPatientID(resultSet.getInt(SQLField.VIEW_MODEL_PATIEN_ID));
				model.setDoctorID(resultSet.getInt(SQLField.VIEW_MODEL_DOC_ID));
				model.setMedicineDesc(resultSet.getString(SQLField.VIEW_MODEL_DESCRIPTION));
				model.setMedicineID(resultSet.getInt(SQLField.VIEW_MODEL_APPOINTMENT_ID));
				
				medicineDataModels.add(model);
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
		return medicineDataModels;
	}

}
