package com.sema4genomics.egc.note.controller;

import com.sema4genomics.egc.base.Result.ResultInfo;
import com.sema4genomics.egc.note.domain.*;
import com.sema4genomics.egc.note.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/gc")
public class NoteController {

    @Autowired
    private NoteService noteService;


    //get note object by note_id;
    @GetMapping(value="/note/{id}")
    public ResultInfo noteFindById(@PathVariable(value="id") Integer id){
        return noteService.noteFindById(id);
    }

    @GetMapping(value="/notes/labno/{labnumber}")
    public ResultInfo noteFindByLabNumber(@PathVariable(value="labnumber") String  labnumber){
        return noteService.notesFindByLabNumber(labnumber);
    }

    @PostMapping(value = "/note")
    public ResultInfo noteAdd(@RequestBody Note note){
        return noteService.noteAdd(note);
    }


    @PutMapping(value = "/note")
    public ResultInfo noteUpdate(@RequestBody Note note){
        return noteService.noteUpdate(note);

    }

    @PostMapping(value = "/note/disable/{id}")
    public ResultInfo noteDisable(@PathVariable("id") Integer id){

        return noteService.noteEnableDisable(id,false);
    }

    @PostMapping(value = "/note/enable/{id}")
    public ResultInfo noteEnable(@PathVariable("id") Integer id){
        return noteService.noteEnableDisable(id,true);
    }


    @DeleteMapping(value = "/note/{id}")
    public ResultInfo noteDelete(@PathVariable("id") Integer id){

        return noteService.noteDelete(id);
    }










}
