package com.bridgelabz.employeepayroll.services;

import com.bridgelabz.employeepayroll.dto.EmployeeDTO;
import com.bridgelabz.employeepayroll.exceptionHandling.EmployeeException;
import com.bridgelabz.employeepayroll.module.Employee;
import com.bridgelabz.employeepayroll.repository.EmployeeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class EmployeeServices implements IEmployeeInterface{

    @Autowired
    EmployeeRepository employeeRepository;

    public Employee addEmployee(Employee employee) {
        Employee newEmployee = new Employee(employee);
        employeeRepository.save(newEmployee);
        return newEmployee;
    }

    public Employee searchById(int id) {
        if (employeeRepository.findById(id).isPresent()){
            Employee newEmployee = new Employee(id);
            return newEmployee;
        }
        else throw (new EmployeeException("record not Found"));
    }

    public List<Employee> searchAll() {
        return employeeRepository.findAll();
    }

    public String editById(int id, EmployeeDTO employeeDTO) {
        if (employeeRepository.findById(id).isPresent()) {
            Employee newEmployee = new Employee(id, employeeDTO);
            Employee search = employeeRepository.save(newEmployee);
            return "Done " + search;
        }
        else throw (new EmployeeException("Wrong input"));
    }

    @Override
    public List<Employee> getEmployeeByDepartment(String department) {
        return employeeRepository.findEmployeeByDepartment(department);
    }

    public String removeById(int id) {
        Optional<Employee> newEmployee = employeeRepository.findById(id);
        if (newEmployee.isPresent()){
            employeeRepository.delete(newEmployee.get());
            return "Record is deleted with id " +id;
        }
        else throw (new EmployeeException("Record not Found"));
    }
}


