package com.sjh.service.impl;

import com.sjh.mapper.DataMapper;
import com.sjh.mapper.EmpMapper;
import com.sjh.pojo.Data;
import com.sjh.pojo.Employee;
import com.sjh.service.DataService;
import com.sjh.utils.Result;
import com.sjh.utils.ResultCode;
import com.sjh.pojo.vo.DataVo;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author sjh
 * @date 2020/5/7
 */
@Service("DataService")
@Transactional
public class DateServiceImpl implements DataService {

    @Resource
    private DataMapper dataMapper;
    @Resource
    private EmpMapper empMapper;

    //获得数据列表
    @Override
    public Result getDataList(Data data) {
        List<Employee> empListByProID = null;
        Map<String,Object> map = new HashMap<>();
        if(data.getLogDate() == null || data.getLogDate().toString() == ""){//日期
            data.setLogDate(null);
            map.put("logdate",null);
        }else{
            map.put("logdate",new SimpleDateFormat("yyyy-MM-dd").format(data.getLogDate()).toString());
        }
        if(!StringUtils.isEmpty(data.getProID())){//查询项目所属员工
            empListByProID = empMapper.getEmpListByProID(data.getProID());
            if(empListByProID.size() > 0){
                map.put("emp",empListByProID);
            }else{
                map.put("emp",null);
            }
        }
        if(!StringUtils.isEmpty(data.getProID())){
            map.put("proID",data.getProID());
        }else{
            map.put("proID",null);
        }

        List<Data> proListBy = dataMapper.getProListBy(map);
        return new Result(ResultCode.SUCCESS,proListBy);
    }

    //录入、修改数据列表
    @Override
    public Result addOrUpdateData(Data data) {
        Integer insert = 0;
        if(!StringUtils.isEmpty(data.getDataID())){
            //添加之前查看该员工是否已经关联此项目
            int i = empMapper.selectEmpByPro(data.getEmpID(), data.getProID());
            if(i > 0){
                insert = dataMapper.updateById(data);
            }else{
                return new Result(ResultCode.EMI_IS_NO_PRO);
            }
        }else{
            int i = empMapper.selectEmpByPro(data.getEmpID(), data.getProID());
            if(i > 0){
                insert = dataMapper.insert(data);
            }else{
                return new Result(ResultCode.EMI_IS_NO_PRO);
            }
        }

        return insert > 0 ? new Result(ResultCode.SUCCESS) : new Result(ResultCode.ERROR);
    }



    //数据报表的导出

