package com.lcc.controller;

import com.lcc.pojo.*;
import com.lcc.service.StaffService;
import com.lcc.util.jwtUtils;
import io.jsonwebtoken.Claims;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

/*
 *
 * 员工端
 *
 * */

@RestController
@RequestMapping("/staff")
public class StaffController {

    private static Logger log = LoggerFactory.getLogger(StaffController.class);

    @Autowired
    private StaffService staffService;

    /*
     * 查看个人信息
     */
    @GetMapping
    public Result getStaff(@RequestHeader("Authorization")String token) {
        // 去掉Bearer前缀
        String jwtToken = token.replace("Bearer ", "");
        // 验证并解析JWT
        Claims claims = jwtUtils.parseJWT(jwtToken);
        // 从claims中获取员工id
        Integer id = claims.get("id", Integer.class);
        Staff staff = staffService.getStaff(id);
        log.info("查看个人信息:{}", staff);
        return Result.success(staff);
    }

    /*
     * 修改个人信息
     */
    @PutMapping
    public Result update(@RequestBody Staff staff) {
        log.info("修改个人信息:{}", staff);
        staffService.update(staff);
        return Result.success();
    }

    /*
     * 查看工资
     */
    @GetMapping("/salary")
    public Result getSalary(@RequestHeader("Authorization")String token) {
        // 去掉Bearer前缀
        String jwtToken = token.replace("Bearer ", "");
        // 验证并解析JWT
        Claims claims = jwtUtils.parseJWT(jwtToken);
        // 从claims中获取员工id
        Integer id = claims.get("id", Integer.class);
        List<Salary> salary = staffService.getSalary(id);
        return Result.success(salary);
    }

    /*
     *查看出勤状态
     */
    @GetMapping("/condition")
    public Result getCondition(@RequestHeader("Authorization")String token) {
        // 去掉Bearer前缀
        String jwtToken = token.replace("Bearer ", "");
        // 验证并解析JWT
        Claims claims = jwtUtils.parseJWT(jwtToken);
        // 从claims中获取员工id
        Integer id = claims.get("id", Integer.class);
        List<Condition> condition = staffService.getCondition(id);
        return Result.success(condition);
    }

    /*
     *查看活动信息
     */
    @GetMapping("/activity")
    public Result getActivity() {
        log.info("查看活动信息");
        List<Activity> activity = staffService.getActivity();
        return Result.success(activity);
    }

    /*
     *参与培训活动
     */
    @PostMapping("/activity")
    public Result activity(@RequestHeader("Authorization")String token,@RequestParam Integer activityId) {
        // 去掉Bearer前缀
        String jwtToken = token.replace("Bearer ", "");
        // 验证并解析JWT
        Claims claims = jwtUtils.parseJWT(jwtToken);
        // 从claims中获取员工id
        Integer staffId = claims.get("id", Integer.class);
        log.info("{} 参与 {} 活动",staffId, activityId);
        staffService.joinActivity(staffId, activityId);
        return Result.success();
    }

    /*
     *查看培训分数
     */
    @GetMapping("/activity/score")
    public Result getScore(@RequestHeader("Authorization")String token,@RequestParam Integer activityId) {
        // 去掉Bearer前缀
        String jwtToken = token.replace("Bearer ", "");
        // 验证并解析JWT
        Claims claims = jwtUtils.parseJWT(jwtToken);
        // 从claims中获取员工id
        Integer staffId = claims.get("id", Integer.class);
        log.info("{} 查看 {} 活动分数",staffId, activityId);
        Score score = staffService.getScore(staffId, activityId);
        return Result.success(score);
    }

    /*
     *请假申请
     */
    @PostMapping("/apply")
    public Result apply(@RequestBody Apply apply) {
        log.info("请假申请:{}",apply);
        staffService.setApply(apply);
        return Result.success();
    }

    /*
     * 离职申请
     */
    @PostMapping("/applyto")
    public Result applyTo(@RequestBody Leave leave) {
        log.info("请假申请:{}",leave);
        staffService.setApplyTo(leave);
        return Result.success();
    }

    /*
     * 查看申请结果
     */
    @GetMapping("/apply")
    public Result getApply() {
        log.info("查看请假申请结果");
        List<Apply> apply = staffService.getApply();
        return Result.success(apply);
    }

    @GetMapping("/applyto")
    public Result getApplyTo() {
        log.info("查看离职申请结果");
        List<Leave> apply = staffService.getApplyTo();
        return Result.success(apply);
    }


}