package com.koreait.study.model;

import java.util.Date;

public class Application {
    private Integer id;
    private Integer studyId;
    private String userId;
    private Date appliedAt;
    // getters & setters
    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }
    public Integer getStudyId() { return studyId; }
    public void setStudyId(Integer studyId) { this.studyId = studyId; }
    public String getUserId() { return userId; }
    public void setUserId(String userId) { this.userId = userId; }
    public Date getAppliedAt() { return appliedAt; }
    public void setAppliedAt(Date appliedAt) { this.appliedAt = appliedAt; }
}
