package com.atguigu.dao;

import com.atguigu.mybatis.Employee;

public interface EmployeeMapper {

    Employee getEmpById(Integer id);

    void addEmp(Employee employee);

    void updateEmp(Employee employee);

    void deleteEmp(Integer id);

}
