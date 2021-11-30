package com.sjh.utils;

import lombok.*;

/**
 * @author sjh
 * @date 2020/5/7
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@ToString
public class Result {

    private Integer code;

    private String message;

    private Object object;

    public Result(ResultCode resultCode,Object object) {
        this.code = resultCode.getCode();
        this.message = resultCode.getMessage();
        this.object = object;
    }

    public Result(ResultCode resultCode) {
        this.code = resultCode.getCode();
        this.message = resultCode.getMessage();
    }

    public Result(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
