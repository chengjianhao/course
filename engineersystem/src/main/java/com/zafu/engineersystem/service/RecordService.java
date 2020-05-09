package com.zafu.engineersystem.service;

import com.zafu.engineersystem.pojo.Record;

import java.util.List;

public interface RecordService {

    int addRecord (Record record);

    List<Record> getAllRecord();
}
