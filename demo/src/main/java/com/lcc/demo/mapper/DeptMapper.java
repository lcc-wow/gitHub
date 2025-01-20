package com.lcc.demo.mapper;

import com.lcc.demo.pojo.Dept;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface DeptMapper {
    //用以查询全部部门信息
    @Select("select * from dept")
    List<Dept> list();

    //用以删除部门信息
    @Select("delete from dept where id = #{id}")
    void delete(Integer id);

    //用以添加部门信息
    @Insert("insert into dept(name,create_time,update_time) values(#{name},#{createTime},#{updateTime})")
    void add(Dept dept);

    //用以修改部门信息
    @Insert("update dept set name = #{name},create_time = #{createTime},update_time = #{updateTime} where id = #{id}")
    void update(Dept dept);

    @Select("select * from dept where id = #{id}")
    Dept getById(Integer id);
}
