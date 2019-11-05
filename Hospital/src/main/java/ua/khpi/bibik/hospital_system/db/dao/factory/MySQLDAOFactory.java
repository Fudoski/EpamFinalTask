package ua.khpi.bibik.hospital_system.db.dao.factory;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReentrantLock;

import ua.khpi.bibik.hospital_system.db.dao.AbstractDAO;
import ua.khpi.bibik.hospital_system.db.dao.PatientDAO;
import ua.khpi.bibik.hospital_system.db.dao.UserDAO;
import ua.khpi.bibik.hospital_system.db.dao.exception.DAOException;
import ua.khpi.bibik.hospital_system.entity.user.Patient;
import ua.khpi.bibik.hospital_system.entity.user.User;

public class MySQLDAOFactory implements DAOFactory {

	/**
	 * constant used to lock monitor
	 */

	private static final ReentrantLock lock = new ReentrantLock();

	/**
	 * instance of dao factory
	 */

	private static MySQLDAOFactory instance;

	/**
	 * contains Class object of entity and dao crator pair
	 */

	@SuppressWarnings("rawtypes")
	private Map<Class, DaoCreator> creators;

	private MySQLDAOFactory() {
		creators = new HashMap<>();
		
		creators.put(Patient.class, () -> new PatientDAO());
		creators.put(User.class, () -> new UserDAO());
	}

	public static MySQLDAOFactory getInstance() {
		if (instance == null) {
			try {
				lock.lock();
				if (instance == null) {
					instance = new MySQLDAOFactory();
				}
			} finally {
				lock.unlock();
			}
		}

		return instance;
	}

	@SuppressWarnings("rawtypes")
	@Override
	public AbstractDAO getDao(Class dtoClass) throws DAOException {
		DaoCreator creator = creators.get(dtoClass);
		if (creator == null) {
			throw new DAOException("Dao object for " + dtoClass + " not found.");
		}
		return creator.create();
	}
}
