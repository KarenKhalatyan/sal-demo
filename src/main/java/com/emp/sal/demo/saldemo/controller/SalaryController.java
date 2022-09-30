package com.emp.sal.demo.saldemo.controller;

import com.emp.sal.demo.saldemo.Report;
import com.emp.sal.demo.saldemo.model.Employee;
import com.emp.sal.demo.saldemo.service.SalaryService;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@ApiOperation("Salary controller operations")
public class SalaryController {

    final SalaryService salaryService;

    public SalaryController(SalaryService salaryService) {
        this.salaryService = salaryService;
    }

    @GetMapping("/employees/{month}")
    @ApiOperation("get persons salary by  month " + "[january,february,march,april,may,june, jule,august,september,november,december]")
    public List<Employee> getAllEmployees(@PathVariable String month) {
        List<Employee> employeeList = salaryService.getEmployeesByMonth(month);
        return employeeList;
    }

    @GetMapping("/report")
    @ApiOperation("Summary report ")
    public List<Report> getReport() {
        return salaryService.getAll();
    }

    @PostMapping("/load")
    @ApiOperation("load files into database")
    public String loadEmployees() {
        return salaryService.loadAllEmployees();
    }
}
