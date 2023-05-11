package com.springboot.controller;


import com.springboot.common.TimeParseHelper;
import com.springboot.common.Result;
import com.springboot.mapper.ReserveMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Map;


@CrossOrigin
@RestController
@RequestMapping("/api/ReserveController")
public class ReserveController {
    @Autowired
    private ReserveMapper reserveMapper;

    @PostMapping("/availableRoom")
    public Result<?> AvailableRoom(@RequestBody Map<String, Object> params) {
        try {
            if (!params.containsKey("StartTime") || !params.containsKey("EndTime"))
                return new Result<>().ParaMissing();
            LocalDateTime StartTime = TimeParseHelper.Parse((String) params.get("StartTime")),
                    EndTime = TimeParseHelper.Parse((String) params.get("EndTime"));
            return new Result<>().Success().Msg("查询成功！").Data(reserveMapper.AvailableRoom(StartTime, EndTime));
        } catch (Exception ex) {
            return new Result<>().Except(ex);
        }
    }

    @PostMapping("/createReserve")
    public Result<?> CreateReserve(@RequestBody Map<String, Object> params) {
        try {
            if (!params.containsKey("StartTime") ||
                    !params.containsKey("EndTime") ||
                    !params.containsKey("StudentId") ||
                    !params.containsKey("RoomId"))
                return new Result<>().ParaMissing();
            LocalDateTime StartTime = TimeParseHelper.Parse((String) params.get("StartTime")),
                    EndTime = TimeParseHelper.Parse((String) params.get("EndTime"));
            int StudentId = (Integer) params.get("StudentId"), RoomId = (Integer) params.get("RoomId");
            var list = reserveMapper.AvailableRoom(StartTime, EndTime);
            if(list == null || list.size() == 0)
                return new Result<>().Failure().Msg("预约失败，时间冲突");
            return new Result<>().Success().Msg("预约成功！").Data(reserveMapper.CreateReserve(StudentId, RoomId, StartTime, EndTime, LocalDateTime.now()));
        } catch (Exception ex) {
            return new Result<>().Except(ex);
        }
    }
}
