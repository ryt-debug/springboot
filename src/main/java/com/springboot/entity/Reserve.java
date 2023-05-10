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
public class Reserve {
    private int Id;
    private Date ReserveStartTime;
    private Date ReserveEndTime;
    private Date SubmitTime;
    private int StudentId;
    private int Status;
    private int RoomId;
}
