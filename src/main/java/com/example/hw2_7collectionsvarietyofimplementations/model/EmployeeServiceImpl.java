package com.example.hw2_7collectionsvarietyofimplementations.model;

import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    private final Map<String, Employee> employees;
    IdDatabase idDb;

    public EmployeeServiceImpl() {

        idDb = new IdDatabase();
        employees = new HashMap<>();
        employees.put(idDb.generateNewId(), new Employee("Ivan", "Ivanov"));
        employees.put(idDb.generateNewId(), new Employee("Petr","Petrov"));
        employees.put(idDb.generateNewId(), new Employee("Sidor", "Sidorov"));
        employees.put(idDb.generateNewId(), new Employee("Afanasii", "Ukupnikov"));
        employees.put(idDb.generateNewId(), new Employee("Maria", "Mariaskina"));
        employees.put(idDb.generateNewId(), new Employee("Elena", "Fedotova"));
        employees.put(idDb.generateNewId(), new Employee("Afanasii", "Morozov"));
        employees.put(idDb.generateNewId(), new Employee("Vasily", "Alibabaev"));
        employees.put(idDb.generateNewId(), new Employee("Semen", "Gorbunkov"));
        employees.put(idDb.generateNewId(), new Employee("Svetlana", "Fedotova"));

    }


    @Override
    public Employee addEmployee(String firstName, String lastName) {

        Employee e = new Employee(firstName, lastName);
        if(employees.containsValue(e))
            throw new EmployeeAlreadyAddedException("Employee is already added into the database!");
        employees.put(idDb.generateNewId(), e);
        return e;
    }

    @Override
    public Employee removeEmployee(String firstName, String lastName) {
        Employee e = new Employee(firstName, lastName);
        Set<Map.Entry<String, Employee>> pairSet = employees.entrySet();
        for(Map.Entry<String, Employee> pair : pairSet) {
            if (e.equals(pair.getValue())){
                    employees.remove(pair.getKey());
                    return e;
            }
        }
        throw new EmployeeNotFoundException("Employee is not found in the database");
    }

    @Override
    public Employee findEmployee(String firstName, String lastName) {
        Employee e = new Employee(firstName, lastName);
        Set<Map.Entry<String, Employee>> pairSet = employees.entrySet();
        for(Map.Entry<String, Employee> pair : pairSet) {
            if (e.equals(pair.getValue())){
                return e;
            }
        }
        throw new EmployeeNotFoundException("Employee is not found in the database");
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
