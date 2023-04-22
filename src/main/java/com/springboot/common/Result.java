package com.springboot.common;

import lombok.Data;

@Data
public class Result<T> {
    private Integer code;
    private String msg;
    private T data = null;

    public Result<T> Success(){
        code = 1;
        return this;
    }

    public Result<T> Failure(){
        this.code = -1;
        return this;
    }

    public Result<T> Except(Throwable ex){
        this.code = -1;
        if(ex.getMessage() == null) {
            this.msg = "Exception Message:" + ex.getCause();
        }
        else{
            this.msg = "Exception Message:" + ex.getMessage();
        }
        return this;
    }

    public Result<T> Msg(String msg) {
        this.msg = msg;
        return this;
    }

    public Result<T> Data(T data) {
        this.data = data;
        return this;
    }

    public Result<T> ParaMissing() {
        this.code = -1;
        this.msg = "请求参数不足";
        return this;
    }
}
