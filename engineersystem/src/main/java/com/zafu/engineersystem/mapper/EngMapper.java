package com.zafu.engineersystem.mapper;

import com.zafu.engineersystem.pojo.Engineer;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface EngMapper {

    //查询所有工程师信息
    List<Engineer> getAllEng();

    //排序所有工程师信息（编号升序）
    List<Engineer> getAllEngOrderByIdAsc();

    //排序所有工程师信息（姓名升序）
    List<Engineer> getAllEngOrderByNameAsc();

    //排序所有工程师信息（工龄降序）
    List<Engineer> getAllEngOrderBySeniorityDesc();

    //新增工程师信息
    int addEng(Engineer engineer);

    //根据姓名删除工程师
    int deleteEng(String engineerName);

    //根据Id删除工程师
    int deleteEngById(int engineerId);

    //更新工程师信息
    int updateEng(Engineer engineer);

    //根据工程师姓名查询工程师信息
    Engineer getEngByName(String engineerName);

    //根据工程师工号查询工程师信息
    Engineer getEngById(int engineerId);

    //查询对应名字的工程师数量
    int getEngCountByName(String engineerName);

}
