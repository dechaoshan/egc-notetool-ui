package com.sema4genomics.egc.note.handle;


import com.sema4genomics.egc.base.Result.ResultInfo;
import com.sema4genomics.egc.base.Result.utils.ResultUtil;
import com.sema4genomics.egc.note.exception.NoteException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;



@ControllerAdvice
public class ExceptionHandle {


    //private final static Logger logger = (Logger) LoggerFactory.getLogger(ExceptionHandle.class);

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public ResultInfo handle(Exception e){
        if (e instanceof NoteException){

            NoteException ne = (NoteException) e;
            return ResultUtil.error(ne.getCode(),ne.getAction(),ne.getMessage());


        }else{

            return ResultUtil.error(-1,null,"unknow error");
        }


    }



}
