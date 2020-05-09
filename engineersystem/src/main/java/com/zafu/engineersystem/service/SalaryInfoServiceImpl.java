package com.zafu.engineersystem.service;
import com.zafu.engineersystem.mapper.SalaryInfoMapper;
import com.zafu.engineersystem.pojo.SalaryInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SalaryInfoServiceImpl implements SalaryInfoService{
    @Autowired
    SalaryInfoMapper salaryInfoMapper;

    @Override
    public List<SalaryInfo> getAllEngSalary() {
        return salaryInfoMapper.getAllEngSalary();
    }

    @Override
    public SalaryInfo getEngSalaryById(int engineerId) {
        return salaryInfoMapper.getEngSalaryById(engineerId);
    }

    @Override
    public int updateSalary(SalaryInfo salaryInfo) { return salaryInfoMapper.updateSalary(salaryInfo); }

    @Override
    public int caculatSalary(SalaryInfo salaryInfo) { return salaryInfoMapper.caculatSalary(salaryInfo); }

}
