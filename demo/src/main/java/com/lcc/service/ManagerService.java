package com.lcc.service;

import com.lcc.pojo.*;

import java.time.LocalDate;
import java.util.List;

public interface ManagerService {

    // 分页查询
    public PageBean page(Integer page, Integer pageSize,String name, Short gender,LocalDate begin,LocalDate end);

    // 批量删除
    public void delete(List<Integer> ids);

    // 新增员工
    public void add(Staff staff);

    // 根据id查询员工
    public Staff getById(Integer id);

    // 修改员工
    public void update(Staff staff);

    // 管理员登录
    Manager login(User user);

    //记录员工考勤
    void record(Condition condition);

    //审批请假申请
    void apply(Apply apply);

    //添加活动
    void addActivity(Activity activity);

    //修改活动
    void updateActivity(Activity activity);

    //结束活动（删）
    void deleteActivity(Integer id);

    //查询活动
    List<Activity> getActivity();

    //根据活动id查询参加活动的员工
    List<Staff> getPaticipantsById(Integer id);

    //设置培训成绩
    void setScore(Score score,Integer id);

    //查询所有请假申请
    List<Apply> getApply();

    //同意请假申请
    void yes(Integer id);

    //拒绝请假申请
    void no(Integer id);

    //查询所有离职申请
    List<Leave> getApplyTo();

    //同意离职申请
    void y(Integer id);

    //拒绝离职申请
    void n(Integer id);
}
