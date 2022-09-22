package com.travary.back.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    // 회원가입
    @PostMapping("/join")
    @ResponseBody
    public String join(@RequestBody User user) { // json 형태 POST
        userService.join(user);
        return "회원가입완료";
    }
}
