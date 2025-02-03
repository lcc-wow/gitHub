package com.lcc.mapper;

import com.lcc.pojo.*;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.time.LocalDate;
import java.util.List;

@Mapper
public interface ManagerMapper {

    //批量删除（软删除）
    void delete(List<Integer> ids);

    //新增员工
    @Insert("insert into staff(username, name, gender, age, dept, entrydate, create_time, update_time)"+
    "values(#{username},#{name},#{gender},#{age},#{dept},#{entrydate},#{createTime},#{updateTime})")
    void save(Staff staff);

    //根据id查询员工
    @Select("select id, name, gender, age, dept, entrydate, create_time, update_time from staff where id=#{id}")
    Staff getById(Integer id);

    //修改员工
    void update(Staff staff);

    //登录
    @Select("select * from manager where username=#{username} and password=#{password}")
    Manager getBy(String username, String password);

    //分页条件查询
    List<staffs> list(String name, Short gender, LocalDate begin, LocalDate end);

    //记录员工考勤
    @Insert("insert into `condition`(staff_id,name,`condition`,date,punish)"+
            "values (#{staffId},#{name},#{condition},#{date},#{punish})")
    void record(Condition condition);

    //审批请假申请
    @Insert("insert into apply(staff_id,name,type,start_time,end_time,is_passed)"+
    "values (#{staffId},#{name},#{type},#{startTime},#{endTime},#{isPassed})")
    void apply(Apply apply);

    //添加活动
    @Insert("insert into activity(activities,details,total_member)"+
    "values (#{activities},#{details},#{totalMember})")
    void addActivity(Activity activity);

    //修改活动
    void updateActivity(Activity activity);

    //结束活动（删）
    @Update("update activity set is_ended = true where id=#{id} ")
    void deleteActivity(Integer id);

    //查询活动（查）
    @Select("select id,activities, details, total_member, is_ended from activity ")
    List<Activity> getActivity();

    //查询活动参加人员
    List<Staff> getPaticipantsById(Integer id);

    //设置培训成绩
    void setScore(Score score,Integer id);

    //查询请假申请
    @Select("select staff_id,name,type,start_time,end_time from apply where is_passed is null ")
    List<Apply> getApply();

    //通过申请
    @Update("update apply set is_passed=true where staff_id=#{id}")
    void yes(Integer id);

    //不通过申请
    @Update("update apply set is_passed=false where staff_id=#{id}")
    void no(Integer id);

    //查询离职申请
    @Select("select staff_id, name, reason from `leave` where is_passed is null")
    List<Leave> getApplyTo();

    //通过申请
    @Update("update `leave` set is_passed = true where staff_id=#{id}")
    void y(Integer id);

    //不通过申请
    @Update("update `leave` set is_passed = false where staff_id=#{id}")
    void n(Integer id);
}