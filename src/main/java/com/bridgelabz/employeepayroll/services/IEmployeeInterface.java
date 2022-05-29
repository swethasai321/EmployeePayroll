package com.bridgelabz.employeepayroll.services;

import com.bridgelabz.employeepayroll.dto.EmployeeDTO;
import com.bridgelabz.employeepayroll.module.Employee;

import java.util.List;

public interface IEmployeeInterface{

    String removeById(int id);

    String editById(int id, EmployeeDTO employee);

    List<Employee> getEmployeeByDepartment(String department);
    List<Employee> searchAll();

    Employee searchById(int id);

    Employee addEmployee(Employee employee);
}


