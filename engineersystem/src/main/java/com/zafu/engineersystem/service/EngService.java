package com.zafu.engineersystem.service;


import com.zafu.engineersystem.pojo.Engineer;

import java.util.List;

public interface EngService {
    List<Engineer> getAllEng();

    int addEng(Engineer engineer);

    int deleteEng(String engineerName);

    int deleteEngById(int engineerId);

    int updateEng(Engineer engineer);

    Engineer getEngByName(String engineerName);

    Engineer getEngById(int engineerId);
}
