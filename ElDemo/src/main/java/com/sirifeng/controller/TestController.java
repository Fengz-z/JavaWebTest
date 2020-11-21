package com.sirifeng.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
public class TestController {

    @GetMapping("/test-el")
    public ModelAndView test() {
        ModelAndView modelAndView = new ModelAndView("/demo1_table.jsp");
        String [] arrs = new String[]{"林圣杰","雷小桥","何法霖","徐伟杰"};
        List<String> list = new ArrayList<>();
        list.add("张三");
        list.add("李四");
        list.add("王五");
        list.add("赵六");
        modelAndView.addObject("arrs",arrs);
        modelAndView.addObject("list",list);
        return modelAndView;
    }
}
