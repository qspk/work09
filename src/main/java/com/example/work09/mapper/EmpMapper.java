package com.example.work09.mapper;

import com.example.work09.pojo.Emp;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;


/**
 * @author Administrator
 */
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
//    @Select("select * from emp")
    List<Emp> list();


    /**
     * 根据 id 删除一个员工
     *
     * @param id id
     */
    @Delete("delete from emp where id=#{id}")
    void deleteById(Integer id);

    /**
     * 更新员工信息
     * @param emp emp
     */
    void updateById(Emp emp);

//    @Select("select * from emp where id = #{id} ")
    Emp getEmpById(Integer id);

    /**
     * 查询username是否存在
     * @param username username
     * @return 指定username的数量
     */
    @Select("select count(*) from emp where username = #{username} ")
    int selectCountByUsername(String username);


    /**
     * 查询 id 是否存在
     *
     * @param id id
     * @return 指定 id 的数量
     */
    @Select("select count(*) from emp where id = #{id} ")
    int selectCountById(Integer id);
}
