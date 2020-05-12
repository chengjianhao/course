package com.zafu.engineersystem.controller;

import com.zafu.engineersystem.pojo.Engineer;
import com.zafu.engineersystem.pojo.Record;
import com.zafu.engineersystem.pojo.SalaryInfo;
import com.zafu.engineersystem.service.EngService;
import com.zafu.engineersystem.service.RecordService;
import com.zafu.engineersystem.service.SalaryInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Controller
public class CURDController {
    @Autowired
    private EngService engService;
    @Autowired
    private RecordService recordService;
    @Autowired
    private SalaryInfoService salaryInfoService;


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
        return "showEngSalary";
    }

    //新增工程师信息
    @RequestMapping("/toAddEng")
    public String toAddEmp(){
        return "addEng";
    }

    @RequestMapping("/addEng")
    public String addEng(@Valid Engineer engineer, BindingResult bindingResult, HttpSession session, Model model){
        if(bindingResult.hasErrors()){
            List<FieldError> list = bindingResult.getFieldErrors();
            model.addAttribute("error",list);
            return "addEng";
        }
        else{
            if(engService.addEng(engineer) == 1){
                Record record = new Record();
                String userInfo = session.getAttribute("userInfo").toString();
                record.setUsername(userInfo);
                record.setOperation("添加工程师 "+engineer.getEngineerName());
                record.setTime(new Timestamp((System.currentTimeMillis())));
                recordService.addRecord(record);
            }
            else{
                List<FieldError> list = new ArrayList<FieldError>(1);
                FieldError fielderror = new FieldError("addError","addError","用户名："+engineer.getEngineerName()+" 已经被添加");
                list.add(fielderror);
                model.addAttribute("error",list);
                return "addEng";
            }
            return "redirect:/showAllEng";
        }
    }

    //跳转到修改工程师信息页面
    @RequestMapping("/toUpdateEng/{engineerId}")
    public String toUpdateEng(@PathVariable("engineerId")int engineerId,Model model){
        Engineer eng = engService.getEngById(engineerId);
        model.addAttribute("eng",eng);
        return "updateEng";
    }

    @RequestMapping("/updateEng")
    public String updateEng(Engineer engineer, Model model,HttpSession session){
        if(engService.updateEng(engineer)==1){
            //操作记录添加
            Record record = new Record();
            String userInfo = session.getAttribute("userInfo").toString();
            record.setUsername(userInfo);
            record.setOperation("修改工程师 "+engineer.getEngineerName());
            record.setTime(new Timestamp((System.currentTimeMillis())));
            recordService.addRecord(record);
        }
        return "redirect:/showAllEng";
    }

    @RequestMapping("/deleteEng/{engineerId}")
    public String deleteEng(@PathVariable("engineerId") int engineerId, HttpSession session){
        Engineer engineer = engService.getEngById(engineerId);

        if(engService.deleteEngById(engineerId)==1){
            //操作记录添加
            Record record = new Record();
            String userInfo = session.getAttribute("userInfo").toString();
            record.setUsername(userInfo);
            record.setOperation("删除工程师 "+engineer.getEngineerName());
            record.setTime(new Timestamp((System.currentTimeMillis())));
            recordService.addRecord(record);
        }
        return "redirect:/showAllEng";
    }

    //跳转到计算工程师薪水信息页面
    @RequestMapping("/toUpdateSalary/{engineerId}")
    public String toUpdateSalary(@PathVariable("engineerId")int engineerId,Model model){
        SalaryInfo salaryInfo = salaryInfoService.getEngSalaryById(engineerId);
        model.addAttribute("salaryInfo",salaryInfo);
        return "updateSalary";
    }

    @RequestMapping("/updateSalary")
    public String updateSalary(SalaryInfo salaryInfo, Model model){
        salaryInfoService.updateSalary(salaryInfo);
        salaryInfoService.caculatSalary(salaryInfo);
        return "redirect:/showAllEng";
    }
}
