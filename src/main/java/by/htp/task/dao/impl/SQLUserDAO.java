package by.htp.task.dao.impl;

import by.htp.task.dao.DAOException;
import by.htp.task.dao.UserDAO;
import by.htp.task.entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional()
public class SQLUserDAO implements UserDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public User authorization(String login, String password) throws DAOException {
		Session currentSession = sessionFactory.getCurrentSession();
		Query theQuery = currentSession.createQuery("from User where login = '" + login + "' and password = '" + password + "'", User.class);
		User user = new User(); 
		user =(User) theQuery.getSingleResult();
		return user;
	}
	
	@Override
	public User loadUser(String login) throws DAOException {
		Session currentSession = sessionFactory.getCurrentSession();
		Query theQuery = currentSession.createQuery("from User where login = '" + login + "'", User.class);
		User user = new User(); 
		user =(User) theQuery.getSingleResult();
		return user;
	}
	
	@Override
	public void createUser(User user) throws DAOException {
		Session currentSession = sessionFactory.getCurrentSession();
		user.setRole("user");
		currentSession.saveOrUpdate(user);
	}
}
