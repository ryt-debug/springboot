package com.springboot.mapper;

import com.springboot.entity.Dept;
import com.springboot.entity.Emp;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface DeptMapper {
    /**
     * 分步查询员工以及员工对应的部门信息  第二步
     */
    Dept GetEmpDetailByStepTwo(@Param("DeptId") int DeptId);

    /**
     * 获取部门已经部门中的所有员工信息
     */
    Dept GetDeptDetail(@Param("DeptId") int DeptId);
}