    public void excelUpload(HttpServletResponse response,String bz,String beginTime,String endTime,String proID) {
        //创建WorkBook对象
        HSSFWorkbook hssfWorkbook = new HSSFWorkbook();
        HSSFSheet sheet = hssfWorkbook.createSheet("数据报表");
        //根据不同的导出方式，创建不同的列
        //根据项目,以公司分组导出员工的代码总行数
        String[] titlePro = {"项目名称","公司名称","员工姓名","员工职务","代码行数"};
        //根据时间段，以公司分组导出员工的代码总行数
        String[] titleTime = {"公司名称","员工姓名","员工职务","代码行数","日期"};
        //根据公司分组导出所有员工
        String[] titleEmp = {"公司名称","员工姓名","员工职务"};
        //创建表头
        HSSFRow row = sheet.createRow(0);
        AtomicInteger integer = new AtomicInteger();
        AtomicInteger integerRow = new AtomicInteger(1);
        //获取Data集合
        List<DataVo> dataVoList = getDataVoList(bz,beginTime,endTime,proID);

        if(bz.equals("Pro")){//根据标志创建不同的表头
            for (String s : titlePro) {
                row.createCell(integer.getAndIncrement()).setCellValue(s);//创建单元格并赋值表头
            }
            //生成Excel表格文档
            for (DataVo dataVo : dataVoList) {
                HSSFRow rowCell = sheet.createRow(integerRow.getAndIncrement());
                rowCell.createCell(0).setCellValue(dataVo.getProNameVo());
                rowCell.createCell(1).setCellValue(dataVo.getComNameVo());
                rowCell.createCell(2).setCellValue(dataVo.getEmpNameVo());
                rowCell.createCell(3).setCellValue(dataVo.getPostVo());
                rowCell.createCell(4).setCellValue(dataVo.getCodeLineVo());
            }
        }else if(bz.equals("Time")){
            for (String s : titleTime) {
                row.createCell(integer.getAndIncrement()).setCellValue(s);//创建单元格并赋值表头
            }
            //生成Excel表格文档
            for (DataVo dataVo : dataVoList) {
                HSSFRow rowCell = sheet.createRow(integerRow.getAndIncrement());
                rowCell.createCell(0).setCellValue(dataVo.getComNameVo());
                rowCell.createCell(1).setCellValue(dataVo.getEmpNameVo());
                rowCell.createCell(2).setCellValue(dataVo.getPostVo());
                rowCell.createCell(3).setCellValue(dataVo.getCodeLineVo());
                String str = dataVo.getLogDateVo().substring(0,11);
                rowCell.createCell(4).setCellValue(str);
            }
        }else if(bz.equals("Emp")){
            for (String s : titleEmp) {
                row.createCell(integer.getAndIncrement()).setCellValue(s);//创建单元格并赋值表头
            }
            //生成Excel表格文档
            for (DataVo dataVo : dataVoList) {
                HSSFRow rowCell = sheet.createRow(integerRow.getAndIncrement());
                rowCell.createCell(0).setCellValue(dataVo.getComNameVo());
                rowCell.createCell(1).setCellValue(dataVo.getEmpNameVo());
                rowCell.createCell(2).setCellValue(dataVo.getPostVo());
            }
        }
        //创建完数据之后
        String fileName = "excelData.xls";
        try {
            response.reset();
            response.addHeader("Content-Disposition", "attachment;filename=" + fileName);
            OutputStream oStream = new BufferedOutputStream(response.getOutputStream());
            response.setContentType("application/vnd.ms-excel;charset=gb2312");
            hssfWorkbook.write(oStream);
            oStream.flush();
            oStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    //删除数据列表
    @Override
    public Result deleteData(Data data) {
        Integer integer = 0;
        if(!StringUtils.isEmpty(data)){
            integer = dataMapper.deleteById(data.getDataID());
        }
        return integer > 0 ? new Result(ResultCode.SUCCESS) : new Result(ResultCode.ERROR);
    }

    //根据时间段，查看各家公司完成代码量情况
    @Override
    public Result getDataByTime(Map<String, String> map) {
        String beginTime = map.get("beginTime").toString();
        String endTime = map.get("endTime").toString();
        List<DataVo> dataVos = dataMapper.selectDataByTimeTwo(beginTime,endTime);
        return new Result(ResultCode.SUCCESS,dataVos);
    }

    //闲置人员与超负荷人员信息
    @Override
    public Result levaeOrLoad(String num) {
        //获得当前时间
        Date date = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.MONTH,-1);//当前时间减去一个月
        Date time = calendar.getTime();//获取一个月之前的时间
        String beginTime = new SimpleDateFormat("yyyy-MM-dd").format(time);//一个月之前的时间
        String endTime = new SimpleDateFormat("yyyy-MM-dd").format(new Date());//现在的时间
        int i = Integer.parseInt(num);
        List<Data> datas = dataMapper.selectLevaeOrLoad(i,beginTime,endTime);
        return new Result(ResultCode.SUCCESS,datas);
    }

    //根据标志查询不同的数据集合
    private List<DataVo> getDataVoList(String bz,String beginTime,String endTime,String proID){
        List<DataVo> dataVos = new ArrayList<>();
        if(bz.equals("Pro")){
            //根据项目进行分组,查数据报表
            dataVos = dataMapper.selectDataByPro(proID);
        }else if(bz.equals("Time")){
            //根据时间段进行分组,查数据报表
            dataVos = dataMapper.selectDataByTime(beginTime,endTime);
        }else if(bz.equals("Emp")){
            //根据公司进行分组，查询所有员工
            dataVos = empMapper.selectEmpByCom();
        }
        return dataVos;
    }
}
