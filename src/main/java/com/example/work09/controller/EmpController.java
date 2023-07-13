package com.example.work09.controller;


import com.example.work09.pojo.Emp;
import com.example.work09.service.EmpService;
import com.example.work09.utils.Result;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * EmpController
 *
 * @author liliudong
 * @version 1.0
 * @description
 * @date 2023/4/28 12:59
 */
@RestController
public class EmpController {


    private final EmpService empService;

    /**
     * 这里采用了构造器注入法
     *
     * @param empService 自动注入的对象
     */
    public EmpController(EmpService empService) {
        this.empService = empService;
    }

    /**
     * 新增一个EMP员工
     *
     * @param emp emp
     * @return void
     */
    @RequestMapping("/add")
    public Result addUser(@RequestBody Emp emp) {
        return empService.saveOne(emp);

//        return Result.success();
    }

    /**
     * 根据ID删除一个员工
     *
     * @param id id
     * @return void
     */
    @RequestMapping("/del/{id}")
    public Result deleteById(@PathVariable String id) {
        Integer id0 = Integer.valueOf(id);
        return empService.removeById(id0);
    }


    /**
     * 根据ID更新一个员工信息
     * @param emp emp
     * @return void
     */
    @RequestMapping("/updateById")
    public Result updateById(@RequestBody Emp emp) {
        return empService.updateById(emp);
    }


    /**
     * 查询所有员工信息
     *
     * @return List<Emp>
     */
    @RequestMapping("/list")
    public Result list() {
        return  empService.queryList();
    }

    /**
     * 根据ID查询用户详情信息
     *
     * @param id id
     * @return Emp
     */
    @RequestMapping("/info/{id}")
    public Result infoById(@PathVariable String id) {
        return empService.queryById(id);

    }

}
