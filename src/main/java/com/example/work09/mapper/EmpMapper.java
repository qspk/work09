package com.example.work09.mapper;

import com.example.work09.pojo.Emp;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface EmpMapper {

    /**
     * 添加一个员工信息
     *
     * @param emp 员工对象
     */
    void savaOne(Emp emp);


    /**
     * 获取全部员工信息
     *
     * @return 员工信息集合
     */
    @Select("select * from emp")
    List<Emp> list();


    /**
     * 根据 id 删除一个员工
     *
     * @param id id
     */
    @Delete("delete from emp where id=#{id}")
    void deleteById(Integer id);

    /**
     * @param emp
     */
    void updateById(Emp emp);

    @Select("select * from emp where id = #{id} ")
    Emp getEmpById(Integer id);
}
