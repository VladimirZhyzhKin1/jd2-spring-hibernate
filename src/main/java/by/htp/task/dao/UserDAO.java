package by.htp.task.dao;

import by.htp.task.entity.User;

public interface UserDAO {

	User authorization (String login, String password) throws DAOException;

	User loadUser (String login) throws DAOException;

	void createUser(User userInfo) throws DAOException;
}
