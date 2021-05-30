package com.csgo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BaseController {
    @GetMapping("/index")
    public String index()
    {
        return "index";
    }

    @GetMapping("/welcome")
    public String welcome()
    {
        return "welcome";
    }


}
