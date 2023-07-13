package com.example.work09.mapper;

import com.example.work09.pojo.Emp;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface EmpMapper {

    void savaOne(Emp emp);

    /**
     * 获取全部员工信息
     * @return 员工信息集合
     */
    @Select("select * from emp")
    List<Emp> list();
}
