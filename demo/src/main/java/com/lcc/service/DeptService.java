package com.lcc.service;

import com.lcc.pojo.Dept;

import java.util.List;

public interface DeptService {
    //查询全部部门数据
    List<Dept> list();

    //删除部门信息
    void delete(Integer id);

    //新增部门信息
    void add(Dept dept);

    //修改部门信息
    void update(Dept dept);
}
