package com.emp.sal.demo.saldemo;

import java.math.BigDecimal;

public class Report {
    private String month;
    private BigDecimal sum = BigDecimal.ZERO;

    public Report() {
    }

    public Report(String month, BigDecimal sum) {
        this.month = month;
        this.sum = sum;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public BigDecimal getSum() {
        return sum;
    }

    public void setSum(BigDecimal sum) {
        this.sum = sum;
    }
}
