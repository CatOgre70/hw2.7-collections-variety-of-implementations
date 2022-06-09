package com.example.hw2_7collectionsvarietyofimplementations.model;

public interface EmployeeService {

    Employee addEmployee(String firstName, String lastName);
    Employee removeEmployee(String firstName, String lastName);
    Employee findEmployee(String firstName, String lastName);
    Employee[] allEmployeeList();

}
