package com.springboot.entity;

import lombok.*;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Dept {
    private int Id;
    private String Name;
    private List<Emp> Emps; // 一对多映射(一个部门对应多个员工)，要在“一”的实体类中加入“多”的集合
}
