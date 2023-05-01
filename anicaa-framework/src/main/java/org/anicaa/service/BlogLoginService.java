package org.anicaa.service;


import com.baomidou.mybatisplus.extension.service.IService;
import org.anicaa.domain.ResponseResult;
import org.anicaa.domain.entity.User;

import java.util.Map;

public interface BlogLoginService {

    ResponseResult login(Map<String, String> map);
}
