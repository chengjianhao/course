package com.zafu.engineersystem.controller;

import com.zafu.engineersystem.pojo.Engineer;
import com.zafu.engineersystem.pojo.User;
import com.zafu.engineersystem.service.UserService;
import com.zafu.engineersystem.service.EngService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class LoginController {

    @Autowired
    private UserService userService;
    @Autowired
    private EngService engService;

    @RequestMapping({"/","/index"})
    public String toLogin(){
        return "index";
    }

    @RequestMapping("/login")
    public String login(String username, String password, Model model, HttpSession session){
            User user = userService.getUserByName(username);
            //用户存在时
            if(user!=null){
                //用户名密码都正确时
                if (password.equals(user.getPassword())){
                    List<Engineer> allEmp = engService.getAllEng();
                    session.setAttribute("userInfo",username);
                    return "redirect:/showAllEng";
                }else {
                    //密码不正确时
                    model.addAttribute("msg","用户名或者密码错误");
                    return "index";
                }
            }else {
                model.addAttribute("msg","用户名或者密码错误");
                return "index";
            }
    }

    @RequestMapping("/logout")
    public String logout(HttpSession session){
        //注销用户
        session.invalidate();
        return "index";
    }
}
