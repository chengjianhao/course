package com.zafu.engineersystem.controller;


import com.zafu.engineersystem.pojo.Engineer;
import com.zafu.engineersystem.service.EngService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class CURDController {
    @Autowired
    private EngService engService;

    //根据名字查询工程师信息
    @RequestMapping("/queryEng")
    public String showEngineer(String engineerName, Model model){
        if(!engineerName.equals("")) {
            Engineer eng = engService.getEngByName(engineerName);
            model.addAttribute("eng", eng);
            return "showEng";
        }else{
            //输入为空时显示所有工程师信息
            return "redirect:/showAllEng";
        }
    }

    //查询所有工程师信息
    @RequestMapping("/showAllEng")
    public String showAllEng(Model model){
        List<Engineer> allEng = engService.getAllEng();
        model.addAttribute("eng",allEng);
        return "showEng";
    }

    //查询所有工程师工资信息
    @RequestMapping("/showAllEngSalary")
    public String showAllEngSalary(Model model){
        List<Engineer> allEng = engService.getAllEng();
        model.addAttribute("eng",allEng);
        return "showEng";
    }

    //新增工程师信息
    @RequestMapping("/toAddEng")
    public String toAddEmp(){
        return "addEng";
    }

    @RequestMapping("/addEng")
    public String addEng(Engineer engineer){
        engService.addEng(engineer);
        return "redirect:/showAllEng";
    }

    //跳转到修改工程师信息页面
    @RequestMapping("/toUpdateEng/{engineerId}")
    public String toUpdateEng(@PathVariable("engineerId")int engineerId,Model model){
        Engineer eng = engService.getEngById(engineerId);
        model.addAttribute("eng",eng);
        return "updateEng";
    }

    @RequestMapping("/updateEng")
    public String updateEng(Engineer engineer, Model model){
        engService.updateEng(engineer);
        return "redirect:/showAllEng";
    }

    @RequestMapping("/deleteEng/{engineerId}")
    public String deleteEng(@PathVariable("engineerId") int engineerId){
        engService.deleteEngById(engineerId);
        return "redirect:/showAllEng";
    }
}
