package com.sjh.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.sjh.pojo.Project;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

@Mapper
public interface ProjectMapper extends BaseMapper<Project> {


    @Select("" +
            " select p.proname proName,count(ep.empid) as num\n" +
            "from project p,empbypro ep\n" +
            "where p.proid = ep.proid\n" +
            "and p.status = 0 " +
            "group by p.proname " +
            "")
    List<Map<String, String>> groupPro();
}
