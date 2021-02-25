package com.archis.empapp.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.bind.annotation.*;

import com.archis.empapp.dto.Employee;

@RestController
@RequestMapping("/emp")
public class EmpController {
    final static Log logger = LogFactory.getLog(EmpController.class);
    @GetMapping(value = "/{id}")
    public String getName(@PathVariable("id") Long id){

        logger.debug("Employee Id from request : " + id);
        return "myName";
    }

    @PostMapping
    public String create(@RequestBody Employee employee) {
        logger.debug("Employee name from request : " + employee.getName());

        return employee.getLocation();
    }

}
