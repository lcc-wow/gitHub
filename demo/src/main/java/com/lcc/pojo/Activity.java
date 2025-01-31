package com.lcc.pojo;

public class Activity {
    private Integer id;
    private String activities;
    private String details;
    private Integer totalMember;
    private Boolean isEnded;

    public Boolean getEnded() {
        return isEnded;
    }

    public void setEnded(Boolean ended) {
        isEnded = ended;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getActivities() {
        return activities;
    }

    public void setActivities(String activities) {
        this.activities = activities;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public Integer getTotalMember() {
        return totalMember;
    }

    public void setTotalMember(Integer totalMember) {
        this.totalMember = totalMember;
    }
}
