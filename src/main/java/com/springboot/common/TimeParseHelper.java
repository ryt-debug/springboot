package com.springboot.common;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class TimeParseHelper {
    public static LocalDateTime Parse(String DateString) {
        var df = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return LocalDateTime.parse(DateString, df);
    }
}
