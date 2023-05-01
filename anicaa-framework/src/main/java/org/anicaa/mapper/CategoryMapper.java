package org.anicaa.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.anicaa.domain.entity.Category;
import org.apache.ibatis.annotations.Mapper;


/**
 * 分类表(Category)表数据库访问层
 *
 * @author Jason Zhu
 * @since 2023-04-28 21:35:33
 */
@Mapper
public interface CategoryMapper extends BaseMapper<Category> {

}

