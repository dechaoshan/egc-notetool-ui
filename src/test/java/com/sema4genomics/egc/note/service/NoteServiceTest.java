package com.sema4genomics.egc.note.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sema4genomics.egc.base.Result.ResultData;
import com.sema4genomics.egc.base.Result.ResultInfo;
import com.sema4genomics.egc.note.domain.Note;
import org.junit.Test;

import org.junit.Assert;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;


@RunWith(SpringRunner.class)
@SpringBootTest
public class NoteServiceTest {

    @Autowired
    private NoteService noteService;

    ObjectMapper mapper = new ObjectMapper();

    private final Integer testnoteid=2;
    private final String testlabnumber ="testlabnumber";

    @Test
    public void noteAdd() throws Exception {

        Note note = new Note();

        note.setNoteType("Single");
        note.setLabNumber(testlabnumber);
        note.setSignedBy("testuser");
        note.setResidualRisk("testrisk");
        ResultInfo resultInfo = noteService.noteAdd(note);

        Assert.assertEquals(new Integer(0),new Integer(resultInfo.getCode()));
        System.out.println(mapper.writeValueAsString(resultInfo));
    }

    @Test
    public void noteFindById() throws Exception {

        ResultInfo resultInfo = noteService.noteFindById(testnoteid);
        Assert.assertNotNull(resultInfo);

        Assert.assertEquals(new Integer(0),new Integer(resultInfo.getCode()));
        System.out.println(mapper.writeValueAsString(resultInfo));
    }

    @Test
    public void notesFindByLabNumber() throws Exception {
        ResultInfo resultInfo = noteService.notesFindByLabNumber(testlabnumber);
        Assert.assertNotNull(resultInfo);
        Assert.assertEquals(new Integer(0),new Integer(resultInfo.getCode()));
        System.out.println(mapper.writeValueAsString(resultInfo));
    }


    @Test
    @Transactional
    public void notesAddFindUpdateEnableDisableDelete() throws Exception {
        Note note = new Note();
        note.setNoteType("Single");
        note.setLabNumber(testlabnumber);
        note.setSignedBy("testuser");
        note.setResidualRisk("testrisk");
        ResultInfo resultInfo = noteService.noteAdd(note);

        Assert.assertEquals(new Integer(0),new Integer(resultInfo.getCode()));
        System.out.println(mapper.writeValueAsString(resultInfo));
        System.out.println(resultInfo.getAction()+" "+resultInfo.getMsg());


        ResultData resultData = resultInfo.getData();
        note = (Note)resultData.getValue();
        Integer noteid  =  note.getId();
        System.out.println(noteid);
        resultInfo = noteService.noteFindById(noteid);
        Assert.assertNotNull(resultInfo);

        Assert.assertEquals(new Integer(0),new Integer(resultInfo.getCode()));
        System.out.println(mapper.writeValueAsString(resultInfo));

        System.out.println(resultInfo.getAction()+" "+resultInfo.getMsg());

        note.setSaveId("aabbcc");
        resultInfo = noteService.noteUpdate(note);
        Assert.assertNotNull(resultInfo);
        Assert.assertEquals(new Integer(0),new Integer(resultInfo.getCode()));
        System.out.println(resultInfo.getAction()+" "+resultInfo.getMsg());


        resultInfo = noteService.noteEnableDisable(noteid,false);
        Assert.assertNotNull(resultInfo);

        Assert.assertEquals(new Integer(0),new Integer(resultInfo.getCode()));
        System.out.println(resultInfo.getAction()+" "+resultInfo.getMsg());

        resultInfo = noteService.noteEnableDisable(noteid,true);
        Assert.assertNotNull(resultInfo);
        System.out.println("test4");
        Assert.assertEquals(new Integer(0),new Integer(resultInfo.getCode()));
        System.out.println(resultInfo.getAction()+" "+resultInfo.getMsg());
        System.out.println("test5");

        resultInfo = noteService.noteDelete(noteid);
        Assert.assertNotNull(resultInfo);

        Assert.assertEquals(new Integer(0),new Integer(resultInfo.getCode()));

        System.out.println(resultInfo.getAction()+" "+resultInfo.getMsg());


    }

}