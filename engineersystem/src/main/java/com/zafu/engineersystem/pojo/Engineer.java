package com.zafu.engineersystem.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.sql.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Engineer {
    private int engineerId;

    @NotNull(message = "性别不能为空")
    private int engineerSex;

    private String engineerName;

    private String engineerAddress;

    @Length(max=11, message = "手机号码不能超过11位")
    private String engineerTelephone;

    //@Past(message = "日期填写错误")
    private Date engineerBirthday;

    @Length(max=10, message = "超出填写长度")
    private String engineerNative;

    @Min(value = 0, message = "工龄填写有误，不能小于0")
    @Max(value = 50, message = "工龄填写有误，不能大于50")
    private int engineerSeniority;

    @Min(value = 1,message = "基本工资不能为0")
    private double engineerSalary;

    @NotNull(message = "学历不能为空")
    private String engineerEducation;
    private double engineerFinalsalary;

}
