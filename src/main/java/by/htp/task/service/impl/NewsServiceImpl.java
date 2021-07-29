package by.htp.task.service.impl;

import by.htp.task.dao.DAOException;
import by.htp.task.dao.NewsDAO;
import by.htp.task.entity.News;
import by.htp.task.service.NewsService;
import by.htp.task.service.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NewsServiceImpl implements NewsService {

    @Autowired
    private NewsDAO newsDAO;

    @Override
    public List<News> takeAll() throws ServiceException {

        List<News> news;

        try {
            news = newsDAO.all();
        } catch (DAOException e) {
            throw new ServiceException(e.getMessage(), e);
        }
        return news;
    }

    @Override
    public News getOne(int id) throws ServiceException {

        News oneNews = null;

        try {
            oneNews = newsDAO.getOne(id);

        } catch (DAOException e) {
            throw new ServiceException(e.getMessage(), e);
        }
        return oneNews;
    }

    @Override
    public void updateNews(int id, String title, String brief, String content) throws ServiceException {

        try {
            newsDAO.updateNews(id, title, brief, content);

        } catch (DAOException e) {
            throw new ServiceException(e.getMessage(), e);
        }
    }

    @Override
    public void deleteNews(int id) throws ServiceException {

        try {
            newsDAO.deleteNews(id);

        } catch (DAOException e) {
            throw new ServiceException(e.getMessage(), e);
        }
    }
}
