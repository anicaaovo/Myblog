package org.anicaa.Controller;

import org.anicaa.domain.ResponseResult;
import org.anicaa.domain.entity.Article;
import org.anicaa.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/article")
public class ArticleController {
    @Autowired
    ArticleService articleService;

    @GetMapping("/test")
    public List<Article> test(){
        return articleService.list();
    }

    @GetMapping("/articleList")
    public ResponseResult articleList(Integer pageNum, Integer pageSize, Long categoryId){
        return articleService.articleList(pageNum, pageSize, categoryId);
    }

    @GetMapping("/hotArticleList")
    public ResponseResult hotArticles(){
        return articleService.hotArticleList();
    }

    @GetMapping("/{id}")
    public ResponseResult getArticleContent(@PathVariable("id") Long id){
        return articleService.getArticleContent(id);
    }
}
