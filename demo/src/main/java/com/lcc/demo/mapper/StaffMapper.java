package com.lcc.demo.mapper;

import com.lcc.demo.pojo.Staff;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.time.LocalDate;
import java.util.List;

@Mapper
public interface StaffMapper {

    @Select("select*from staff")
    List<Staff> list();
}