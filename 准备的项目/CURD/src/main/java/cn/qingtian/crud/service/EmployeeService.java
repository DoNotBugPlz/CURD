package cn.qingtian.crud.service;

import cn.qingtian.crud.bean.Employee;
import cn.qingtian.crud.dao.EmployeeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description:
 * @Author:Dn
 * @Date:Create in 下午10:42 2018/9/1
 * @Modifid By:
 */

@Service
public class EmployeeService {

    @Autowired
    EmployeeMapper employeeMapper;

    /**
     * 查询所有员工
     * @return
     */
    public List<Employee> getAll() {
        return employeeMapper.selectByExampleWithDept(null);
    }
}
