package com.sirifeng.controller;

import com.sirifeng.entity.Employee;
import com.sirifeng.entity.User;
import com.sirifeng.service.ElService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;

@Controller
public class ElController {

    @GetMapping("/show-el")
    public ModelAndView showEl() {
        ElService elService = new ElService();
        ModelAndView modelAndView = new ModelAndView("/demo1_table.jsp");

        //获取数组数据
        String[] arrs = elService.getString();
        modelAndView.addObject("arrs",arrs);

        //获取list数据
        List<String> list = elService.getList();
        modelAndView.addObject("list",list);

        //获取map集合数据
        Map<String,String> map = elService.getMap();
        modelAndView.addObject("map",map);

        //获取对象数据
        User user = elService.getUser();
        modelAndView.addObject("user",user);

        Map<String,User> userMap = elService.getUserMap();
        modelAndView.addObject("empMap",userMap);

        return modelAndView;
    }

}
