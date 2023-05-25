package com.springboot.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.time.LocalDateTime;
import java.util.List;

@Mapper
public interface ReserveMapper {
    /**
     * 创建预约记录
     * @return 受影响的行数
     */
    int CreateReserve(@Param("StudentId") int StudentId, @Param("RoomId") int RoomId, @Param("StartTime")LocalDateTime StartTime, @Param("EndTime")LocalDateTime EndTime, @Param("SubmitTime")LocalDateTime SubmitTime);

    /**
     * 查询可预约的房间
     * @return 可使用的房间列表
     */
    List<Integer> AvailableRoom(@Param("StartTime") LocalDateTime StartTime, @Param("EndTime")LocalDateTime EndTime);
}
