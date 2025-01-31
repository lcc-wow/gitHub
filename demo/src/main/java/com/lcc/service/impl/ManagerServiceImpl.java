package com.lcc.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.lcc.mapper.ManagerMapper;
import com.lcc.pojo.*;
import com.lcc.service.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class ManagerServiceImpl implements ManagerService {

    @Autowired
    private ManagerMapper managerMapper;

    //增
    @Override
    public void add(Staff staff) {
        staff.setCreateTime(LocalDateTime.now());
        staff.setUpdateTime(LocalDateTime.now());
        managerMapper.save(staff);
    }

    //删
    @Override
    public void delete(List<Integer> ids) {
        managerMapper.delete(ids);
    }

    //查
    @Override
    public PageBean page(Integer page, Integer pageSize,String name, Short gender,LocalDate begin,LocalDate end) {
        //1. 设置分页参数
        PageHelper.startPage(page,pageSize);

        //2. 执行查询
        List<staffs> staffList = managerMapper.list(name,gender,begin,end);
        Page<staffs> p = (Page<staffs>) staffList;

        //3. 封装PageBean对象
        PageBean pageBean = new PageBean(p.getTotal(), p.getResult());
        return pageBean;
    }

    //根据id查询数据
    @Override
    public Staff getById(Integer id) {
        return managerMapper.getById(id);
    }

    //改
    @Override
    public void update(Staff staff) {
        Staff staff1=managerMapper.getById(staff.getId());
        staff.setUsername(staff1.getUsername());
        staff.setPassword(staff1.getPassword());
        staff.setDeleted(staff1.getDeleted());
        staff.setCreateTime(staff1.getCreateTime());
        staff.setUpdateTime(LocalDateTime.now());
        managerMapper.update(staff);
    }

    //登录
    @Override
    public Manager login(User user) {
        return managerMapper.getBy(user.getUsername(), user.getPassword());
    }

    //记录员工考勤
    @Override
    public void record(Condition condition){
        managerMapper.record(condition);
    }

    //审批请假申请
    @Override
    public void apply(Apply apply) {
        managerMapper.apply(apply);
    }

    //添加活动
    @Override
    public void addActivity(Activity activity) {
        managerMapper.addActivity(activity);
    }

    //结束活动（删）
    @Override
    public void deleteActivity(Integer id) {
        managerMapper.deleteActivity(id);
    }

    //修改活动
    @Override
    public void updateActivity(Activity activity) {
        managerMapper.updateActivity(activity);
    }

    //查看活动详情
    @Override
    public List<Activity> getActivity() {
        return managerMapper.getActivity();
    }

    //查看某个活动的参与者
    @Override
    public List<Staff> getPaticipantsById(Integer id) {
        return managerMapper.getPaticipantsById(id);
    }

    //设置培训成绩
    @Override
    public void setScore(Score score,Integer id) {
        managerMapper.setScore(score,id);
    }

    //查看请假申请
    @Override
    public List<Apply> getApply() {
        return managerMapper.getApply();
    }

    //同意请假申请
    @Override
    public void yes(Integer id) {
        managerMapper.yes(id);
    }

    //拒绝请假申请
    @Override
    public void no(Integer id) {
        managerMapper.no(id);
    }

    //查看离职申请
    @Override
    public List<Leave> getApplyTo() {
        return managerMapper.getApplyTo();
    }

    //同意离职申请
    @Override
    public void y(Integer id) {
        managerMapper.y(id);
    }

    //拒绝离职申请
    @Override
    public void n(Integer id) {
        managerMapper.n(id);
    }
}
