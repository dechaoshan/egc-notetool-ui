package com.sema4genomics.egc.note.Repository;

import com.sema4genomics.egc.note.domain.Note;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NoteRepository extends JpaRepository<Note,Integer> {


    //search by labnumber;
    public List<Note>  findByLabNumber(String labnumber);


}
