package com.archis.empapp.controller;

import org.springframework.web.bind.annotation.*;

import com.archis.empapp.dto.Employee;

@RestController
@RequestMapping("/emp")
public class EmpController {

    @GetMapping(value = "/{id}")
    public String getName(@PathVariable("id") Long id){
        System.out.println("Employee Id from request : " + id);
        return "myName";
    }

    @PostMapping
    public String create(@RequestBody Employee employee) {
        System.out.println("Employee name from request : " + employee.getName());
        return employee.getLocation();
    }

}
