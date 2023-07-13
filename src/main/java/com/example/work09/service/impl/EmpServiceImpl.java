package com.example.work09.service.impl;

import com.example.work09.mapper.EmpMapper;
import com.example.work09.pojo.Emp;
import com.example.work09.service.EmpService;
import com.example.work09.utils.Result;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class EmpServiceImpl implements EmpService {

    private final EmpMapper empMapper;

    public EmpServiceImpl(EmpMapper empMapper) {
        this.empMapper = empMapper;
    }

    /**
     * 新增一个员工信息
     *
     * @param emp 员工对象
     * @return Result
     */
    @Override
    public Result saveOne(Emp emp) {
        if (isExist(emp.getUsername())) {
            return Result.error("员工用户名已存在");
        }
        LocalDate localDate = LocalDate.of(2012, 12, 23);
        emp.setEntryDate(localDate);
        emp.setCreateTime(LocalDateTime.now());
        emp.setUpdateTime(LocalDateTime.now());
        empMapper.savaOne(emp);
        return Result.success();
    }

    /**
     * 删除一个员工
     * @param id id
     * @return Result
     */
    @Override
    public Result removeById(Integer id) {
        if (!isExist(id)) {
            return Result.error("查无员工信息");
        }
        empMapper.deleteById(id);
        return Result.success();
    }

    /**
     * 根据id 更新员工信息
     * @param emp emp
     * @return Result
     */
    @Override
    public Result updateById(Emp emp) {
        if (!isExist(emp.getId())) {
            return Result.error("查无员工信息");
        } else if (isExist(emp.getUsername())) {
            return Result.error("用户名已存在请换一个试试");
        }
        emp.setUpdateTime(LocalDateTime.now());
        empMapper.updateById(emp);
        return Result.success();
    }

    /**
     * 查询所有员工信息
     * @return Result
     */
    @Override
    public Result queryList() {
        List<Emp> list = empMapper.list();
        list.stream().peek(emp -> emp.setPassword("******")).collect(Collectors.toList());
        return Result.success(list);
    }

    /**
     * 根据用户 id 查询用户详细信息
     * @param id0 id
     * @return emp
     */
    @Override
    public Result queryById(String id0) {
        Integer id = Integer.valueOf(id0);
        if (!isExist(id)) {
            return Result.error("查无员工信息");
        }
        Emp emp0 = empMapper.getEmpById(id);
        Emp emp = emp0.codePassword();
        return Result.success(emp);
    }

    /**
     * 判断员工存不存在
     * @param username 用户名
     * @return Result
     */
    boolean isExist(String username) {
        List<Emp> empList = empMapper.list();
        for (Emp emp : empList) {
            if (username.equals(emp.getUsername())) {
                return true;
            }
        }
        return false;
    }

    /**
     * 判断员工存不存在
     * @param id 员工id
     * @return Result
     */
    boolean isExist(Integer id) {
        List<Emp> empList = empMapper.list();
        for (Emp emp : empList) {
            if (id.equals(emp.getId())) {
                return true;
            }
        }
        return false;
    }
}
