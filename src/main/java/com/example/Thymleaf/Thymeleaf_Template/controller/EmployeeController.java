package com.example.Thymleaf.Thymeleaf_Template.controller;

import com.example.Thymleaf.Thymeleaf_Template.model.Employee;
import com.example.Thymleaf.Thymeleaf_Template.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class EmployeeController {

    @Autowired
    private EmployeeRepository employeeRepository;

    @GetMapping({"/employees", "/", "/list"})
    public ModelAndView showEmployees(){
        ModelAndView modelAndView = new ModelAndView( "list-employees");
        List<Employee> employeeList = employeeRepository.findAll();
        modelAndView.addObject("employees", employeeList);
        return modelAndView;
    }

    @GetMapping("/addEmployee")
    public ModelAndView addEmployeeForm(){
        ModelAndView modelAndView = new ModelAndView("employee-form");
        Employee employee = new Employee();
        modelAndView.addObject("employee", employee);
        return modelAndView;
    }


    @PostMapping("/saveEmployee")
    public String saveEmployee(@ModelAttribute Employee employee){
        employeeRepository.save(employee);
        return "redirect:/list";
    }

    @GetMapping("/updateEmployee")
    public ModelAndView updateEmployee(@RequestParam Long employeeId){
        ModelAndView modelAndView = new ModelAndView("employee-form");
        Employee employee = employeeRepository.findById(employeeId).orElseThrow();
        modelAndView.addObject("employee", employee);
        return modelAndView;
    }

    @GetMapping("/deleteEmployee")
    public String deleteEmployee(@RequestParam Long employeeId){
        employeeRepository.deleteById(employeeId);
        return "redirect:/list";
    }


}
