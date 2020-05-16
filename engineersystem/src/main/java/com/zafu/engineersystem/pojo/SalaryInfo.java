package com.zafu.engineersystem.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SalaryInfo {
    private int engineerId;

    @Length(max=10, message = "姓名超出范围长度，不能大于10")
    private String engineerName;

    @Min(value = 0,message = "基本薪水不能小于0")
    private double engineerSalary;

    @Min(value = 0, message = "月有效工作日天数有误，不能小于0")
    @Max(value = 31, message = "月有效工作日天数有误，不能大于31")
    private int engineerWorkday;

    @Min(value = 0, message = "月效益有误，月效益不能小于0")
    private double engineerKpi;

    @Min(value = 0,message = "工作年限有误，工作年限不能小于0")
    private int engineerSeniority;

    @Min(value = 0,message = "月保险金额有误，月保险金不能小于0")
    private double engineerInsurance;

    private double engineerFinalsalary;
}
