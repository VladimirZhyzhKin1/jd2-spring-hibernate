package by.htp.task.controller;

import by.htp.task.service.ServiceException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletException;
import java.io.IOException;

import static by.htp.task.controller.ControllerLevelConstant.REQUESTDISPATCHER_FROM_GO_TO_ERROR_PAGE_TO_ERROR_PAGE;

@Controller
@RequestMapping(value = {"/AnonymousController", "/Controller", "/AdminController"})
public class GoToErrorPageController {

    @RequestMapping(params = {"command=go_to_error_page"})
    public String execute() throws ServletException, IOException, ServiceException {

        return REQUESTDISPATCHER_FROM_GO_TO_ERROR_PAGE_TO_ERROR_PAGE;
    }
}
