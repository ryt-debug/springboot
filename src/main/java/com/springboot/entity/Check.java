package com.springboot.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Check {
    private int Id;
    private LocalDateTime CheckInTime;
    private LocalDateTime CheckOutTime;
    private Reserve Reserve;
}
