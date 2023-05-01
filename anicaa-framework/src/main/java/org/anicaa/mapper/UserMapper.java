package org.anicaa.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.anicaa.domain.entity.User;
import org.apache.ibatis.annotations.Mapper;


/**
 * 用户表(SysUser)表数据库访问层
 *
 * @author Jason Zhu
 * @since 2023-04-29 22:32:29
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {

}

