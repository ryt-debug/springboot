package com.springboot.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Student {
    private int Id;
    private String Name;
    private String Number;
    private List<Reserve> Reserves;
}
