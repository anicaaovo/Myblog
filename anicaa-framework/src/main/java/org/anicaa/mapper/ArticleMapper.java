package org.anicaa.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.anicaa.domain.entity.Article;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ArticleMapper extends BaseMapper<Article> {
}
