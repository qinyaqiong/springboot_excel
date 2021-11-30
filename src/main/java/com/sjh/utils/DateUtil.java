package com.sjh.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author sjh
 * @date 2020/5/9
 */
public class DateUtil {

    /**
     * 将字符串转换为时间类型数据
     * @param strDate
     * @return
     */
    public static Date strToDate(String strDate) throws ParseException {
        Date date = null;
        if (strDate != "" && !strDate.isEmpty()) {
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            date = format.parse(strDate);
        }
        return date;
    }

}
