package com.sirifeng.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author SiriFeng
 */
@Controller
@RequestMapping("/url")
public class UrlController {

    @GetMapping("/get")
    @ResponseBody
    public String doGet() {

        return "get";
    }

    @PostMapping("/post")
    @ResponseBody
    public String doPost(String username, String password) {
        return "post";
    }
}
