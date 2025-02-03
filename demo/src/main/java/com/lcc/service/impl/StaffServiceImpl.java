package com.lcc.service.impl;

import com.lcc.mapper.StaffMapper;
import com.lcc.pojo.*;
import com.lcc.service.StaffService;
import com.lcc.util.AliOSSUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class StaffServiceImpl implements StaffService {
    @Autowired
    private StaffMapper staffMapper;
    @Autowired
    private AliOSSUtils aliOSSUtils;


    private static Logger log = LoggerFactory.getLogger(StaffServiceImpl.class);

    //登录
    @Override
    public Staff login(User user) {
        return staffMapper.getBy(user.getUsername(), user.getPassword());
    }

    //查看个人信息
    @Override
    public Staff getStaff(Integer id) {
        return staffMapper.getById(id);
    }

    //修改个人信息
    @Override
    public void update(Staff staff) {
        staffMapper.update(staff);
    }

    //查看工资
    @Override
    public List<Salary> getSalary(Integer id) {
        return staffMapper.getSalary(id);
    }

    //查看个人出勤
    @Override
    public List<Condition> getCondition(Integer id) {
        return staffMapper.getCondition(id);
    }

    //查看活动
    @Override
    public List<Activity> getActivity() {
        return staffMapper.getActivity();
    }

    //报名活动
    @Override
    public void joinActivity(Integer staffId, Integer activityId) {
        // 2. 查询员工是否已经参加活动
        if (staffMapper.check(staffId, activityId)) {
            throw new RuntimeException("您已经报名过该活动，请勿重复报名");
        }
    staffMapper.joinActivity(staffId, activityId);
    }

    //查询培训分数
    @Override
    public Score getScore(Integer staffId, Integer activityId) {
        return staffMapper.getScore(staffId,activityId);
    }

    //请假申请
    @Override
    public void setApply(Apply apply) {
        staffMapper.setApply(apply);
    }

    //离职申请
    @Override
    public void setApplyTo(Leave leave) {
        staffMapper.setApplyTo(leave);
    }

    //查询请假申请
    @Override
    public List<Apply> getApply(Integer id) {
        return staffMapper.getApply(id);
    }

    //查询离职申请
    @Override
    public List<Leave> getApplyTo() {
        return staffMapper.getApplyTo();
    }

}
