package org.anicaa.service.impl;

import org.anicaa.domain.ResponseResult;
import org.anicaa.domain.entity.LoginUser;
import org.anicaa.domain.entity.User;
import org.anicaa.domain.vo.BlogUserLoginVo;
import org.anicaa.domain.vo.LoginUserVo;
import org.anicaa.service.BlogLoginService;
import org.anicaa.utils.BeanCopyUtils;
import org.anicaa.utils.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class BlogLoginServiceImpl implements BlogLoginService {
    @Autowired
    AuthenticationManager authenticationManager;

    @Override
    public ResponseResult login(Map<String, String> user) {
        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new
                UsernamePasswordAuthenticationToken(user.get("UserName"), user.get("Password"));
        Authentication authentication = authenticationManager.authenticate(usernamePasswordAuthenticationToken);
        LoginUser loginUser = (LoginUser) authentication.getPrincipal();
        String token = JwtUtil.createJWT(loginUser.getUser().getId().toString());
        LoginUserVo loginUserVo = BeanCopyUtils.copyBean(loginUser, LoginUserVo.class);
        BlogUserLoginVo blogUserLoginVo = new BlogUserLoginVo(token, loginUserVo);
        return ResponseResult.okResult(blogUserLoginVo);
    }
}
