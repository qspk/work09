package com.example.work09.service.impl;

import com.example.work09.mapper.EmpMapper;
import com.example.work09.pojo.Emp;
import com.example.work09.service.EmpService;
import com.example.work09.utils.Result;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class EmpServiceImpl implements EmpService {

    private EmpMapper empMapper;

    public EmpServiceImpl(EmpMapper empMapper) {
        this.empMapper = empMapper;
    }

    /**
     * 新增一个员工信息
     *
     * @param emp 员工对象
     * @return
     */
    @Override
    public Result saveOne(Emp emp) {
        if (isExist(emp.getUsername())) {
            return null;
        }
        LocalDate localDate = LocalDate.of(2012, 12, 23);
        emp.setEntryDate(localDate);
        emp.setCreateTime(LocalDateTime.now());
        emp.setUpdateTime(LocalDateTime.now());
        empMapper.savaOne(emp);
        return null;
    }

    /**
     * 判断员工存不存在
     * @param username
     * @return
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
}
