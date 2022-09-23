package com.travary.back;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/api")
public class TestController {

    @GetMapping("/test")
    @ResponseBody
    public String test() {
        return "테스트페이지";
    }
}
