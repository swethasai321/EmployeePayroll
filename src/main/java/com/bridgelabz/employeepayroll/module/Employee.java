package com.bridgelabz.employeepayroll.module;

import com.bridgelabz.employeepayroll.dto.EmployeeDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity

@AllArgsConstructor
@NoArgsConstructor
public @Data class Employee {


        @Id
        @GeneratedValue
        int id;
        String fullName;
        String profilePic;
        String gender;
//        @ElementCollection
//        @CollectionTable(name = "department",joinColumns = @JoinColumn(name = "id"))
        private String department;
        int salary;
        LocalDate startDate;
        String notes;

        public Employee(int id, Employee employee) {
//                this.id = id;
                this.fullName = employee.fullName;
                this.profilePic = employee.profilePic;
                this.gender = employee.gender;
                this.department = employee.department;
                this.notes = employee.notes;
                this.salary = employee.salary;
                this.startDate = employee.startDate;
        }

        public Employee(int id) {
                this.id = id;
        }

        public Employee(int id, EmployeeDTO employeeDTO) {
//                this.id = id;
                this.fullName = employeeDTO.fullName;
                this.profilePic = employeeDTO.profilePic;
                this.gender = employeeDTO.gender;
                this.department = employeeDTO.department;
                this.notes = employeeDTO.notes;
                this.salary = employeeDTO.salary;
                this.startDate = employeeDTO.startDate;
        }

        public Employee(Employee employee) {
//                this.id = employee.id;
                this.fullName = employee.fullName;
                this.profilePic = employee.profilePic;
                this.gender = employee.gender;
                this.department = employee.department;
                this.notes = employee.notes;
                this.salary = employee.salary;
                this.startDate = employee.startDate;

        }
        public Employee(EmployeeDTO employeeDTO) {
                this.fullName = employeeDTO.fullName;
                this.profilePic = employeeDTO.profilePic;
                this.gender = employeeDTO.gender;
                this.department= employeeDTO.department;
                this.notes = employeeDTO.notes;
                this.salary = employeeDTO.salary;
                this.startDate = employeeDTO.startDate;
        }
}