package com.zafu.engineersystem.mapper;

import com.zafu.engineersystem.pojo.Record;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface RecordMapper {

    //添加操作记录
    int addRecord (Record record);

    //查找操作记录
    List<Record> getAllRecord();
}
