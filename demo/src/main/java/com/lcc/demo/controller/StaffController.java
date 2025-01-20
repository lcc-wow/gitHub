package com.lcc.demo.controller;

import com.lcc.demo.pojo.PageBean;
import com.lcc.demo.pojo.Result;
import com.lcc.demo.service.StaffService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping("/staffs")
public class StaffController {

    @Autowired
    private StaffService staffService;

    private static Logger log = LoggerFactory.getLogger(DeptController.class);


    @GetMapping
    public Result page(@RequestParam(defaultValue = "1") Integer page,
                       @RequestParam(defaultValue = "10") Integer pageSize
                       ){
        log.info("分页查询, 参数: {},{}",page,pageSize);
        //调用service分页查询
        PageBean pageBean = staffService.page(page,pageSize);
        return Result.success(pageBean);
    }


}
