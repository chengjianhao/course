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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
            return "daohanglan";
        }else{
            //输入为空时显示所有工程师信息
            return "redirect:/showAllEng";
        }
    }

    //根据名字查询工程师信息删除
    @RequestMapping("/queryEngbyNamedelete")
    public String showEngineerbyNamedelete(String engineerName, Model model){
        if(!engineerName.equals("")) {
            Engineer eng = engService.getEngByName(engineerName);
            model.addAttribute("eng", eng);
            return "deleteEngbyName";
        }else{
            //输入为空时显示所有工程师信息
            return "redirect:/deleteAllEngbyName";
        }
    }

    //根据id查询工程师信息删除
    @RequestMapping("/queryEngbyIddelete")
    public String showEngineerbyIddelete(String engineerId, Model model){
        if(engineerId.equals("")) {
            //输入为空时显示所有工程师信息
            return "redirect:/deleteAllEngbyId";
        }else{
            int id = Integer.parseInt(engineerId);
            Engineer eng = engService.getEngById(id);
            model.addAttribute("eng", eng);
            return "deleteEngbyId";
        }
    }

    //根据名字查询工程师信息更新
    @RequestMapping("/queryEngbyNameUpdate")
    public String showEngineerbyNameUpdate(String engineerName, Model model){
        if(!engineerName.equals("")) {
            Engineer eng = engService.getEngByName(engineerName);
            model.addAttribute("eng", eng);
            return "updateEngbyName";
        }else{
            //输入为空时显示所有工程师信息
            return "redirect:/updateAllEngbyName";
        }
    }

    //根据id查询工程师信息更新
    @RequestMapping("/queryEngbyIdUpdate")
    public String showEngineerbyIdUpdate(String engineerId, Model model){
        if(engineerId.equals("")) {
            //输入为空时显示所有工程师信息
            return "redirect:/updateAllEngbyId";
        }else{
            int id = Integer.parseInt(engineerId);
            Engineer eng = engService.getEngById(id);
            model.addAttribute("eng", eng);
            return "updateEngbyId";
        }
    }

    //根据姓名查找所有工程师信息更新
    @RequestMapping("/updateAllEngbyName")
    public String updateAllEngbyName(Model model){
        List<Engineer> allEng = engService.getAllEng();
        model.addAttribute("eng",allEng);
        return "updateEngbyName";
    }

    //根据id查找所有工程师信息更新
    @RequestMapping("/updateAllEngbyId")
    public String updateAllEngbyId(Model model){
        List<Engineer> allEng = engService.getAllEng();
        model.addAttribute("eng",allEng);
        return "updateEngbyId";
    }

    //根据ID查询工程师信息
    @RequestMapping("/queryEngById")
    public String showEngineer2(String engineerId, Model model){
        if(engineerId.equals("")){
            return "redirect:/showAllEngbyId";
        }else{
            int id = Integer.parseInt(engineerId);
            Engineer eng = engService.getEngById(id);
            model.addAttribute("eng",eng);
            return "showEngbyId";
        }
    }

    //根据姓名查工程师信息
    @RequestMapping("/toqueryEngbyName")
    public String toqueryEngbyName(){
        return "queryEngbyName";
    }

    //根据ID查工程师信息
    @RequestMapping("/toqueryEngbyId")
    public String toqueryEngbyId(){
        return "queryEngbyId";
    }


    //查询所有工程师信息
    @RequestMapping("/showAllEng")
    public String showAllEng(Model model){
        List<Engineer> allEng = engService.getAllEng();
        model.addAttribute("eng",allEng);
        return "showEng";
    }

    //查询所有工程师信息,通过id
    @RequestMapping("/showAllEngbyId")
    public String showAllEngbyId(Model model){
        List<Engineer> allEng = engService.getAllEng();
        model.addAttribute("eng",allEng);
        return "showEngbyId";
    }

    //删除所有工程师信息,通过姓名
    @RequestMapping("/deleteAllEngbyName")
    public String deleteAllEngbyName(Model model){
        List<Engineer> allEng = engService.getAllEng();
        model.addAttribute("eng",allEng);
        return "deleteEngbyName";
    }

    //删除所有工程师信息,通过id
    @RequestMapping("/deleteAllEngbyId")
    public String deleteAllEngbyId(Model model){
        List<Engineer> allEng = engService.getAllEng();
        model.addAttribute("eng",allEng);
        return "deleteEngbyId";
    }

    //查询所有工程师信息(不带操作)
    @RequestMapping("/showAllEngInfo")
    public String showAllEngInfo(Model model){
        List<Engineer> allEng = engService.getAllEng();
        model.addAttribute("eng",allEng);
        return "showEngInfo";
    }
    /*
    @RequestMapping("/showAllEngOrderByIdAsc")
    public String showAllEngOrderByIdAsc(Model model){
        List<Engineer> allEng = engService.getAllEngOrderByIdAsc();
        model.addAttribute("eng",allEng);
        return "showEng";
    }*/

    //根据姓名增序排序
    @RequestMapping("/showAllEngOrderByNameAsc")
    public String showAllEngOrderByNameAsc(Model model){
        List<Engineer> allEng = engService.getAllEngOrderByNameAsc();
        model.addAttribute("eng",allEng);
        return "showEng";
    }

    //根据工龄降序排序
    @RequestMapping("/showAllEngOrderBySeniorityDesc")
    public String showAllEngOrderBySeniorityDesc(Model model){
        List<Engineer> allEng = engService.getAllEngOrderBySeniorityDesc();
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

    //根据姓名更新工程师信息
    @RequestMapping("/toupdateEngbyName")
    public String toupdateEngbyName(){
        return "updateEngbyName";
    }

    //根据ID更新工程师信息
    @RequestMapping("/toupdateEngbyId")
    public String toupdateEngbyId(){
        return "updateEngbyId";
    }

    //跳转到修改工程师信息页面
    @RequestMapping("/toUpdateEng/{engineerId}")
    public String toUpdateEng(@PathVariable("engineerId")int engineerId,Model model){
        Engineer eng = engService.getEngById(engineerId);
        model.addAttribute("eng",eng);
        return "updateEng";
    }

    @RequestMapping("/updateEng")
    public String updateEng(@Valid Engineer engineer, BindingResult bindingResult, RedirectAttributes model, HttpSession session){
        if(bindingResult.hasErrors()){
            List<FieldError> list = bindingResult.getFieldErrors();
            model.addFlashAttribute("error",list);
            return "updateEng";
        }
        else{
            //因为修改发生重名情况
            if(!engService.getEngById(engineer.getEngineerId()).getEngineerName().equals(engineer.getEngineerName())
                && (engService.getEngCountByName(engineer.getEngineerName())) ==1){
                List<FieldError> list = new ArrayList<FieldError>(1);
                FieldError fielderror = new FieldError("updateError","updateError","用户名："+engineer.getEngineerName()+" 已经被添加");
                list.add(fielderror);
                model.addFlashAttribute("error",list);
                String id = String.valueOf(engineer.getEngineerId());
                return "redirect:/toUpdateEng/" + id;
            }else{
                if((engService.updateEng(engineer) == 1)){
                    Record record = new Record();
                    String userInfo = session.getAttribute("userInfo").toString();
                    record.setUsername(userInfo);
                    record.setOperation("修改工程师 "+engineer.getEngineerName());
                    record.setTime(new Timestamp((System.currentTimeMillis())));
                    recordService.addRecord(record);
                }
            }
            return "redirect:/showAllEng";
        }
    }

    //根据姓名删除工程师信息
    @RequestMapping("/todeleteEngbyName")
    public String todeleteEngbyName(){
        return "deleteEngbyName";
    }

    //根据ID删除工程师信息
    @RequestMapping("/todeleteEngbyId")
    public String todeleteEngbyId(){
        return "deleteEngbyId";
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

    //根据姓名更新工程师薪水信息
    @RequestMapping("/toupdateSalarybyName")
    public String toupdateSalarybyName(){
        return "updateSalarybyName";
    }

    //根据姓名查询工程师修改薪水信息
    @RequestMapping("/queryByNameSalary")
    public String queryByNameSalary(String engineerName, Model model){
        if(!engineerName.equals("")) {
            Engineer eng = engService.getEngByName(engineerName);
            model.addAttribute("eng", eng);
            return "updateSalarybyName";
        }else{
            //输入为空时显示所有工程师信息
            return "redirect:/updateAllSalarybyName";
        }
    }

    //修改所有工程师薪水信息,通过姓名
    @RequestMapping("/updateAllSalarybyName")
    public String updateAllSalarybyName(Model model){
        List<Engineer> allEng = engService.getAllEng();
        model.addAttribute("eng",allEng);
        return "updateSalarybyName";
    }

    //跳转到计算工程师薪水信息页面
    @RequestMapping("/toUpdateSalary/{engineerId}")
    public String toUpdateSalary(@PathVariable("engineerId")int engineerId,Model model){
        SalaryInfo salaryInfo = salaryInfoService.getEngSalaryById(engineerId);
        model.addAttribute("salaryInfo",salaryInfo);
        return "updateSalary";
    }

    @RequestMapping("/updateSalary")
    public String updateSalary(@Valid SalaryInfo salaryInfo, BindingResult bindingResult, RedirectAttributes model){
        if(bindingResult.hasErrors()){
            List<FieldError> list = bindingResult.getFieldErrors();
            model.addFlashAttribute("error",list);
            String id = String.valueOf(salaryInfo.getEngineerId());
            return "redirect:/toUpdateSalary/" + id;
        }else{
            salaryInfoService.updateSalary(salaryInfo);
            salaryInfoService.caculatSalary(salaryInfo);
        }
        return "redirect:/showAllEng";
    }

    @RequestMapping("/deleteAllEng")
    public String deleteAllEng(HttpSession session){
        engService.deleteAllEng();

        //操作记录添加
        Record record = new Record();
        String userInfo = session.getAttribute("userInfo").toString();
        record.setUsername(userInfo);
        record.setOperation("删除所有工程师信息");
        record.setTime(new Timestamp((System.currentTimeMillis())));
        recordService.addRecord(record);
        return "redirect:/showAllEng";
    }
}
