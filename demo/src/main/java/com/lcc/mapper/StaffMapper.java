package com.lcc.mapper;

import com.lcc.pojo.*;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface StaffMapper {

    //登录
    @Select("select * from staff where username=#{username} and password=#{password}")
    Staff getBy(String username, String password);

    //查询个人信息
    @Select("select id,username, password, name, gender, age, dept, entrydate from staff  where id=#{id}")
    Staff getById(Integer id);

    // 修改个人信息
    void update(Staff staff);

    //查询工资
    @Select("select date, basic_salary, bonus, penalty, late, early, absence, total_salary from salary where staff_id=#{id} order by date desc")
    List<Salary> getSalary(Integer id);

    //查询个人出勤
    @Select("select * from `condition` where staff_id=#{id} order by date desc")
    List<Condition> getCondition(Integer id);

    //查看活动
    @Select("select activities, details, total_member,is_ended from activity where is_ended=false")
    List<Activity> getActivity();

    //报名活动
    @Insert("insert into staff_activities(staff_id, activity_id) values (#{staffId},#{activityId})")
    void joinActivity(Integer staffId, Integer activityId);

    //查询培训分数
    @Select("select score from score where id in (select id from staff_activities where staff_id=#{staffId} and activity_id=#{activityId})")
    Score getScore(Integer staffId, Integer activityId);

    //查看是否报名
    @Select("select id from staff_activities where staff_id=#{staffId} and activity_id=#{activityId}")
    boolean check(Integer staffId, Integer activityId);

    //请假申请
    @Insert("insert into apply(staff_id, name, type, start_time, end_time, is_passed) values (#{staffId},#{name},#{type},#{startTime},#{endTime},#{isPassed})")
    void setApply(Apply apply);

    @Insert("insert into `leave` (staff_id, name,reason,date,is_passed) values (#{staffId},#{name},#{reason},#{date},#{isPassed})")
    void setApplyTo(Leave leave);

    @Select("select * from apply where staff_id=#{id}")
    List<Apply> getApply(Integer id);

    @Select("select * from `leave`")
    List<Leave> getApplyTo();

}