package com.dzb.dao;

import com.dzb.domain.News;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author 邓志斌
 * @version 1.0
 * @date 2021/3/16 9:45
 */
public interface NewsDao {

    //获取当前类别信息数量
    int getNewsCount(@Param("keywords") String keywords, @Param("newsListCategoryId") Integer newsListCategoryId);

    //获取当前类别信息列表
    List<News> findNewsList(@Param("keywords") String keywords,
                            @Param("newsListCategoryId") Integer newsListCategoryId,
                            @Param("startRows") Integer startRows,
                            @Param("pageSize") Integer pageSize);

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
