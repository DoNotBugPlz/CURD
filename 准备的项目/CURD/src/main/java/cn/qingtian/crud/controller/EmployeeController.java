package cn.qingtian.crud.controller;

import cn.qingtian.crud.bean.Employee;
import cn.qingtian.crud.service.EmployeeService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @Description:
 * @Author:Dn
 * @Date:Create in 下午10:41 2018/9/1
 * @Modifid By:
 */

@Controller
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;

    @RequestMapping("/emps")
    public String getEmps(@RequestParam(value = "pn", defaultValue = "1") Integer pn, Model model) {

        PageHelper.startPage(pn, 8);
        //PageHelper.startPage紧跟的查询就是一条分页查询
        List<Employee> employeeList = employeeService.getAll();
        System.out.println(employeeList);
        PageInfo pageInfo = new PageInfo(employeeList,6);
        model.addAttribute("pageInfo", pageInfo);
        return "list";

    }

}
