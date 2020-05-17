package com.zafu.engineersystem.controller;

import com.zafu.engineersystem.pojo.Engineer;
import com.zafu.engineersystem.pojo.Record;
import com.zafu.engineersystem.pojo.User;
import com.zafu.engineersystem.service.RecordService;
import com.zafu.engineersystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Controller
public class ManageController {
    @Autowired
    private UserService userService;

    @Autowired
    private RecordService recordService;

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


    //查询用户信息（不带操作）
    @RequestMapping("/toqueryUserInfo")
    public String toqueryUserInfo(){
        return "showUserInfo";
    }

    //根据名字查询用户信息（不带操作）
    @RequestMapping("/queryUserInfo")
    public String showUserInfo(String username, Model model){
        if(!username.equals("")) {
            User user = userService.getUserByName(username);
            model.addAttribute("user", user);
            return "showUserInfo";
        }else{
            //输入为空时显示所有工程师信息
            return "redirect:/showAllUserInfo";
        }
    }

    //查询所有用户信息(不带操作)
    @RequestMapping("/showAllUserInfo")
    public String showAllUserInfo(Model model){
        List<User> allUser = userService.getAllUser();
        model.addAttribute("user",allUser);
        return "showUserInfo";
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
    public String addUser(User user, HttpSession session, Model model){
        if(userService.addUser(user) == 1){
            Record record = new Record();
            String userInfo = session.getAttribute("userInfo").toString();
            record.setUsername(userInfo);
            record.setOperation("添加用户 "+user.getUsername());
            record.setTime(new Timestamp((System.currentTimeMillis())));
            recordService.addRecord(record);
        }
        else{
            List<FieldError> list = new ArrayList<FieldError>(1);
            FieldError fielderror = new FieldError("addError","addError","用户名："+user.getUsername()+" 已经被添加");
            list.add(fielderror);
            model.addAttribute("error",list);
            return "addUser";
        }
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
    public String updateUser(@Valid User user, BindingResult bindingResult, HttpSession session, RedirectAttributes model){
        if(bindingResult.hasErrors()){
            List<FieldError> list = bindingResult.getFieldErrors();
            model.addFlashAttribute("error",list);
            return "updateUser";
        }
        else{
            //因为修改发生重名情况
            if(!userService.getUserById(user.getId()).getUsername().equals(user.getUsername())
                    && (userService.getUserCountByName(user.getUsername())) ==1){
                List<FieldError> list = new ArrayList<FieldError>(1);
                FieldError fielderror = new FieldError("updateError","updateError","用户名："+user.getUsername()+" 已经被添加");
                list.add(fielderror);
                model.addFlashAttribute("error",list);
                String id = String.valueOf(user.getId());
                return "redirect:/toUpdateUser/" + id;
            }else{
                if((userService.updateUser(user) == 1)){
                    Record record = new Record();
                    String userInfo = session.getAttribute("userInfo").toString();
                    record.setUsername(userInfo);
                    record.setOperation("修改用户 "+user.getUsername());
                    record.setTime(new Timestamp((System.currentTimeMillis())));
                    recordService.addRecord(record);
                }
            }
            return "redirect:/showAllUser";
        }
    }

    @RequestMapping("/deleteUser/{id}")
    public String deleteUser(@PathVariable("id") int id, HttpSession session){
        User user = userService.getUserById(id);

        if(userService.deleteUserById(id)==1){
            Record record = new Record();
            String userInfo = session.getAttribute("userInfo").toString();
            record.setUsername(userInfo);
            record.setOperation("删除用户 "+user.getUsername());
            record.setTime(new Timestamp((System.currentTimeMillis())));
            recordService.addRecord(record);
            }
        return "redirect:/showAllUser";
    }

}
