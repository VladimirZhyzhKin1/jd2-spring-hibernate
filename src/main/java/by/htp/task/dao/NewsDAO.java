package by.htp.task.dao;

import by.htp.task.entity.News;

import java.util.List;

public interface NewsDAO {

	List<News> all() throws DAOException;

	News getOne(int id) throws DAOException;

	void updateNews(int id, String title, String brief, String content) throws DAOException;

	void deleteNews(int id) throws DAOException;
}
