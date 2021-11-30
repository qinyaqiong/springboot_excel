package com.sjh.service.impl;

import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.ExcelImportUtil;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import cn.afterturn.easypoi.excel.entity.ImportParams;
import com.sjh.mapper.ContractAccessoryMapper;
import com.sjh.mapper.ContractDao;
import com.sjh.pojo.Contract;
import com.sjh.pojo.ContractAccessory;
import com.sjh.service.ContractService;
import com.sjh.utils.IdWorker;
import com.sjh.utils.Result;
import com.sjh.utils.ResultCode;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.List;

@Service
public class ContractServiceImpl implements ContractService {
    @Autowired
    private ContractDao dao;

    @Autowired
    private ContractAccessoryMapper accessoryMapper;

    @Value("${filePath}")
    String accessoryFilePath;

    public List<Contract> selectall(){
        List<Contract> list = dao.selectall();
        return list;
    }

    //模糊查询
    @Override
    public List<Contract> moHuSelect(String con_name, String con_tsn) {

        return dao.moHuSelect(con_name,con_tsn);
    }


    //添加
    @Override
    public void addNewContractInfo(Contract contract){
        dao.addNewContractInfo(contract);
    }
    //修改
    @Override
    public void updateById(Contract contract) {
        if(contract.getCon_id() == null || contract.getCon_id() == 0){
             dao.addNewContractInfo(contract);
        }else {
            dao.updateById(contract);
        }
    }
    //条件查询
    public List<Contract> querycontract(Contract entity) {
        List<Contract> list = dao.querycontract(entity);
        return list;
    }

    @Override
    public void uploadExecl(File file) {


        //读取Excel的数据，ImportExcel是自己封装的model对象，用于匹对接收导入的Excel内容
        List<Contract> list= ExcelImportUtil.importExcel(file, Contract.class,new ImportParams());
        file.delete();
        for (Contract  contract: list){
            contract.setCon_id(null);
            // 入库
            dao.addNewContractInfo(contract);
        }


    }

    @Override
    public Result queryFiles(String id) {
       List<ContractAccessory> accessories =  accessoryMapper.queryListByContratId(id);

        return new Result(ResultCode.SUCCESS,accessories);
    }

    //删除
    @Override
    public void deleteContract(Integer con_id) {
        Integer integer1 = dao.deleteContract(con_id);
        File file = new File(accessoryFilePath + con_id);
        deleteAccessory(file);
        accessoryMapper.deleteByContractId(String.valueOf(con_id));

    }
    //批量删除
    @Override
    public String deleteContractByIds(String ids){

        Integer hh = dao.deleteContractByIds(ids);
        if(ids.contains(",")){
            String[] split = ids.split(",");
            for (String s : split) {
                File file = new File(accessoryFilePath + s);
                deleteAccessory(file);

            }
        }else {
            File file = new File(accessoryFilePath + ids);
            deleteAccessory(file);
        }
        accessoryMapper.deleteByContractId(ids);
        return  String.valueOf(hh);
    }
    // 删除合同附件
    private void deleteAccessory(File path){
            if (!path.exists())
                return;
            if (path.isFile()) {
                path.delete();
                return;
            }
            File[] files = path.listFiles();
            for (int i = 0; i < files.length; i++) {
                deleteAccessory(files[i]);
            }
            path.delete();

    }

    //批量导出
    @Override
    public void donwLoadContractByIds(HttpServletResponse response, String ids, HttpServletRequest request){

        //获取Data集合
        List<Contract> dataVoList =dao.excelDownLoad(ids);
        //创建完数据之后
        String fileName = "excelData.xls";
        try {
            Workbook workbook = ExcelExportUtil.exportExcel(new ExportParams(),
                    Contract .class,dataVoList );
            response.reset();
            response.addHeader("Content-Disposition", "attachment;filename=" + fileName);
            OutputStream oStream = new BufferedOutputStream(response.getOutputStream());
            response.setContentType("application/vnd.ms-excel;charset=gb2312");
            response.setHeader("Access-Control-Allow-Origin","*");
            workbook.write(oStream);
            oStream.flush();
            oStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public Result uploadFile(MultipartFile file, String id,HttpServletRequest req,String comment) {
        if(file==null || file.getSize() == 0){
            return new Result(ResultCode.FILE_NULL_ERROR);
        }
        String filename = file.getOriginalFilename();
        String fileType = filename.substring(filename.lastIndexOf(".")+1);
        String folderPath = accessoryFilePath+id+"/";
        File folder=new File(folderPath);
        if(!folder.isDirectory()){
            if(!folder.mkdirs()){
                throw new RuntimeException("文件夹创建失败");
            }
        }
        try {
            String filePath = IdWorker.generateId() + filename;
            FileCopyUtils.copy(file.getBytes(),new File(folder,filePath));
//            file.transferTo(newFile);
        // 存入文件相关信息
            String filePath1=req.getScheme()+"://"+req.getServerName()+":"+req.getServerPort()+accessoryFilePath+id+"/"+filePath;
            ContractAccessory contractAccessory = new ContractAccessory();
            contractAccessory.setAccessoryName(filePath);
            contractAccessory.setContractId(Long.valueOf(id));
            contractAccessory.setAccessorySize(file.getSize());
            contractAccessory.setAccessoryUrl(filePath1);
            contractAccessory.setAccessoryType(fileType);// 文件类型
            contractAccessory.setAccessoryComment(comment);// 备注
            accessoryMapper.insert(contractAccessory);
        } catch (IOException e) {

            throw new RuntimeException("上传失败", e);
        }
        return new Result(ResultCode.SUCCESS);
    }

    /**
     * 删除合同附件
     * @param ids
     * @return
     */
    @Override
    public Result deleteAccessory(List<Integer> ids) {
        for (Integer id : ids) {
            ContractAccessory contractAccessory = accessoryMapper.selectByPrimaryKey(Long.valueOf(id));
            File file = new File(accessoryFilePath + contractAccessory.getContractId() +"/"+ contractAccessory.getAccessoryName());
            if(file.exists()){

                file.delete();
            }
            accessoryMapper.deleteByPrimaryKey(Long.valueOf(id));
        }

        return new Result(ResultCode.SUCCESS);
    }

    @Override
    public void downloadAccessory(Integer id,HttpServletResponse response) {
        ContractAccessory contractAccessory = accessoryMapper.selectByPrimaryKey(Long.valueOf(id));
        String fileName = contractAccessory.getAccessoryName();
        File file = new File(accessoryFilePath + contractAccessory.getContractId() +"/"+ fileName);
        if(!file.exists()){
            throw new RuntimeException("文件不存在，请检查~");
        }
        response.setCharacterEncoding("utf-8");
//        response.setContentType("application/octet-stream");
        response.setContentType("application/x-msdownload");
        response.setHeader("Content-Disposition","attachment;filename="+fileName);
        byte[] bytes = new byte[1024*10];
        BufferedInputStream ins = null;
        OutputStream out = null;
        try {
            out = response.getOutputStream();
            ins = new BufferedInputStream(new FileInputStream(file));
            int i = 0;
            while ((i=ins.read(bytes))!=-1){
                out.write(bytes,0,i);
                out.flush();
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try {
                ins.close();
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
