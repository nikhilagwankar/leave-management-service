package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/{firstName}/{lastName}")
    public Employee getEmployee(@PathVariable String firstName, @PathVariable String lastName) {
        return employeeService.getEmployee(firstName, lastName);
    }

    @GetMapping("/{firstName}/{lastName}/leave-balance")
    public Map<String, Object> getLeaveBalance(@PathVariable String firstName, @PathVariable String lastName) {
        int leaveBalance = employeeService.getLeaveBalance(firstName, lastName);
        Map<String, Object> response = new HashMap<>();
        response.put("leaveBalance", leaveBalance);
        return response;
    }

    @PostMapping("/{firstName}/{lastName}/apply-leave")
    public Map<String, String> applyForLeave(@PathVariable String firstName, @PathVariable String lastName, @RequestParam String leaveDate) {
        LocalDate date = LocalDate.parse(leaveDate);
        String result = employeeService.applyForLeave(firstName, lastName, date);
        Map<String, String> response = new HashMap<>();
        response.put("message", result);
        return response;
    }

    @PostMapping("/add")
    public Map<String, String> addEmployee(@RequestBody Employee employee) {
        employeeService.addEmployee(employee);
        Map<String, String> response = new HashMap<>();
        response.put("message", "Employee added successfully.");
        return response;
    }
}