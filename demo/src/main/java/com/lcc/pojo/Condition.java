package com.lcc.pojo;

import java.time.LocalDate;

public class Condition {
    private Integer staffId;
    private String name;
    private String condition;
    private LocalDate date;
    private Integer punish;

    public Integer getPunish() {
        return punish;
    }

    public void setPunish(Integer punish) {
        this.punish = punish;
    }

    public Integer getStaffId() {
        return staffId;
    }

    public void setStaffId(Integer staffId) {
        this.staffId = staffId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}
