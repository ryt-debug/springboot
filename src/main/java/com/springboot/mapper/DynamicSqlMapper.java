package com.springboot.mapper;

import com.springboot.entity.Emp;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface DynamicSqlMapper {
    /**
     * 多条件查询
     */
    List<Emp> GetEmpByConditions(@Param("emp")Emp emp);

    /**
     * 数组参数实现批量删除
     */
    int DeleteMoreByArray(int[] EmpIds);


    /**
     * List批量插入
     * @param emps 要插入的记录数组
     * @return 受影响的行数
     */
    int InsertMoreByList(@Param("emps")List<Emp> emps);
}
