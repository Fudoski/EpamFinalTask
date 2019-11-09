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
import ua.khpi.bibik.hospital_system.entity.DoctorSpecialization;

public class DoctorSpecializationDAO extends AbstractDAO<DoctorSpecialization> {

	@Override
	public DoctorSpecialization insert(DoctorSpecialization entity) throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DoctorSpecialization update(DoctorSpecialization entity) throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DoctorSpecialization delete(DoctorSpecialization entity) throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<DoctorSpecialization> select(DoctorSpecialization entity) throws DAOException {
		List<DoctorSpecialization> specializations = new ArrayList<DoctorSpecialization>();
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		String sql = SQLQuery.SELECT_ALL_DOCTOR_SPEC;
		try {
			ConnectionPool connectionPool = ConnectionPool.getInstance();
			connection = connectionPool.takeConnection();
			statement = connection.prepareStatement(sql);
			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				DoctorSpecialization spec = new DoctorSpecialization();
				spec.setId(resultSet.getInt(SQLField.DOCTOR_SPEC_ID));
				spec.setName(resultSet.getString(SQLField.DOCTOR_SPEC_NAME));
				specializations.add(spec);
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

		return specializations;
	}

	@Override
	public DoctorSpecialization selectById(int id) throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}

}
