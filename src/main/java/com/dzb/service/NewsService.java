package com.dzb.service;

import com.dzb.domain.News;
import com.dzb.utils.PageBean;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author 邓志斌
 * @version 1.0
 * @date 2021/3/16 9:50
 */
public interface NewsService {

    PageBean<News> findNewsByPage(String keywords, Integer newsListCategoryId,
                                  Integer currentPAge, Integer pageSize);

    // 根据新闻ID获取新闻
    News getNewsByNewsId(Integer newsId);

    // 添加新闻
    int addNews(News news);

    // 更新新闻
    int updateNews(News news);

    // 设置新闻状态(1:发布，2：撤稿）
    int setNewsPublishStatus(News news);

    // 删除新闻
    int delNews(Integer newsId);
}
