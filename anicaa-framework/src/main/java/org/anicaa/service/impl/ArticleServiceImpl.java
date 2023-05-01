package org.anicaa.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.anicaa.constants.SystemConstants;
import org.anicaa.domain.vo.ArticleContentVo;
import org.anicaa.domain.ResponseResult;
import org.anicaa.domain.entity.Article;
import org.anicaa.domain.entity.Category;
import org.anicaa.domain.vo.HotArticleVo;
import org.anicaa.domain.vo.PageVo;
import org.anicaa.domain.vo.SingleDisplayArticleVo;
import org.anicaa.mapper.ArticleMapper;
import org.anicaa.service.ArticleService;
import org.anicaa.service.CategoryService;
import org.anicaa.utils.BeanCopyUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class ArticleServiceImpl extends ServiceImpl<ArticleMapper, Article> implements ArticleService {
    @Autowired
    private CategoryService categoryService;

    @Override
    public ResponseResult hotArticleList() {
        LambdaQueryWrapper<Article> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        //1. 不能是草稿
        lambdaQueryWrapper.eq(Article::getStatus, SystemConstants.ARTICLE_STATUS_NORMAL);
        //2. 浏览量前十
        Page<Article> page = new Page<>(SystemConstants.PAGE_START, SystemConstants.PAGE_END);
        //3. 降序排序
        lambdaQueryWrapper.orderByDesc(Article::getViewCount);
        page(page, lambdaQueryWrapper);
        List<Article> articleList = page.getRecords();
        List<HotArticleVo> hotArticleVos = BeanCopyUtils.copyBeanList(articleList, HotArticleVo.class);
        return ResponseResult.okResult(hotArticleVos);
    }

    @Override
    public ResponseResult articleList(Integer pageNum, Integer pageSize, Long categoryId) {
        //  查询条件
        LambdaQueryWrapper<Article> queryWrapper = new LambdaQueryWrapper<>();
        //  如果 有categoryId 就要 查询时要和传入的相同
        queryWrapper.eq(Objects.nonNull(categoryId) && categoryId > 0, Article::getCategoryId, categoryId);
        //  状态是正式发布的
        queryWrapper.eq(Article::getStatus, SystemConstants.ARTICLE_STATUS_NORMAL);
        //  对isTop进行降序
        queryWrapper.orderByDesc(Article::getIsTop);
        //  分页查询
        Page<Article> page = new Page<>(pageNum, pageSize);
        page(page, queryWrapper);
        List<Article> articleList = page.getRecords();
        for (Article article : articleList) {
            Category category = categoryService.getById(article.getCategoryId());
            article.setCategoryName(category.getName());
        }
        //  封装查询结果
        List<SingleDisplayArticleVo> singleDisplayArticleVos = BeanCopyUtils.copyBeanList(articleList,
                SingleDisplayArticleVo.class);
        PageVo pageVo = new PageVo(singleDisplayArticleVos, page.getTotal());
        return ResponseResult.okResult(pageVo);
    }

    @Override
    public ResponseResult getArticleContent(Long id) {
        Article article = getById(id);
        ArticleContentVo articleContentVo = BeanCopyUtils.copyBean(article, ArticleContentVo.class);
        Category category = categoryService.getById(article.getCategoryId());
        if (category != null) {
            articleContentVo.setCategoryName(category.getName());
        }
        return ResponseResult.okResult(articleContentVo);
    }
}

