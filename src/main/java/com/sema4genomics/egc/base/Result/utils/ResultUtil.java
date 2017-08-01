package com.sema4genomics.egc.base.Result.utils;


import com.sema4genomics.egc.base.Result.ResultData;
import com.sema4genomics.egc.base.Result.ResultInfo;
import org.springframework.beans.factory.annotation.Autowired;

public class ResultUtil {

    public static ResultInfo Success(String action,Object obj){
        ResultData resultData;
        resultData = (ResultData)obj;
        ResultInfo resultInfo = new ResultInfo(0,resultData,action,"success");
        return resultInfo;

    }

    public static ResultInfo Success(String action){

        return Success(action,null);
    }


    public static ResultInfo error(Integer code,String action, String msg){

        ResultInfo resultInfo = new ResultInfo();
        resultInfo.setCode(code);
        resultInfo.setMsg(msg);
        resultInfo.setAction(action);

        return resultInfo;


    }


}
