package by.htp.task.controller;

import by.htp.task.entity.News;
import by.htp.task.entity.User;
import by.htp.task.service.NewsService;
import by.htp.task.service.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;
import java.util.List;

import static by.htp.task.controller.ControllerLevelConstant.*;

@Controller
@RequestMapping("/AnonymousController")
public class GoToIndexPageController {

    @Autowired
    private NewsService newsService;

    @RequestMapping(params = {"command=gotoindexpage"})
    public String execute(Model theModel, Principal principal) throws ServiceException {

        List<News> news = newsService.takeAll();

        theModel.addAttribute(NEWS_ATTRIBUTE, news);

        User user = new User();

        theModel.addAttribute(USER, user);

        return REQUESTDISPATCHER_FROM_GO_TO_INDEX_PAGE_TO_MAIN_INDEX;
    }
}
