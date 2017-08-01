package com.sema4genomics.egc.note.exception;

public class NoteException extends RuntimeException{

    private  Integer code;


    private String action;

    public NoteException(Integer code,String action, String message){
        super(message);
        this.code = code;
        this.action = action;

    }

    public NoteException(Integer code, String message){
        super(message);
        this.code = code;

    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }
}
