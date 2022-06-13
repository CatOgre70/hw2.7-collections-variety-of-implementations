package com.example.hw2_7collectionsvarietyofimplementations.model;

import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    private final Map<String, Employee> employees;

    public EmployeeServiceImpl() {

        employees = new HashMap<>();
        employees.put("IvanIvanov", new Employee("Ivan", "Ivanov"));
        employees.put("PetrPetrov", new Employee("Petr","Petrov"));
        employees.put("SidorSidorov", new Employee("Sidor", "Sidorov"));
        employees.put("AfanasiiUkupnikov", new Employee("Afanasii", "Ukupnikov"));
        employees.put("MariaMariaskina", new Employee("Maria", "Mariaskina"));
        employees.put("ElenaFedotova", new Employee("Elena", "Fedotova"));
        employees.put("AfanasiiMorozov", new Employee("Afanasii", "Morozov"));
        employees.put("VasilyAlibabaev", new Employee("Vasily", "Alibabaev"));
        employees.put("SemenGorbunkov", new Employee("Semen", "Gorbunkov"));
        employees.put("SvetlanaFedotova", new Employee("Svetlana", "Fedotova"));

    }


    @Override
    public Employee addEmployee(String firstName, String lastName) {

        Employee e = new Employee(firstName, lastName);
        String key = e.getKey();
        if(employees.containsKey(key))
            throw new EmployeeAlreadyAddedException("Employee is already added into the database!");
        employees.put(key, e);
        return employees.get(key);
    }

    @Override
    public Employee removeEmployee(String firstName, String lastName) {
        Employee e = new Employee(firstName, lastName);
        String key = e.getKey();
        if(employees.containsKey(key)){
            employees.remove(key);
            return e;
        } else {
            throw new EmployeeNotFoundException("Employee is not found in the database");
        }
    }

    @Override
    public Employee findEmployee(String firstName, String lastName) {
        Employee e = new Employee(firstName, lastName);
        String key = e.getKey();
        if(employees.containsKey(key)){
            return employees.get(key);
        } else {
            throw new EmployeeNotFoundException("Employee is not found in the database");
        }
    }

    @Override
    public Employee[] allEmployeeList() {
        Employee[] employeeArray = new Employee[employees.size()];
        Set<Map.Entry<String, Employee>> pairSet = employees.entrySet();
        int i = 0;
        for(Map.Entry<String, Employee> pair : pairSet) {
            employeeArray[i++] = pair.getValue();
        }
        return employeeArray;
    }
}
