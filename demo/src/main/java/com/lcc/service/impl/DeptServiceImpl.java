package com.lcc.service.impl;

import com.lcc.mapper.DeptMapper;
import com.lcc.pojo.Dept;
import com.lcc.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.List;

@Service
public class DeptServiceImpl implements DeptService {

    @Autowired
    private DeptMapper deptMapper; // 引入mapper

    // 查询所有部门信息
    @Override
    public List<Dept> list() {
        return deptMapper.list();
    }

    // 删除部门信息
    @Override
    public void delete(Integer id) {
        deptMapper.delete(id);
    }

    // 添加部门信息
    @Override
    public void add(Dept dept) {
        dept.setCreateTime(LocalDate.now());
        dept.setUpdateTime(LocalDate.now());
        deptMapper.add(dept);
    }

    // 更新部门信息
    @Override
    public void update(Dept dept) {
        // 先查询数据库中的原始记录
        Dept existingDept = deptMapper.getById(dept.getId());
        if (existingDept != null) {
            // 保留原有的 create_time
            dept.setCreateTime(existingDept.getCreateTime());
        }
        deptMapper.update(dept);
    }
}
