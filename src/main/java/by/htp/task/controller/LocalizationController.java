package by.htp.task.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.ServletException;
import java.io.IOException;

import static by.htp.task.controller.ControllerLevelConstant.*;

@Controller
@RequestMapping(value = {"/AnonymousController", "/Controller", "/AdminController"})
public class LocalizationController {

    @RequestMapping(params = {"command=localization"})

    public String execute(@RequestParam("commandRedirect") String commandForRedirect) throws ServletException, IOException {

        return REDIRECT_PREFIX + commandForRedirect;
    }
}
