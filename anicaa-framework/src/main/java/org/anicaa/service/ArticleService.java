package org.anicaa.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.anicaa.domain.ResponseResult;
import org.anicaa.domain.entity.Article;

public interface ArticleService extends IService<Article> {
    ResponseResult<Article> hotArticleList();

    ResponseResult articleList(Integer pageNum, Integer pageSize, Long categoryId);

    ResponseResult getArticleContent(Long id);
}
