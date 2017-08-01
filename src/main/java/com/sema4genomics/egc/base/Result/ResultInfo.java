package com.sema4genomics.egc.base.Result;



import lombok.Data;

import java.util.List;

@Data
public class ResultInfo {

    //o for success , 2 for failed;
    private Integer code;

    private ResultData data;

    private String action;

    private String msg;


    public ResultInfo() {

    }

    public ResultInfo(String action) {
        this.action = action;
    }

    public ResultInfo(Integer code, String action, String msg) {
        this.code = code;
        this.action = action;
        this.msg = msg;
    }

    public ResultInfo(Integer code, ResultData data, String action, String msg) {
        this.code = code;
        this.data = data;
        this.action = action;
        this.msg = msg;
    }



    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public ResultData getData() {
        return data;
    }

    public void  setData(ResultData data) { this.data = data; }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
