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
}
