package com.emp.sal.demo.saldemo.service;

import com.emp.sal.demo.saldemo.Report;
import com.emp.sal.demo.saldemo.exception.DataNotFound;
import com.emp.sal.demo.saldemo.exception.InvalidMonthException;
import com.emp.sal.demo.saldemo.model.Employee;
import com.emp.sal.demo.saldemo.repo.EmployeeRepository;
import com.emp.sal.demo.saldemo.util.SalaryFileReader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class SalaryService {
    private static final String[] MONTHS = {"january", "february", "march", "april", "may", "june", "jule", "august", "september", "november", "december"};
    final EmployeeRepository employeeRepository;
    Logger logger = LoggerFactory.getLogger(SalaryService.class);

    public SalaryService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public List<Employee> getEmployeesByMonth(String month) {
        logger.info(">>>>>>>>>>> Start getting employees by month >>>>>>>>>>>>>>>");
        boolean isPresent = Arrays.stream(MONTHS).anyMatch(month.toLowerCase()::equals);
        if (!isPresent) {
            logger.info("invalid month" + month);
            throw new InvalidMonthException("invalid month " + month);
        }
        List<Employee> employeeList = employeeRepository.getEmployeeByMonth(month.toLowerCase());
        System.out.println(employeeList);
        if (employeeList == null || employeeList.isEmpty()) {
            logger.info("data not  found" + month);
            throw new DataNotFound("no data for this  month " + month);
        }
        logger.info(">>>>>>>>>>> End of getting employees by month >>>>>>>>>>>>>>>");
        return employeeList;
    }

    public List<Report> getAll() {
        logger.info(">>>>>>>>>>> Start getting report  >>>>>>>>>>>>>>>");

        List<Employee> employeeList = employeeRepository.findAll();
        List<Report> reportList = SalaryFileReader.getReport(employeeList);

        logger.info(">>>>>>>>>>> End of getting report  >>>>>>>>>>>>>>>");
        return reportList;
    }

    public String loadAllEmployees() {
        logger.info(">>>>>>>>>>> Start loading csv data  >>>>>>>>>>>>>>>");
        List<Employee> employeeList = null;

        employeeRepository.deleteAll();
        employeeList = SalaryFileReader.loadData();

        for (Employee e : employeeList) {
            employeeRepository.save(e);
        }

        logger.info(">>>>>>>>>>> End of loading csv data  >>>>>>>>>>>>>>>");
        return "files have been loaded";
    }
}
