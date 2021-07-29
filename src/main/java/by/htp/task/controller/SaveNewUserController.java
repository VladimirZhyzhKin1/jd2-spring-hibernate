package by.htp.task.controller;

import by.htp.task.entity.User;
import by.htp.task.service.ServiceException;
import by.htp.task.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletException;
import java.io.IOException;

import static by.htp.task.controller.ControllerLevelConstant.*;

@Controller
@RequestMapping("/AnonymousController")
public class SaveNewUserController {

    @Autowired
    private UserService userService;

    @RequestMapping(params = {"command=savenewuser"})
    public String execute(@ModelAttribute("User") User user, Model theModel) throws ServletException, IOException, ServiceException {
        try {

            System.out.println(user.toString());

            userService.createUser(user);
            theModel.addAttribute(MESSAGE, "Registration completed successfully");
            return REDIRECT_PREFIX + REDIRECT_FROM_SAVE_NEW_USER_TO_GO_TO_INDEX_PAGE;
        } catch (ServiceException e) {
            theModel.addAttribute(MESSAGE, e.getMessage());
            return REDIRECT_PREFIX + REDIRECT_FROM_SAVE_NEW_USER_TO_REGISTRATION_PAGE;
        }
    }
}

