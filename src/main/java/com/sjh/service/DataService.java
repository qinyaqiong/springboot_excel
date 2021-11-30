package com.sjh.service;

import com.sjh.pojo.Data;
import com.sjh.utils.Result;

import javax.servlet.http.HttpServletResponse;
import java.util.Map;

public interface DataService {
    Result getDataList(Data data);

    Result addOrUpdateData(Data data);


    Result deleteData(Data data);

    Result getDataByTime(Map<String, String> map);

    Result levaeOrLoad(String num);

    void excelUpload(HttpServletResponse response,String bz,
                String beginTime,String endTime,String proID);
}
