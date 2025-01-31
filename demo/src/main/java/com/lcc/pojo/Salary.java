package com.lcc.pojo;

import java.time.LocalDate;

public class Salary {
    private Integer id;
    private LocalDate date;
    private Integer staffId;
    private Integer basicSalary; //底薪
    private Integer Bonus; //满勤
    private Integer penalty; //提成
    private Integer late; //迟到
    private Integer early; //早退
    private Integer absence; //缺勤
    private Integer totalSalary; //实发工资

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Integer getStaffId() {
        return staffId;
    }

    public void setStaffId(Integer staffId) {
        this.staffId = staffId;
    }

    public Integer getBasicSalary() {
        return basicSalary;
    }

    public void setBasicSalary(Integer basicSalary) {
        this.basicSalary = basicSalary;
    }

    public Integer getBonus() {
        return Bonus;
    }

    public void setBonus(Integer bonus) {
        Bonus = bonus;
    }

    public Integer getPenalty() {
        return penalty;
    }

    public void setPenalty(Integer penalty) {
        this.penalty = penalty;
    }

    public Integer getLate() {
        return late;
    }

    public void setLate(Integer late) {
        this.late = late;
    }

    public Integer getEarly() {
        return early;
    }

    public void setEarly(Integer early) {
        this.early = early;
    }

    public Integer getAbsence() {
        return absence;
    }

    public void setAbsence(Integer absence) {
        this.absence = absence;
    }

    public Integer getTotalSalary() {
        return totalSalary;
    }

    public void setTotalSalary(Integer totalSalary) {
        this.totalSalary = totalSalary;
    }
}
