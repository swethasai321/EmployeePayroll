package com.bridgelabz.employeepayroll.controller;

import com.bridgelabz.employeepayroll.dto.ResponseDTO;
import com.bridgelabz.employeepayroll.module.Employee;
import com.bridgelabz.employeepayroll.services.IEmployeeInterface;
import com.bridgelabz.employeepayroll.dto.EmployeeDTO;
import com.bridgelabz.employeepayroll.dto.ResponseDTO;
import com.bridgelabz.employeepayroll.module.Employee;
import com.bridgelabz.employeepayroll.services.EmployeeServices;
import com.bridgelabz.employeepayroll.services.IEmployeeInterface;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;

@Slf4j
@CrossOrigin
@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    IEmployeeInterface iEmployeeInterface;

    @GetMapping("/hello")
    public String sayHello(){
        return "Hello from Bridgelabz";
    }
    /*--------------------Post Operation-------------------*/
    @PostMapping("/add")
    public ResponseEntity<ResponseDTO> addEmployee(@Valid @RequestBody EmployeeDTO employeeDTO){
        Employee newEmployee = new Employee(employeeDTO);
        ResponseDTO responseDTO = new ResponseDTO("Add record  Success", iEmployeeInterface.addEmployee(newEmployee));
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.CREATED);
    }
    /*--------------------Search by Id---------------------*/
    @GetMapping("/search/{id}")
    public ResponseEntity<ResponseDTO> searchById(@PathVariable int id){
        ResponseDTO responseDTO = new ResponseDTO("Record found successfully", iEmployeeInterface.searchById(id));
        return new ResponseEntity<ResponseDTO>(responseDTO,HttpStatus.CREATED);
    }

    /*----------------------Show all records ------------------*/
    @GetMapping("/show")
    public ResponseEntity<ResponseDTO> searchAll(){
        ResponseDTO responseDTO = new ResponseDTO("Getting all the record..", iEmployeeInterface.searchAll());
        return new ResponseEntity<ResponseDTO>(responseDTO,HttpStatus.OK);
    }

    /*-----------------------Edit by ID----------------------*/
    @PutMapping("/edit/{id}")
    public ResponseEntity<ResponseDTO> editById(@Valid @PathVariable int id,@RequestBody EmployeeDTO employeeDTO){
        ResponseDTO responseDTO = new ResponseDTO("Update success", iEmployeeInterface.editById(id,employeeDTO));
        return new ResponseEntity<ResponseDTO>(responseDTO,HttpStatus.OK);
    }

    /*-----------------------Delete by Id---------------------*/

    @DeleteMapping("/remove/{id}")
    public ResponseEntity<ResponseDTO> removeById(@PathVariable int id) {
        Employee employee = new Employee(id);
        ResponseDTO responseDTO = new ResponseDTO("Record found and removed successfull", iEmployeeInterface.removeById(id));
        return new ResponseEntity<ResponseDTO>(responseDTO,HttpStatus.OK);
    }

    /*------------------------Find Department by ID ----------*/
    @GetMapping("/depatment/{department}")
    public ResponseEntity<ResponseDTO> getEmployeeByDepartment(@PathVariable("department") String department){
        List<Employee> employeeList = iEmployeeInterface.getEmployeeByDepartment(department);
        ResponseDTO responseDTO = new ResponseDTO("Get Call for ID successful",employeeList);
        return new ResponseEntity<>(responseDTO,HttpStatus.OK);
//        ResponseDTO responseDTO = new ResponseDTO("Get Call for ID successful", iEmployeeInterface.getEmployeeByDepartment(department));
//        return new ResponseEntity<ResponseDTO>(responseDTO,HttpStatus.CREATED);
    }
}
