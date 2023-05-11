package com.springboot.mapper;

import com.springboot.entity.PianoRoom;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

@Mapper
public interface ReserveMapper {
    /**
     * 创建预约记录
     * @return 受影响的行数
     */
    int CreateReserve(@Param("StudentId") int StudentId, @Param("RoomId") int RoomId, @Param("StartTime")Date StartTime, @Param("StartTime")Date EndTime);

    /**
     * 查询可预约的房间
     * @return 可使用的房间列表
     */
    List<Integer> AvailableRoom(@Param("StartTime")Date StartTime, @Param("StartTime")Date EndTime);
}
