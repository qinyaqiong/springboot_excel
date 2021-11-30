package com.sjh.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;

/**
 * @author sjh
 * @date 2020/5/7
 */

@TableName("COMPANY")
//公司
public class Company implements Serializable {

    @TableId(value = "COMID", type = IdType.ID_WORKER_STR)
    private String comID;

    @TableField("COMNAME")
    private String comName;

    @TableField("COMINFO")
    private String comInfo;


    public Company() {
    }

    public Company(String comID, String comName, String comInfo) {
        this.comID = comID;
        this.comName = comName;
        this.comInfo = comInfo;
    }

    public String getComID() {
        return comID;
    }

    public void setComID(String comID) {
        this.comID = comID;
    }

    public String getComName() {
        return comName;
    }

    public void setComName(String comName) {
        this.comName = comName;
    }

    public String getComInfo() {
        return comInfo;
    }

    public void setComInfo(String comInfo) {
        this.comInfo = comInfo;
    }
}
