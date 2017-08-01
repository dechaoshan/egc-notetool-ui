package com.sema4genomics.egc.note.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sema4genomics.egc.note.domain.Note;
import org.junit.Test;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;


@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class NoteControllerTest {



    private final Integer testnoteid=2;
    private final String testlabnumber ="testlabnumber";


    ObjectMapper mapper = new ObjectMapper();




    @Autowired
    private MockMvc mvc;

    @Test
    public void noteFindById() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/gc/note/"+testnoteid ))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print());


    }

    @Test
    public void noteFindByLabNumber() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/gc/notes/labno/"+testlabnumber ))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print());
    }

    @Test
    public void noteAdd() throws Exception {

        Note note = new Note();

        note.setNoteType("Single");
        note.setLabNumber(testlabnumber);
        note.setSignedBy("testuser");
        note.setResidualRisk("testrisk");

        String jsonString = mapper.writeValueAsString(note);
        mvc.perform(
                MockMvcRequestBuilders.post("/gc/note" ).contentType(
                        MediaType.APPLICATION_JSON).content(jsonString)
        ).andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print());
    }

    @Test
    public void noteUpdate() throws Exception {
        Note note = new Note();
        note.setId(testnoteid);
        note.setNoteType("Single");
        note.setLabNumber(testlabnumber);
        note.setSignedBy("testuser2");
        note.setResidualRisk("testrisk");

        String jsonString = mapper.writeValueAsString(note);
        mvc.perform(
                MockMvcRequestBuilders.put("/gc/note" ).contentType(
                        MediaType.APPLICATION_JSON).content(jsonString)
        ).andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print());
    }

    @Test
    public void noteDelete() throws Exception {


        mvc.perform(
                MockMvcRequestBuilders.delete("/gc/note/"+17 )
        ).andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print());
    }

    @Test
    public void noteDisable() throws Exception {

    }

    @Test
    public void noteEnable() throws Exception {

    }

}