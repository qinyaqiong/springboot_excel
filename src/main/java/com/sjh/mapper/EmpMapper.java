package com.sjh.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.sjh.pojo.vo.DataVo;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

@Mapper
public interface EmpMapper<Employee> extends BaseMapper<Employee> {

    //添加员工与项目的关联关系
    @Insert("" +
            " insert into EMPBYPRO(EMPID,PROID) values (#{empID},#{proID}) " +
            "")
    int empByProject(@Param("empID") String empID,@Param("proID") String proID);


    //根据公司分组导出所有员工
    @Select(" " +
            " select c.comname as comNameVo,e.empname as empNameVo ,e.post as postVo from emp e,company c where e.comid = c.comid group by c.comname,e.empname,e.post " +
            " ")
    List<DataVo> selectEmpByCom();

    //删除员工与项目的关系
    @Delete(" " +
            " delete from EMPBYPRO where EMPID = #{empID} " +
            " ")
    int deleteEmpByPro(@Param("empID") String empID);

    //根据项目ID查询员工列表
    @Select(" " +
            " select e.empid,e.empname,e.post " +
            " from emp e ,project p,empbypro ep " +
            " where e.empid = ep.empid " +
            " and ep.proid = p.proid " +
            " and p.proid =  #{proID} ")
    List<Employee> getEmpListByProID(@Param("proID") String proID);

    @Select("select count(*) from EMPBYPRO where EMPID = #{empID} and PROID = #{proID}")
    int selectEmpByPro(@Param("empID") String empID, @Param("proID") String proID);

    @Select("" +
            " select post as post,count(1) as num\n" +
            " from emp " +
            " group by post " +
            "")
    List<Map<String, String>> groupEmp();
}
