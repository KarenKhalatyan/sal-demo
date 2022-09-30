package com.emp.sal.demo.saldemo.util;

import com.emp.sal.demo.saldemo.Report;
import com.emp.sal.demo.saldemo.exception.FileException;
import com.emp.sal.demo.saldemo.model.Employee;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class SalaryFileReader {
    private static final String delimiter = "--";
    private static final String[] MONTHS = {"january", "february", "march", "april", "may", "june", "jule", "august", "september", "november", "december"};
    static Logger logger = LoggerFactory.getLogger(SalaryFileReader.class);

    public static List<Employee> loadData() {
        File file = new File("./csv");
        String mnt = "";
        BufferedReader br = null;
        String line = "";
        BigDecimal exchange = BigDecimal.ONE;
        List<Employee> employeeList = new ArrayList<>();
        try {
            for (File fileEntry : file.listFiles()) {
                for (String name : MONTHS) {
                    if (fileEntry.getName().toLowerCase().contains(name)) {
                        mnt = name;
                    }
                }
                br = new BufferedReader(new FileReader("./csv/" + fileEntry.getName()));
                line = br.readLine();
                while ((line = br.readLine()) != null) {
                    String[] arr = line.split(",");
                    Employee emp = new Employee();
                    BigDecimal rate = RateFileReader.getRateInGel();
                    rate = rate.multiply(new BigDecimal(arr[1]));
                    emp.setSalary(rate);
                    emp.setFullname(arr[0]);
                    emp.setMonth(mnt);
                    employeeList.add(emp);
                }

            }

        } catch (IOException ex) {
            logger.info("error while reading csv files " + ex.getMessage());
            throw new FileException("no file found in /csv/ dir with name containing" + String.join(delimiter, MONTHS));
        }
        return employeeList;
    }

    public static List<Report> getReport(List<Employee> src) {
        final Map<String, List<Employee>> collect = src.stream().collect(Collectors.groupingBy(t -> t.getMonth()));
        List<Report> reports = new ArrayList<>();
        for (Map.Entry<String, List<Employee>> e : collect.entrySet()) {
            Report r = new Report();
            r.setMonth(e.getKey());
            for (Employee em : e.getValue()) {
                BigDecimal b = em.getSalary();
                b = b.add(r.getSum());
                r.setSum(b);
            }
            reports.add(r);
        }
        return reports;
    }


}



