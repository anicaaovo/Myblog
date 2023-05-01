package org.anicaa.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.anicaa.domain.entity.Link;
import org.apache.ibatis.annotations.Mapper;


/**
 * 友链(Link)表数据库访问层
 *
 * @author Jason Zhu
 * @since 2023-04-29 21:48:18
 */
@Mapper
public interface LinkMapper extends BaseMapper<Link> {

}

