package com.zafu.engineersystem.mapper;

import com.zafu.engineersystem.pojo.SalaryInfo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface SalaryInfoMapper {
    //查询所有工程师工资信息
    List<SalaryInfo> getAllEngSalary();

    //更新工程师工资信息
    int updateSalary(SalaryInfo salaryInfo);

    //计算工程师工资
    int caculatSalary(SalaryInfo salaryInfo);

    //根据工程师工号查询工程师信息
    SalaryInfo getEngSalaryById(int engineerId);
}
