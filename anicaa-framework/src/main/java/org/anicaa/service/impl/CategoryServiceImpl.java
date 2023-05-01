package org.anicaa.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.anicaa.constants.SystemConstants;
import org.anicaa.domain.ResponseResult;
import org.anicaa.domain.entity.Article;
import org.anicaa.domain.entity.Category;
import org.anicaa.domain.vo.CategoryVo;
import org.anicaa.mapper.CategoryMapper;
import org.anicaa.service.ArticleService;
import org.anicaa.service.CategoryService;
import org.anicaa.utils.BeanCopyUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * 分类表(Category)表服务实现类
 *
 * @author Jason Zhu
 * @since 2023-04-28 21:35:41
 */
@Service("categoryService")
public class CategoryServiceImpl extends ServiceImpl<CategoryMapper, Category> implements CategoryService {

    @Autowired
    private ArticleService articleService;

    @Override
    public ResponseResult getCategoryList() {
        QueryWrapper<Article> articleQueryWrapper = new QueryWrapper<>();
        //  1. 先查询文章表， 状态为已发布的文章。
        articleQueryWrapper.lambda().eq(Article::getStatus, SystemConstants.ARTICLE_STATUS_NORMAL);
        //  2 获取文章的分类id，并且去重。
        List<Article> articleList = articleService.list(articleQueryWrapper);
        Set<Long> categoryIds = articleList.stream()
                .map(Article::getCategoryId)
                .collect(Collectors.toSet());
        //  3. 查询分类表，必须可用分类。
        List<Category> categoryList = listByIds(categoryIds);
        categoryList = categoryList.stream().
                filter(category -> SystemConstants.CATEGORY_STATUS_NORMAL.equals(Integer.parseInt(category.getStatus())))
                .collect(Collectors.toList());
        //  4. 封装vo
        List<CategoryVo> categoryVos = BeanCopyUtils.copyBeanList(categoryList, CategoryVo.class);
        return ResponseResult.okResult(categoryVos);
    }
}

