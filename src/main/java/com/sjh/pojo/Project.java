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

@TableName("PROJECT")
//项目
public class Project implements Serializable {

    @TableId(value = "PROID", type = IdType.ID_WORKER_STR)
    private String proID;

    @TableField("PRONAME")
    private String proName;

    @TableField("STATUS")
    private String status;

    public Project() {
    }

    public Project(String proID, String proName, String status) {
        this.proID = proID;
        this.proName = proName;
        this.status = status;
    }

    public String getProID() {
        return proID;
    }

    public void setProID(String proID) {
        this.proID = proID;
    }

    public String getProName() {
        return proName;
    }

    public void setProName(String proName) {
        this.proName = proName;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
