package com.springboot.entity;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class User {
    private int Id;
    private String UserName;
    private String PassWord;
    private boolean Sex;
    private int Age;
    private String Email;
}
