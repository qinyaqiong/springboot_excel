package com.sjh.controller;

import com.sjh.pojo.Contract;
import com.sjh.service.impl.ContractServiceImpl;
import com.sjh.utils.Result;
import com.sjh.utils.ResultCode;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.util.List;


@RestController
@Api(tags = "合同项目")
public class ContractController {
    @Autowired
    private ContractServiceImpl service;



    //查询全部
    @PostMapping("/selectContract")
    @ApiOperation("查询全部")
    public List<Contract> selectall(Integer page, Integer limit){

        List<Contract> list = service.selectall();

        return list;
    }

    //模糊查询
    @RequestMapping("/moHuSelect")
    @ApiOperation(value = "模糊查询",httpMethod = "POST")
    public List<Contract> moHuSelect(String con_name, String con_tsn){
        service.moHuSelect(con_name,con_tsn);
        return service.moHuSelect(con_name,con_tsn);
    }

    //区间查询
//    @RequestMapping("/intervalSelect")
//    public List<Contract> intervalSelect(String con_money, String con_csd){
//        service.intervalSelect(con_money,con_csd);
//        return service.intervalSelect(con_money,con_csd);
//    }


    //添加
    @PostMapping("/addNewContractInfo")
    @ApiOperation("新增")
    public Result addNewContractInfo(@RequestBody  Contract contract) {
        service.addNewContractInfo(contract);
        return new Result(ResultCode.SUCCESS);
    }

    //修改
    @PostMapping("/updateContract")
    @ApiOperation("修改")
    public  Result updateById(@RequestBody Contract contract){
        service.updateById(contract);
        return new Result(ResultCode.SUCCESS);
    }


    //删除
    @GetMapping("/deleteContract")
    @ApiOperation("删除单个合同")
    public   Result deleteContract( Integer con_id){
        service.deleteContract(con_id);
        return new Result(ResultCode.SUCCESS) ;
    }
    //批量删除前端传一个数组id
    @PostMapping("/piliangshanchu")
    @ApiOperation("批量删除")
    public Result deleteContractByIds(String ids) {
        service.deleteContractByIds(ids);
        return new Result(ResultCode.SUCCESS);
    }
    //条件查询
    @PostMapping("querycontract")
    @ApiOperation("搜索")
    public List<Contract> querySpecificContract(@RequestBody Contract contract) {
        System.out.println(contract.toString());
        List<Contract> list = service.querycontract(contract);
        return list;
    }
    //导入Excel
    @PostMapping("/uploadExecl")
    @ApiOperation("导入Excel")
    public Result uploadExecl(MultipartFile file) throws Exception {
        // 判断文件是否为空
        if (file == null || file.isEmpty()){
            return new Result(ResultCode.FILE_NULL_ERROR);
        }
        // 获取文件名
        String name = file.getOriginalFilename();
        String substring = name.substring(name.lastIndexOf("."));
        if (!".xls".equals(substring)){
            throw new RuntimeException("文件格式有误");
        }
        // 判断文件大小、即名称
        long size = file.getSize();
        if (name == null || ("").equals(name) && size == 0){
            return new Result(ResultCode.FILE_NULL_ERROR);
        }

        // 把文件转换成字节流形式
        byte[] bytes = file.getBytes();
        File fileToSave =new File(file.getOriginalFilename());
        FileCopyUtils.copy(bytes,fileToSave);
        service.uploadExecl(fileToSave);
        return new Result(ResultCode.SUCCESS);


    }


    //批量导出
    @GetMapping("excelDownLoad")
    @ResponseBody
    @ApiOperation("批量导出")
    public void excelDownLoadContractByIds(HttpServletResponse response,
                                           String ids,HttpServletRequest request) throws Exception {
         service.donwLoadContractByIds(response,ids,request);
    }

    //查询合同的附件
    @GetMapping("queryFiles")
    @ApiOperation("查询合同附件")
    public Result queryFiles(String id)  {
         return service.queryFiles(id);
    }

    /**
     * 上传合同的附件
     * @param file 文件az
     * @param id 合同id
     * @param req
     * @return
     */
    @PostMapping("uploadFile")
    @ApiOperation("上传合同的附件")
    public Result uploadFile(MultipartFile file,String id,
                             HttpServletRequest req,String comment)  {
        return service.uploadFile(file,id,req,comment);
    }

    /**
     * 删除合同附件
     * @param ids 附件ids
     * @return
     */
    @PostMapping("deleteAccessory")
    @ApiOperation("删除合同附件")
    public Result deleteAccessory(@RequestBody List<Integer> ids)  {
        return service.deleteAccessory(ids);
    }

    /**
     * 下载合同附件
     * @param id
     * @return
     */
    @GetMapping("downloadAccessory")
    @ApiOperation("下载合同附件")
    public void downloadAccessory(Integer id,HttpServletResponse response)  {
        service.downloadAccessory(id,response);

    }
}
