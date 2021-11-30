package com.sjh.service;

import com.sjh.controller.ContractController;
import com.sjh.pojo.Contract;
import com.sjh.utils.Result;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.util.List;

public interface ContractService {
   /* static List<ContractController> findByForeach(List<String> data) {
        return null;
    }*/

    List<Contract> moHuSelect(String con_name, String con_tsn);

    void addNewContractInfo(Contract contract);

    void updateById(Contract contract);


//批量删除
  String  deleteContractByIds(String ids);

  // 删除单个
  public void deleteContract(Integer con_id);


  //批量导出
  void donwLoadContractByIds(HttpServletResponse response, String ids, HttpServletRequest request) throws Exception;

  // 查询
  List<Contract> querycontract(Contract contract);

  // 导入excel
  void uploadExecl(File fileToSave);

  Result queryFiles(String id);

  // 上传合同附件
  public Result uploadFile(MultipartFile file, String id,
                           HttpServletRequest req,String comment);

    Result deleteAccessory(List<Integer> ids);

    void downloadAccessory(Integer id,HttpServletResponse response);
}

