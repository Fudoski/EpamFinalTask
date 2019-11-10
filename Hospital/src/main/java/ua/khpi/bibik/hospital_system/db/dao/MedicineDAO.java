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

public class MedicineDAO extends AbstractDAO<Medicine> {

	@Override
	public Medicine insert(Medicine entity) throws DAOException {
		// TODO Auto-generated method stub
		return null;
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

}
