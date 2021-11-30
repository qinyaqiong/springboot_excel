package com.sjh.mapper;


import com.sjh.pojo.ContractAccessory;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ContractAccessoryMapper {


    int deleteByPrimaryKey(Long id);

    int insert(ContractAccessory record);

    int insertSelective(ContractAccessory record);


    ContractAccessory selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(ContractAccessory record);

    int updateByPrimaryKey(ContractAccessory record);

    List<ContractAccessory> queryListByContratId(String id);

    void deleteByContractId(@Param("contractIds") String contractIds);
}