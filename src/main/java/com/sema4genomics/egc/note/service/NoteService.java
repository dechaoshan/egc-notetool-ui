package com.sema4genomics.egc.note.service;


import com.sema4genomics.egc.base.Result.ResultInfo;
import com.sema4genomics.egc.note.domain.Note;
import org.springframework.stereotype.Service;


@Service
public interface NoteService {

    ResultInfo noteAdd(Note note);
    ResultInfo noteUpdate(Note note);
    ResultInfo noteFindById(Integer id);
    ResultInfo noteEnableDisable(Integer id,Boolean isenable);
    ResultInfo noteDelete(Integer id);
    ResultInfo notesFindByLabNumber(String labnumber);


}
