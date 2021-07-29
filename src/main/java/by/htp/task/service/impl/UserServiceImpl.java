package by.htp.task.service.impl;

import by.htp.task.dao.DAOException;
import by.htp.task.dao.UserDAO;
import by.htp.task.entity.User;
import by.htp.task.service.ServiceException;
import by.htp.task.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import static by.htp.task.service.impl.validatorIncomingData.ValidationDataForAuthorisation.validateDataForAuthorisation;
import static by.htp.task.service.impl.validatorIncomingData.ValidationDataForRegistration.validateDataForRegistration;

@Service
public class UserServiceImpl implements UserService, UserDetailsService {

    @Autowired
    private UserDAO userDAO;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = null;
        try {
            user = userDAO.loadUser(username);
        } catch (DAOException e) {
            throw new UsernameNotFoundException(e.getMessage(), e);
        }
        UserBuilder builder = null;
        if (user != null) {
            builder = org.springframework.security.core.userdetails.User.withUsername(user.getName());
            builder.password(user.getPassword());
            String[] roles = new String[]{user.getRole()};
            builder.roles(roles);
        } else {
            throw new UsernameNotFoundException("User not found.");
        }
        return builder.build();
    }

    @Override
    public User authorization(String login, String password) throws ServiceException {

        if (!validateDataForAuthorisation(login, password)) {
            throw new ServiceException("wrong login or password");
        }

        User user = null;
        try {
            user = userDAO.authorization(login, password);
        } catch (DAOException e) {
            throw new ServiceException(e.getMessage(), e);
        }
        return user;
    }

    @Override
    public void createUser(User userInfo) throws ServiceException {

        String name = userInfo.getName();
        String surname = userInfo.getSurname();
        String email = userInfo.getEmail();
        String login = userInfo.getEmail();
        String password = userInfo.getPassword();

        if (!validateDataForRegistration(name, surname, email, login, password)) {
            throw new ServiceException("incorrect data entered");
        }

        try {
            userDAO.createUser(userInfo);
        } catch (DAOException e) {
            throw new ServiceException(e.getMessage(), e);
        }
    }
}
