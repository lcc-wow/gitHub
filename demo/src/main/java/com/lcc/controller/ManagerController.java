package com.lcc.controller;

import com.lcc.pojo.*;
import com.lcc.service.ManagerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;


/*
*
* 管理员端
*
* */


@RestController
@RequestMapping("/manager/staffs")
public class ManagerController {

    @Autowired
    private ManagerService managerService;

    private static Logger log = LoggerFactory.getLogger(ManagerController.class);

    /*
    * 管理员工信息
    * */

    //增
    @PostMapping
    public Result add(@RequestBody Staff staff){
        log.info("新增员工,员工信息:{}",staff);
        managerService.add(staff);
        return Result.success();
    }

    //删（离职，软删除）
    @DeleteMapping("/{ids}")
    public Result delete(@PathVariable List<Integer> ids){
        log.info("批量删除员工,ids:{}",ids);
        managerService.delete(ids);
        return Result.success();
    }

    //改
    @PutMapping
    public Result update(@RequestBody Staff staff){
        log.info("修改员工信息:{}",staff);
        managerService.update(staff);
        return Result.success();
    }

    //分页条件查询
    @GetMapping
    public Result page(@RequestParam(defaultValue = "1") Integer page,
                       @RequestParam(defaultValue = "10") Integer pageSize,
                       String name,  Short gender,
                        @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate begin,
                        @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate end){
        log.info("分页查询, 参数: {},{},{},{},{},{}",page,pageSize,name,gender,begin,end);
        //调用service分页查询
        PageBean pageBean = managerService.page(page, pageSize, name, gender, begin, end);
        return Result.success(pageBean);
    }

    //根据id查询员工信息
    @GetMapping("/{id}")
    public Result getById(@PathVariable Integer id){
        log.info("根据id查询员工信息,id:{}",id);
        Staff staff = managerService.getById(id);
        return Result.success(staff);
    }

    /*
    *管理员工（出勤）
    */
    @PostMapping("/condition")
    public Result record(@RequestBody Condition condition){
        log.info("记录员工考勤");
        managerService.record(condition);
        return Result.success();
    }

    /*
    *处理请假申请
    */
    @PostMapping("/apply")
    public Result apply(@RequestBody Apply apply){
        log.info("处理请假申请");
        managerService.apply(apply);
        return Result.success();
    }

    /*
    *管理培训活动
    */

    //增加活动信息
    @PostMapping("/activity")
    public Result addActivity(@RequestBody Activity activity){
        log.info("增加活动信息");
        managerService.addActivity(activity);
        return Result.success();
    }

    //结束活动（删）
    @DeleteMapping("/activity/{id}")
    public Result deleteActivity(@PathVariable Integer id){
        log.info("结束活动");
        managerService.deleteActivity(id);
        return Result.success();
    }

    //修改活动信息
    @PutMapping("/activity")
    public Result updateActivity(@RequestBody Activity activity){
        log.info("修改活动信息");
        managerService.updateActivity(activity);
        return Result.success();
    }

    //查看活动详情
    @GetMapping("/activity")
    public Result getActivity(){
        log.info("查看活动详情");
        List<Activity> activity = managerService.getActivity();
        return Result.success(activity);
    }

    //查看某个活动的参与者
    @GetMapping("/activity/{id}")
    public Result getActivityById(@PathVariable Integer id){
        log.info("查看某个活动的参与者");
        List<Staff> paticipants = managerService.getPaticipantsById(id);
        return Result.success(paticipants);
    }

    //设置员工培训活动成绩
    @PostMapping("/activity/score")
    public Result setScore(@RequestBody Score score,@PathVariable Integer id){
        log.info("设置员工培训活动成绩");
        managerService.setScore(score,id);
        return Result.success();
    }

    //查看请假申请
    @GetMapping("/apply")
    public Result getApply(){
        log.info("查看请假申请");
        List<Apply> apply = managerService.getApply();
        return Result.success(apply);
    }

    //通过请假申请
    @PostMapping("/apply/{id}/yes")
    public Result yes(@PathVariable Integer id){
        log.info("通过请假申请");
        managerService.yes(id);
        return Result.success();
    }

    //拒绝请假申请
    @PostMapping("/apply/{id}/no")
    public Result no(@PathVariable Integer id){
        log.info("拒绝请假申请");
        managerService.no(id);
        return Result.success();
    }

    @GetMapping("/applyto")
    public Result getApplyTo(){
        log.info("查看申请离职申请");
        List<Leave> applyTo = managerService.getApplyTo();
        return Result.success(applyTo);
    }

    @PostMapping("/applyto/{id}/y")
    public Result y(@PathVariable Integer id){
        log.info("同意离职申请");
        managerService.y(id);
        return Result.success();
    }

    @PostMapping("/applyto/{id}/n")
    public Result n(@PathVariable Integer id){
        log.info("拒绝离职申请");
        managerService.n(id);
        return Result.success();
    }

}
