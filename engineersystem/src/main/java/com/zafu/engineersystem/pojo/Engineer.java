package com.zafu.engineersystem.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Engineer {
    private int engineerId;
    private int engineerSex;
    private String engineerName;
    private String engineerAddress;
    private String engineerTelephone;
    private Date engineerBirthday;
    private String engineerNative;
    private int engineerSeniority;
    private double engineerSalary;
    private String engineerEducation;
    private double engineerFinalsalary;

}
