package org.anicaa.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.anicaa.domain.ResponseResult;
import org.anicaa.domain.entity.Category;


/**
 * 分类表(Category)表服务接口
 *
 * @author Jason Zhu
 * @since 2023-04-28 21:35:40
 */
public interface CategoryService extends IService<Category> {

    ResponseResult getCategoryList();
}

