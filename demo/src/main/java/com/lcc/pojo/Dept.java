package com.lcc.pojo;

import java.time.LocalDate;

public class Dept {
    private Integer id;
    private String name;
    private LocalDate createTime;
    private LocalDate updateTime;

    public Dept() {
    }

    public Dept(Integer id, String name, LocalDate createTime, LocalDate updateTime) {
        this.id = id;
        this.name = name;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDate createTime) {
        this.createTime = createTime;
    }

    public LocalDate getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(LocalDate updateTime) {
        this.updateTime = updateTime;
    }
}
