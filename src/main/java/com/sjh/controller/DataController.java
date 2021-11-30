package com.sjh.controller;

import com.sjh.pojo.Data;
import com.sjh.service.DataService;
import com.sjh.utils.Result;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * @author sjh
 * @date 2020/5/8
 */
@RestController
@CrossOrigin
public class DataController {

    @Resource
    private DataService dataService;

    //数据列表
    @PostMapping("getDataList")
    private Result getDataList(@RequestBody Data data){
        return dataService.getDataList(data);
    }
    @PostMapping("excelUpload")
    private Result excelUpload(HttpServletResponse response,String bz,String beginTime,String endTime,String proID){
        dataService.excelUpload(response,bz,
              beginTime,endTime,proID);
        return new Result();
    }



    //录入、修改每个人每天的代码量
    @PostMapping("addOrUpdateData")
    private Result addOrUpdateData(@RequestBody Data data){
        return dataService.addOrUpdateData(data);
    }

    //删除数据
    @DeleteMapping("deleteData")
    private Result deleteData(@RequestBody Data data){
        return dataService.deleteData(data);
    }

    //根据时间段，查看各家公司完成代码量情况
    @PostMapping("getDataByTime")
    private Result getDataByTime(@RequestBody Map<String,String> map){
        return dataService.getDataByTime(map);
    }

    //闲置人员与超负荷人员的列表信息
    @GetMapping("levaeOrLoad/{num}")
    private Result levaeOrLoad(@PathVariable("num") String num){
        return dataService.levaeOrLoad(num);
    }

}
