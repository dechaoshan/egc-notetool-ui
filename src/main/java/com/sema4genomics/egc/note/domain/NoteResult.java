package com.sema4genomics.egc.note.domain;

import com.sema4genomics.egc.base.Result.ResultData;



import lombok.Data;

@Data
public class NoteResult extends ResultData {


    public NoteResult(){

        this.setName("note");
        this.setType("Note");
    }


    public NoteResult( Note note) {
        super("note", "Note", note);
    }

    public NoteResult(String name, String type, Object value) {
        super(name, type, value);
    }
}
