package com.zafu.engineersystem.service;

import com.zafu.engineersystem.pojo.SalaryInfo;

import java.util.List;

public interface SalaryInfoService {
    List<SalaryInfo> getAllEngSalary();

    SalaryInfo getEngSalaryById(int engineerId);

    int updateSalary(SalaryInfo salaryInfo);

    int caculatSalary(SalaryInfo salaryInfo);
}
