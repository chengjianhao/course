package com.zafu.engineersystem.controller;

import com.zafu.engineersystem.pojo.User;
import com.zafu.engineersystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class ManageController {
    @Autowired
    private UserService userService;

    //根据名字查询用户信息
    @RequestMapping("/queryUser")
    public String showUser(String username, Model model){
        if(!username.equals("")) {
            User user = userService.getUserByName(username);
            model.addAttribute("user", user);
            return "showUser";
        }else{
            //输入为空时显示所有工程师信息
            return "redirect:/showAllUser";
        }
    }

    //查询所有用户信息
    @RequestMapping("/showAllUser")
    public String showAllUser(Model model){
        List<User> allUser = userService.getAllUser();
        model.addAttribute("user",allUser);
        return "showUser";
    }

    //新增用户信息
    @RequestMapping("/toAddUser")
    public String toAddUser(){
        return "addUser";
    }

    @RequestMapping("/addUser")
    public String addUser(User user){
        userService.addUser(user);
        return "redirect:/showAllUser";
    }

    //跳转到修改用户信息页面
    @RequestMapping("/toUpdateUser/{id}")
    public String toUpdateUser(@PathVariable("id")int id,Model model){
        User user = userService.getUserById(id);
        model.addAttribute("user",user);
        return "updateUser";
    }

    @RequestMapping("/updateUser")
    public String updateUser(User user, Model model){
        userService.updateUser(user);
        return "redirect:/showAllUser";
    }

    @RequestMapping("/deleteUser/{id}")
    public String deleteUser(@PathVariable("id") int id){
        userService.deleteUserById(id);
        return "redirect:/showAllUser";
    }
}
