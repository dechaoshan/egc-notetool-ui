package com.sema4genomics.egc.note.domain;

import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.util.Date;



/**/
@Entity
@DynamicUpdate
@Data
@Table(name="note")
public class Note {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO )
    private Integer id;

    private String noteType;

    private Date createDate;

    private String labNumber;

    private String signedBy;

    private String residualRisk;


    private String saveId;

    @Column(nullable = false ,columnDefinition="boolean default true")
    private Boolean enabled = Boolean.TRUE;

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    public String getSaveId() {
        return saveId;
    }

    public void setSaveId(String saveId) {
        this.saveId = saveId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNoteType() {
        return noteType;
    }

    public void setNoteType(String noteType) {
        this.noteType = noteType;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getLabNumber() {
        return labNumber;
    }

    public void setLabNumber(String labNumber) {
        this.labNumber = labNumber;
    }

    public String getSignedBy() {
        return signedBy;
    }

    public void setSignedBy(String signedBy) {
        this.signedBy = signedBy;
    }

    public String getResidualRisk() {
        return residualRisk;
    }

    public void setResidualRisk(String residualRisk) {
        this.residualRisk = residualRisk;
    }

    public Note(){

    }



}
