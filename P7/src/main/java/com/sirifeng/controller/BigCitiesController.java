package com.sirifeng.controller;

import com.sirifeng.server.BigCitiesServer;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

/**
 * @author SiriFeng
 */
@Controller
public class BigCitiesController {

    @GetMapping("bigCities")
    public ModelAndView getBigCities() {
        ModelAndView modelAndView = new ModelAndView("bigCities.jsp");
        Map<String, String> capitals = BigCitiesServer.getCityCapitals();
        Map<String, String[]> bigCities = BigCitiesServer.getBigCities();
        modelAndView.addObject("capitals", capitals);
        modelAndView.addObject("bigCities", bigCities);
        return modelAndView;
    }
}
