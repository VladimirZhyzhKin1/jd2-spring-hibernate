package by.htp.task.service;

import by.htp.task.entity.User;

public interface UserService {

	User authorization (String login, String password) throws ServiceException;

	void createUser(User userInfo) throws ServiceException;
}
