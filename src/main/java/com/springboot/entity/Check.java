package com.springboot.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Check {
    private int Id;
    private Date CheckInTime;
    private Date CheckOutTime;
    private int ReserveId;
}
