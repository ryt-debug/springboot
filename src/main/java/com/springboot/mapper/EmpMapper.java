package com.springboot.mapper;

import com.springboot.entity.Emp;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface EmpMapper {
    /**
     * 查询所有员工的信息
     */
    List<Emp> GetAllEmp();

    /**
     * 查询员工以及员工对应的部门信息
     */
    Emp GetEmpDetail(@Param("EmpId") int EmpId);

    /**
     * 分步查询员工以及员工对应的部门信息  第一步
     */
    Emp GetEmpDetailByStepOne(@Param("EmpId") int EmpId);

    /**
     * 分步查询部门以及部门中的员工  第二步
     */
    List<Emp> GetDeptDetailByStepTwo(@Param("DeptId") int DeptId);
}
