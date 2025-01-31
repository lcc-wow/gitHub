package com.lcc.pojo;

import java.util.List;

public class PageBean {
    private Long total;
    private List content;

    // 构造函数、getter和setter方法
    public PageBean(Long total, List content) {
        this.total = total;
        this.content = content;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public List getContent() {
        return content;
    }

    public void setContent(List content) {
        this.content = content;
    }
}