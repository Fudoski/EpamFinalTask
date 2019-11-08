package ua.khpi.bibik.hospital_system.service;

import java.util.List;

import ua.khpi.bibik.hospital_system.db.dao.UserDAO;
import ua.khpi.bibik.hospital_system.db.dao.exception.DAOException;
import ua.khpi.bibik.hospital_system.db.dao.factory.MySQLDAOFactory;
import ua.khpi.bibik.hospital_system.entity.user.User;

public class UserService {

	public static User getUserByLogin(String login) {
		try {
			UserDAO userDAO = (UserDAO) MySQLDAOFactory.getInstance().getDao(User.class);
			User user = new User();
			user.setLogin(login);
			List<User> list = userDAO.select(user);
			user = list.get(0);
			return user;
		} catch (DAOException e) {
			e.printStackTrace();
		}		
		return null;
	}

}
