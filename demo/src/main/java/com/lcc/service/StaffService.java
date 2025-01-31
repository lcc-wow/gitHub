package com.lcc.service;


import com.lcc.pojo.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface StaffService {

    //员工登录
    Staff login(User user);

    //查看个人信息
    Staff getStaff(Integer id);

    //修改个人信息
    void update(Staff staff);

    //查看工资
    List<Salary> getSalary(Integer id);

    //查看个人出勤
    List<Condition> getCondition(Integer id);

    //查看活动
    List<Activity> getActivity();

    //参加活动
    void joinActivity(Integer staffId, Integer activityId);

    //查看培训分数
    Score getScore(Integer staffId, Integer activityId);

    //提交请假申请
    void setApply(Apply apply);

    //提交离职申请
    void setApplyTo(Leave leave);

    //查看请假申请结果
    List<Apply> getApply();

    //查看离职申请结果
    List<Leave> getApplyTo();

}
