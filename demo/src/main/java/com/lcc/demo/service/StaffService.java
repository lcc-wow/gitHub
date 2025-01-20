package com.lcc.demo.service;

import com.lcc.demo.pojo.PageBean;

import java.time.LocalDate;

public interface StaffService {

    // 分页查询
    PageBean page(Integer page, Integer pageSize);


}
