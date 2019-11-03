package ua.khpi.bibik.hospital_system.db.dao.factory;

import ua.khpi.bibik.hospital_system.db.dao.AbstractDAO;
import ua.khpi.bibik.hospital_system.db.dao.exception.DAOException;
import ua.khpi.bibik.hospital_system.entity.Entity;

public interface DAOFactory<E extends Entity> {
	
	public interface DaoCreator<E extends Entity> {

		public AbstractDAO<E> create();
	}

	public AbstractDAO<E> getDao(Class<E> dtoClass) throws DAOException;
}
