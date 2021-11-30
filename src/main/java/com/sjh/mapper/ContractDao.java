package com.sjh.mapper;

import com.sjh.pojo.Contract;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Mapper
public interface ContractDao {
    //修改
    void updateById(Contract contract);
    // 删除
    Integer deleteContract(Integer con_id);
  //批量删除
    Integer deleteContractByIds(@Param("ids") String con_id);
   //新增
    void addNewContractInfo(Contract contract);

    //查询全部
    List<Contract> selectall();
    //模糊查询
    List<Contract> moHuSelect(@Param("con_name")  String con_name,@Param("con_tsn") String con_tsn);
    //条件查询
    List<Contract> querycontract(Contract contract);
    //区间查询
    List<Contract> intervalSelect();



    //批量导出
    List<Contract> excelDownLoad(@Param("ids") String con_ids);

}
