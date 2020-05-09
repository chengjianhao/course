package com.zafu.engineersystem.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Record {
    private int id;
    private String username;
    private String operation;
    private Timestamp time;

}
