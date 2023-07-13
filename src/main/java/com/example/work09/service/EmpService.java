package com.example.work09.service;

import com.example.work09.pojo.Emp;
import com.example.work09.utils.Result;

public interface EmpService {
    Result saveOne(Emp emp);

    Result removeById(String id);

    Result updateById(Emp emp);

    Result queryList();

    Result queryById(String id);
}
