package com.springboot.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import net.javaguides.springboot.service.EmployeeService;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    // display list of employees
    @GetMapping("/")
    public String viewHomePage(Model model) {
     model.addAttribute("listEmployees", employeeService.getAllEmployees());   // <tr th:each="employee : ${listEmployees}"> 
     return "index";
    }
} 