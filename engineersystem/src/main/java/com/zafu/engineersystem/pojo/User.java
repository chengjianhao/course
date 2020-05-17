package com.zafu.engineersystem.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private int id;

    @NotNull(message = "用户名不能为空")
    @Length(max=20, message = "姓名超出填写长度")
    private String username;

    @NotNull(message = "密码不能为空")
    @Length(max=20, message = "密码超出填写长度")
    private String password;

    @NotNull(message = "身份不能为空")
    private int identity;

}
