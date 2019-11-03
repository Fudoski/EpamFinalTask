package ua.khpi.bibik.hospital_system.db.dao.factory;

import ua.khpi.bibik.hospital_system.db.dao.AbstractDAO;
import ua.khpi.bibik.hospital_system.db.dao.exception.DAOException;

public interface DAOFactory {
	
	public interface DaoCreator {

		@SuppressWarnings("rawtypes")
		public AbstractDAO create();
	}

	@SuppressWarnings("rawtypes")
	public AbstractDAO getDao(Class dtoClass) throws DAOException;
}
