package com.springboot.entity;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Emp {
    private int Id;
    private String Name;
    private Dept dept; // 多对一映射(多个员工对应一个部门)，要在“多”的实体类中加入“一”的对象
}
