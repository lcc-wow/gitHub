package com.lcc.demo.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.lcc.demo.mapper.StaffMapper;
import com.lcc.demo.pojo.PageBean;
import com.lcc.demo.pojo.Staff;
import com.lcc.demo.service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class StaffServiceImpl implements StaffService {

    @Autowired
    private StaffMapper staffMapper;

    @Override
    public PageBean page(Integer page, Integer pageSize) {
        //1. 设置分页参数
        PageHelper.startPage(page,pageSize);

        //2. 执行查询
        List<Staff> staffList =staffMapper.list();
        Page<Staff> p = (Page<Staff>) staffList;

        //3. 封装PageBean对象
        PageBean pageBean = new PageBean(p.getTotal(), p.getResult());
        return pageBean;
    }

}
