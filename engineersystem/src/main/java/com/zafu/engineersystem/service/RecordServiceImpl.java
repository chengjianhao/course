package com.zafu.engineersystem.service;
import com.zafu.engineersystem.mapper.RecordMapper;
import com.zafu.engineersystem.pojo.Record;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecordServiceImpl implements RecordService {

    @Autowired
    RecordMapper recordMapper;

    @Override
    public int addRecord(Record record){
        return recordMapper.addRecord(record);
    }

    @Override
    public List<Record> getAllRecord() {
        return recordMapper.getAllRecord();
    }
}
