package com.sjh.utils;

public enum ResultCode {

    SUCCESS(100,"成功"),
    FILE_NULL_ERROR(200,"文件不能为空"),
    EMI_IS_NO_PRO(200,"该员工还未关联此工程"),
    ERROR(200,"失败");

    ResultCode(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    private Integer code;

    private String message;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
