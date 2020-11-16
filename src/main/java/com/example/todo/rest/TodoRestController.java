package com.example.todo.rest;

import com.example.todo.entities.Employee;
import com.example.todo.input_forms.LoginForm;
import com.example.todo.service.RestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class TodoRestController {

    private RestService restService;

    @Autowired
    public TodoRestController(RestService restService) {
        this.restService = restService;
    }

    @CrossOrigin
    @GetMapping("/login")
    public Employee login(@RequestBody LoginForm loginForm){

        return restService.loginEmployee(loginForm);
    }

    @CrossOrigin
    @GetMapping("/employees")
    public List<Employee> allEmployees(){
        return restService.allEmployees();
    }

}
