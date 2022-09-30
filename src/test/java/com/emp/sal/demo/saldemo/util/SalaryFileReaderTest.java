package com.emp.sal.demo.saldemo.util;

import com.emp.sal.demo.saldemo.exception.InvalidMonthException;
import com.emp.sal.demo.saldemo.repo.EmployeeRepository;
import com.emp.sal.demo.saldemo.service.SalaryService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import static org.junit.jupiter.api.Assertions.assertThrows;

class SalaryFileReaderTest {
    SalaryFileReader salaryFileReader = new SalaryFileReader();
    SalaryService salaryService;
    @Mock
    EmployeeRepository employeeRepository;

    @BeforeEach
    void intit() {
        salaryService = new SalaryService(employeeRepository);
    }

    @Test
    void getEmployeesByIncorrectMonth() {
        String month = "1245";
        assertThrows(InvalidMonthException.class, () -> salaryService.getEmployeesByMonth("abc"));
    }

    @Test
    void loadDataTest() {


    }


}