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
public class Reserve {
    private int Id;
    private LocalDateTime ReserveStartTime;
    private LocalDateTime ReserveEndTime;
    private LocalDateTime SubmitTime;
    private Student Student;
    private int Status;
    private PianoRoom PianoRoom;
}
