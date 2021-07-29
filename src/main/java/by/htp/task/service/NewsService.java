package by.htp.task.service;

import by.htp.task.entity.News;

import java.util.List;

public interface NewsService {

	List <News> takeAll() throws ServiceException;

	News getOne(int id) throws ServiceException;

	void updateNews(int id, String title, String brief, String content) throws ServiceException;

	void deleteNews(int id) throws ServiceException;
}