package com.example;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Employee {
    private String firstName;
    private String lastName;
    private LocalDate dateOfBirth;
    private int leaveBalance;
    private List<LocalDate> leaveDates;

    // Add a no-argument constructor for Jackson deserialization
    public Employee() {
        // Default constructor
    }

    public Employee(String firstName, String lastName, LocalDate dateOfBirth, int leaveBalance) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.leaveBalance = leaveBalance;
        this.leaveDates = new ArrayList<>();
    }

    // Getters and setters
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public int getLeaveBalance() {
        return leaveBalance;
    }

    public void setLeaveBalance(int leaveBalance) {
        this.leaveBalance = leaveBalance;
    }

    public List<LocalDate> getLeaveDates() {
        return leaveDates;
    }

    public void addLeaveDate(LocalDate leaveDate) {
        this.leaveDates.add(leaveDate);
    }
}