package com.springboot.mapper;

import com.springboot.common.Result;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ReserveMapper {
    public Result<?> CreateReserve();
}
