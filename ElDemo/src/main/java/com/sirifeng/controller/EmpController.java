package com.sirifeng.controller;

import com.sirifeng.entity.Employee;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author SiriFeng
 */
@Controller
public class EmpController {

    @PostMapping("/show-employee")
    public ModelAndView displayEmployee(Employee employee) {
        ModelAndView modelAndView = new ModelAndView("/display-employee.jsp");
        modelAndView.addObject("employee",employee);
        return modelAndView;
    }


}
