package org.anicaa.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.anicaa.domain.ResponseResult;
import org.anicaa.domain.entity.Link;


/**
 * 友链(Link)表服务接口
 *
 * @author Jason Zhu
 * @since 2023-04-29 21:48:22
 */
public interface LinkService extends IService<Link> {

    ResponseResult getAllLink();
}

