package com.sjh.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.sjh.pojo.Data;
import com.sjh.pojo.vo.DataVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

@Mapper
public interface DataMapper extends BaseMapper<Data> {


    //根据项目筛选 以公司进行分组
//    @Select(" " +
//            " select p.proname as proNameVo,c.comname as comNameVo,e.empname empNameVo,e.post postVo,sum(d.codeline) as codeLineVo " +
//            " from emp e,empbypro ep,project p,data d,company c " +
//            " where e.empid = ep.empid " +
//            " and ep.proid = p.proid " +
//            " and e.empid = d.empid " +
//            " and c.comid = e.comid " +
//            " group by p.proname,c.comname,e.empname,e.post" +
//            " " +
//            "")
    @Select("" +
            " select p.proname as proNameVo,c.comname as comNameVo,e.empname empNameVo,e.post postVo,sum(d.codeline) as codeLineVo \n" +
            "from emp e,empbypro ep,company c,project p,data d\n" +
            "where e.empid = ep.empid\n" +
            "and ep.proid = p.proid\n" +
            "and c.comid = e.comid\n" +
            "and d.proid = p.proid\n" +
            "and d.empid = e.empid\n" +
            "and d.empid = ep.empid\n" +
            "and p.proid = #{proID}" +
            "group by c.comid,c.comname,p.proname,e.empname,e.post " +
            "")
    List<DataVo> selectDataByPro(@Param("proID") String proID);

    //根据日期筛选 一公司进行分组
    @Select(" <script> " +
            " select c.comname as comNameVo ,e.empname empNameVo ,e.post postVo ,sum(a.codeline) as codeLineVo ,a.logdate AS logDateVo" +
            " from data a,emp e,company c " +
            " where e.comid = c.comid " +
            " and e.empid = a.empid " +
            " <if test='#{beginTime} !=null and #{endTime} != null '> " +
            " and a.logdate between to_date(to_char(to_date(#{beginTime},'yyyy-MM-dd')-1,'yyyy-MM-dd'),'yyyy-MM-dd') and to_date(to_char(to_date(#{endTime},'yyyy-MM-dd')+1,'yyyy-MM-dd'),'yyyy-MM-dd') " +
            "</if>" +
            " group by c.comid,c.comname,e.empname,e.post,a.logdate " +
            " </script> ")
    List<DataVo> selectDataByTime(@Param("beginTime") String beginTime, @Param("endTime") String endTime);


    //根据日期以及项目进行查询数据列表
    @Select(" <script> " +
            " select d.dataID AS dataID,d.empID AS empID,e.empName as empName,p.proName as proName,p.PROID as proID,d.LOGDATE AS logDate,d.CODELINE as codeline" +
            " from data d,emp e,project p,empbypro ep" +
            " where 1 = 1 " +
            " and d.empid = e.empid " +
            " and e.empid = ep.empid " +
            " and ep.proid = p.proid " +
            " and d.proid = p.proid " +
            " <if test=' proID != null'> and d.proid = #{proID} </if>" +
            " <if test = 'logdate !=null '> and trunc(d.logdate) = trunc(to_date(#{logdate},'yyyy-MM-dd'))  </if> " +
            " <if test = 'emp != null'>" +
            " and e.empid in  " +
            "   <foreach item='item' index='index' collection='emp' open='(' separator=',' close=')' > " +
            "     #{item.empID} " +
            "   </foreach>" +
            "</if> " +
            " </script> ")
    public List<Data> getProListBy(Map<String, Object> map);


    //根据时间段查看各家公司完成代码量情况
    @Select("" +
            " select c.comname as comNameVo,sum(d.codeline) AS codeLineVo\n" +
            " from company c,data d,emp e\n" +
            " where c.comid = e.comid\n" +
            " and e.empid = d.empid\n" +
            " and d.logdate between to_date(to_char(to_date(#{beginTime},'yyyy-MM-dd')-1,'yyyy-MM-dd'),'yyyy-MM-dd') and to_date(to_char(to_date(#{endTime},'yyyy-MM-dd')+1,'yyyy-MM-dd'),'yyyy-MM-dd')\n" +
            " group by c.comid,c.comname " +
            "")
    List<DataVo> selectDataByTimeTwo(@Param("beginTime") String beginTime, @Param("endTime") String endTime);

    @Select("<script>" +
            " select data.dataid AS dataID,data.empid as empID,e.empname as empName,p.proname as proName,p.proid as proID,data.logdate as logDate,data.codeline as codeLine " +
            " from data,project p,emp e " +
            " where data.proid = p.proid " +
            " and data.empid = e.empid " +
            " and data.logdate between to_date(#{beginTime},'yyyy-MM-dd') and to_date(to_char(to_date(#{endTime},'yyyy-MM-dd')+1,'yyyy-MM-dd'),'yyyy-MM-dd') " +
            " group by data.empid,data.codeline,data.dataid,e.empname,p.proname,p.proid,data.logdate\n" +
            " <if test='num gt 14999'>having sum(data.codeline) &gt; #{num}</if> " +
            " <if test='num lt 101'>having sum(data.codeline) &lt; #{num}</if> " +
            "</script>")
    List<Data> selectLevaeOrLoad(@Param("num") int i, @Param("beginTime") String beginTime, @Param("endTime") String endTime);
}
