package com.emp.sal.demo.saldemo;


import com.emp.sal.demo.saldemo.model.Employee;
import com.emp.sal.demo.saldemo.util.SalaryFileReader;

import java.util.List;

public class Test {
    private static final String[] MONTHS = {"january", "february", "march", "april", "may", "june", "jule", "august", "september", "november", "december"};

    public static void main(String[] args) {

        List<Employee> employeeList = SalaryFileReader.loadData();
        System.out.println(employeeList.size());

    }
}