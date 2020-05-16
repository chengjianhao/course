package com.zafu.engineersystem.service;

import com.zafu.engineersystem.mapper.EngMapper;
import com.zafu.engineersystem.pojo.Engineer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EngServiceImpl implements EngService{
    @Autowired
    EngMapper engMapper;

    @Override
    public List<Engineer> getAllEng() {
        return engMapper.getAllEng();
    }

    @Override
    public List<Engineer> getAllEngOrderByIdAsc() {
        return engMapper.getAllEngOrderByIdAsc();
    }

    @Override
    public List<Engineer> getAllEngOrderByNameAsc() {
        return engMapper.getAllEngOrderByNameAsc();
    }

    @Override
    public List<Engineer> getAllEngOrderBySeniorityDesc() {
        return engMapper.getAllEngOrderBySeniorityDesc();
    }

    @Override
    public int addEng(Engineer engineer) {
        return engMapper.addEng(engineer);
    }

    @Override
    public int deleteEng(String engineerName) {
        return engMapper.deleteEng(engineerName);
    }

    @Override
    public int deleteAllEng() {
        return engMapper.deleteAllEng();
    }

    @Override
    public int deleteEngById(int engineerId) {
        return engMapper.deleteEngById(engineerId);
    }

    @Override
    public int updateEng(Engineer engineer) {
        return engMapper.updateEng(engineer);
    }

    @Override
    public Engineer getEngByName(String engineerName) {
        return engMapper.getEngByName(engineerName);
    }

    @Override
    public Engineer getEngById(int engineerId) {
        return engMapper.getEngById(engineerId);
    }

    @Override
    public int getEngCountByName(String engineerName) {
        return engMapper.getEngCountByName(engineerName);
    }
}
