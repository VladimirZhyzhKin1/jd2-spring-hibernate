package by.htp.task.controller;

import by.htp.task.entity.News;
import by.htp.task.service.NewsService;
import by.htp.task.service.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletException;
import java.io.IOException;
import java.security.Principal;
import java.util.List;

import static by.htp.task.controller.ControllerLevelConstant.*;

@Controller
@RequestMapping("/Controller")
public class GoToMainPageController {

    private final NewsService newsService;

    @Autowired
    public GoToMainPageController(NewsService newsService) {
        this.newsService = newsService;
    }

    @RequestMapping(params = {"command=gotomainpage"})
    public String execute(Model theModel, Principal principal) throws ServletException, IOException, ServiceException {

        List<News> news = newsService.takeAll();

        theModel.addAttribute(NEWS_ATTRIBUTE, news);

        return REQUESTDISPATCHER_FROM_GO_TO_MAIN_PAGE_TO_MAIN;
    }
}
