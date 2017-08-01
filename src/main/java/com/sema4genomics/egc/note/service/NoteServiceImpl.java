package com.sema4genomics.egc.note.service;

import com.sema4genomics.egc.base.Result.ResultInfo;
import com.sema4genomics.egc.base.Result.ResultData;
import com.sema4genomics.egc.base.Result.utils.ResultUtil;
import com.sema4genomics.egc.note.Repository.NoteRepository;
import com.sema4genomics.egc.note.domain.Note;
import com.sema4genomics.egc.note.domain.NoteResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;


@Service("NoteService")
public class NoteServiceImpl implements NoteService{

    @Autowired
    private NoteRepository noteRepository;


    @Override
    //@Transactional
    public ResultInfo noteAdd(Note note){

        Date date = new Date();
        note.setCreateDate(date);

        Note newNote = noteRepository.save(note);
        NoteResult noteResult = new NoteResult(newNote);

        return ResultUtil.Success("create",noteResult);
    }

    @Override
    public ResultInfo noteFindById(Integer id) {

        Note note =  noteRepository.findOne(id);

        ResultInfo resultInfo;
        if(note == null){
            resultInfo = ResultUtil.error(1,"findById","id not find");
        }else{
            NoteResult noteResult = new NoteResult(note);

            resultInfo = ResultUtil.Success("findById",noteResult);
        }
        return resultInfo;
    }


    @Override
    public ResultInfo noteUpdate(Note note) {
        Boolean exist = noteRepository.exists(note.getId());

        if(exist){

            Date date = new Date();
            note.setCreateDate(date);

            Note savedNote =  noteRepository.save(note);
            NoteResult noteResult = new NoteResult(savedNote);

            return ResultUtil.Success("update",noteResult);

        }else{
            return ResultUtil.error(1,"update","not exists");
        }
    }


    @Override
    public ResultInfo notesFindByLabNumber(String labnumber) {

        List<Note> notes =  noteRepository.findByLabNumber(labnumber);
        ResultData resultData=  new NoteResult("noteList","List<Note>",notes);

        return ResultUtil.Success("FindByLabNumber",resultData);
    }

    @Override
    public ResultInfo noteDelete(Integer id) {
         noteRepository.delete(id);

         return ResultUtil.Success("delete");
    }


    @Override
    public ResultInfo noteEnableDisable(Integer id,Boolean isenable) {
        Note note = noteRepository.findOne(id);
        note.setEnabled(isenable);
        Note newNote = noteRepository.save(note);
        String action = isenable? "enable":"disable";
        ResultData resultData=  new NoteResult("note","Note",newNote);
        return ResultUtil.Success(action,resultData);
    }

}


