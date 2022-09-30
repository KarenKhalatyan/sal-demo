package com.emp.sal.demo.saldemo.repo;

import com.emp.sal.demo.saldemo.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    List<Employee> getEmployeeByMonth(String month);
}
