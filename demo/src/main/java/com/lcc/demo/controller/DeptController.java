package com.lcc.demo.controller;

import com.lcc.demo.pojo.Dept;
import com.lcc.demo.pojo.Result;
import com.lcc.demo.service.DeptService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//对部门的增删改查
@RestController
@RequestMapping("/depts")
public class DeptController {

    @Autowired
    private DeptService deptService;

    private static Logger log=LoggerFactory.getLogger(DeptController.class);
    @GetMapping
    public Result list() {
        log.info("查询全部部门数据");
        List<Dept> deptlist = deptService.list();
        return Result.success(deptlist);
    }
    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id) {
        log.info("根据id删除部门数据");
        deptService.delete(id);
        return Result.success();
    }

    //新增部门
    @PostMapping
    public Result add(@RequestBody Dept dept) {
        //{}占位符
        log.info("新增部门：{}",dept);
        deptService.add(dept);
        return Result.success();
    }

    //修改部门
    @PutMapping
    public Result update(@RequestBody Dept dept) {
        log.info("修改部门：{}",dept);
        deptService.update(dept);
        return Result.success();
    }

}
