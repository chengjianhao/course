package com.zafu.engineersystem.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SalaryInfo {
    private int engineerId;
    private String engineerName;
    private double engineerSalary;
    private int engineerWorkday;
    private double engineerKpi;
    private int engineerSeniority;
    private double engineerInsurance;
}
