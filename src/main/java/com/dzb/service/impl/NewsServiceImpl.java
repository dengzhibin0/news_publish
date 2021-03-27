package com.dzb.service.impl;

import com.dzb.dao.NewsDao;
import com.dzb.domain.News;
import com.dzb.service.NewsService;
import com.dzb.utils.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 邓志斌
 * @version 1.0
 * @date 2021/3/16 9:55
 */
@Service("newsService")
public class NewsServiceImpl implements NewsService {
    @Autowired
    private NewsDao newsDao;

    @Override
    public PageBean<News> findNewsByPage(String keywords, Integer newsListCategoryId, Integer currentPage, Integer pageSize) {
        int count=newsDao.getNewsCount(keywords,newsListCategoryId);
        int totalPage=(int) Math.ceil(count*1.0/pageSize);
        List<News> newsList=newsDao.findNewsList(keywords,newsListCategoryId,(currentPage-1)*pageSize,pageSize);

        PageBean<News> pb=new PageBean<News>();
        pb.setCount(count);
        if(currentPage==0) currentPage=1;
        pb.setCurrentPage(currentPage);

        pb.setList(newsList);
        pb.setPageSize(pageSize);
        pb.setTotalPage(totalPage);
        return pb;
    }


    @Override
    public News getNewsByNewsId(Integer newsId) {
        return newsDao.getNewsByNewsId(newsId);
    }

    @Override
    public int addNews(News news) {
        return newsDao.addNews(news);
    }

    @Override
    public int updateNews(News news) {
        return newsDao.updateNews(news);
    }

    @Override
    public int setNewsPublishStatus(News news) {
        return newsDao.setNewsPublishStatus(news);
    }

    @Override
    public int delNews(Integer newsId) {
        return newsDao.delNews(newsId);
    }
}
