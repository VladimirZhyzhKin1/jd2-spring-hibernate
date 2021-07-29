package by.htp.task.controller;

import by.htp.task.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletException;
import java.io.IOException;
import java.security.Principal;

import static by.htp.task.controller.ControllerLevelConstant.*;

@Controller
@RequestMapping("/AnonymousController")
public class GoToRegistrationPageController {

    @RequestMapping(params = {"command=registration"})
    public String execute(Model theModel, Principal principal) throws ServletException, IOException {
        User user = new User();
        theModel.addAttribute(USER, user);

        return REQUESTDISPATCHER_FROM_GO_TO_REGISTRATION_PAGE_TO_REGISTRATION;
    }
}
