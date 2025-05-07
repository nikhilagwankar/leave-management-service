package com.example;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

@Service
public class EmployeeService {
    private final Map<String, Employee> employeeRepository = new HashMap<>();

    public Employee getEmployee(String firstName, String lastName) {
        return employeeRepository.get(firstName + " " + lastName);
    }

    public int getLeaveBalance(String firstName, String lastName) {
        Employee employee = getEmployee(firstName, lastName);
        return employee != null ? employee.getLeaveBalance() : 0;
    }

    public String applyForLeave(String firstName, String lastName, LocalDate leaveDate) {
        Employee employee = getEmployee(firstName, lastName);
        if (employee == null) {
            return "Employee not found.";
        }

        if (employee.getLeaveBalance() <= 0) {
            return "Insufficient leave balance.";
        }

        employee.addLeaveDate(leaveDate);
        employee.setLeaveBalance(employee.getLeaveBalance() - 1);
        return "Leave applied successfully.";
    }

    public void addEmployee(Employee employee) {
        employeeRepository.put(employee.getFirstName() + " " + employee.getLastName(), employee);
    }
}