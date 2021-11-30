package com.sjh.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * @author sjh
 * @date 2020/5/7
 */
@TableName("DATA")
//数据
public class Data implements Serializable {

    @TableId(value = "DATAID", type = IdType.ID_WORKER_STR)
    private String dataID;

    @TableField("EMPID")
    private String empID;

    //数据库字段排除在外
    @TableField(exist = false)
    private String empName;

    @TableField(exist = false)
    private String proName;

    public String getProName() {
        return proName;
    }

    public void setProName(String proName) {
        this.proName = proName;
    }

    public String getProID() {
        return proID;
    }

    public void setProID(String proID) {
        this.proID = proID;
    }

    //项目名称 数据库排除在外
//    @TableField(exist = false)
    private String proID;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd")
    @TableField("LOGDATE")
    private Date logDate;//日期

    @TableField("CODELINE")
    private Integer codeLine;

    public Data() {
    }

    public Data(String dataID, String empID, String empName, String proName, String proID, Date logDate, Integer codeLine) {
        this.dataID = dataID;
        this.empID = empID;
        this.empName = empName;
        this.proName = proName;
        this.proID = proID;
        this.logDate = logDate;
        this.codeLine = codeLine;
    }

    public String getDataID() {
        return dataID;
    }

    public void setDataID(String dataID) {
        this.dataID = dataID;
    }

    public String getEmpID() {
        return empID;
    }

    public void setEmpID(String empID) {
        this.empID = empID;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public Date getLogDate() {
        return logDate;
    }

    public void setLogDate(Date logDate) {
        this.logDate = logDate;
    }

    public Integer getCodeLine() {
        return codeLine;
    }

    public void setCodeLine(Integer codeLine) {
        this.codeLine = codeLine;
    }
}
