package com.sema4genomics.egc.base.Result;

public enum ResultEnums {

    UNKNOW_ERROR(-1,"unknow error"),
    SUCCESS(0,"success"),
    FAILED(1,"failed"),
    NOT_EXISTS(2,"not exists"),
    ;



    private Integer code;
    private String msg;

    ResultEnums(Integer code, String msg){
        this.code = code;
        this.msg = msg;


    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
