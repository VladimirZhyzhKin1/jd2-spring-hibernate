package by.htp.task.controller;

import by.htp.task.entity.News;
import by.htp.task.service.NewsService;
import by.htp.task.service.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletException;
import java.io.IOException;
import java.security.Principal;

import static by.htp.task.controller.ControllerLevelConstant.*;

@Controller
@RequestMapping("/AdminController")
public class DeleteNewsController {

    @Autowired
    private NewsService newsService;

    @RequestMapping(params = {"command=delete_news"})
    public String execute(@ModelAttribute("id") News news, Model theModel, Principal principal) throws ServletException, IOException, ServiceException {

        newsService.deleteNews(news.getId());

        theModel.addAttribute(MESSAGE, "News was deleted");

        return REDIRECT_PREFIX + REDIRECT_FROM_DELETE_NEWS_TO_MAIN_PAGE;
    }
}
