package org.anicaa.Controller;

import org.anicaa.domain.ResponseResult;
import org.anicaa.domain.entity.User;
import org.anicaa.service.BlogLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class BlogLoginController {
    @Autowired
    BlogLoginService blogLoginService;
    @PostMapping("/login")
    public ResponseResult login(@RequestBody Map<String, String> userInfo){
        System.out.println(userInfo.get("username") + "aaaaaaaaa");
        System.out.println(userInfo.get("password") + "aaaaaaaaa");
        return blogLoginService.login(userInfo);
    }

}
