package com.sjh.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;

@TableName("EMPLOYEE")
public
class Employee implements Serializable {

    @TableId(value = "empID",type = IdType.ID_WORKER_STR)
    private String empID;

    @TableField("empAPPLICATION")
    private String empApplication;

    @TableField("empCONTRACT")
    private String empContract;

    @TableField("empCT")
    private  String empCt;

    @TableField("empTOPIC")
    private  String empTopic;

    @TableField("empNAME")
    private  String empName;

    @TableField("empRD")
    private  String empRd;

    @TableField("empALLOCATION")
    private  String empAllocation;

    @TableField("empQUANTITY")
    private  String empQuantity;

    @TableField("empUP")
    private  String empUp;

    @TableField("empMONEY")
    private  String empMoney;

    @TableField("empAGENT")
    private  String empAgent;

    @TableField("empTSN")
    private  String empTsn;

    @TableField("empRP")
    private  String empRp;

    @TableField("empDOP")
    private  String empDop;

    @TableField("empTAFTD")
    private  String empTaftd;

    @TableField("empINTENSIVE")
    private  String empIntensive;

    @TableField("empREMARK")
    private  String empRemark;

    @TableField("empPM")
    private  String empPm;

    @TableField("empQS")
    private  String empQs;

    @TableField("empCSD")
    private  String empCsd;

    @TableField("empCAT")
    private  String empCat;

    @TableField("empWTAOTG")
    private  String empWtaotg;

    @TableField("empAAT")
    private  String empAat;

    @TableField("empPN")
    private  String empPn;

    @TableField("empTAOTE")
    private  String empTaote;

    @TableField("empTST")
    private  String empTst;

    @TableField("empTCC")
    private  String empTcc;

    @TableField("empTCS")
    private  String empCs;


    public Employee() {
    }

    public Employee(String empID, String empApplication, String empContract,String empCt,
                   String empTopic,String empName,String empRd,String empAllocation,
                   String empQuantity,String empUp,String empMoney,String empAgent,
                   String empTsn,String empRp,String empDop,String empTaftd,
                   String empIntensive,String empRemark,String empPm,String empQs,
                   String empCsd,String empCat,String empWtaotg,String empAat,
                   String empPn,String empTaote,String empTst,String empTcc,String empCs) {
        this.empID = empID;
        this.empApplication = empApplication;
        this.empContract =  empContract;
        this.empCt = empCt;
        this.empTopic = empTopic;
        this.empName = empName;
        this.empRd = empRd;
        this.empAllocation = empAllocation;
        this.empQuantity = empQuantity;
        this.empUp = empUp;
        this.empMoney = empMoney;
        this.empAgent = empAgent;
        this.empTsn = empTsn;
        this.empRp = empRp;
        this.empDop = empDop;
        this.empTaftd = empTaftd;
        this.empIntensive = empIntensive;
        this.empRemark = empRemark;
        this.empPm = empPm;
        this.empQs = empQs;
        this.empCsd = empCsd;
        this.empCat = empCat;
        this.empWtaotg = empWtaotg;
        this.empAat = empAat;
        this.empPn = empPn;
        this.empTaote = empTaote;
        this.empTst = empTst;
        this.empTcc = empTcc;
        this.empCs = empCs;

    }

    public String getempID() {
        return empID;
    }

    public void setempID(String empID) {
        this.empID = empID;
    }

    public String getempApplication() {
        return empApplication;
    }

    public void setempApplication(String empApplication) {
        this.empApplication = empApplication;
    }

    public String getempContract() {
        return empContract;
    }

    public void setempContract(String empContract) {
        this.empContract = empContract;
    }

    public String getempCt() {
        return empCt;
    }

    public void setempCt(String empCt) {
        this.empCt = empCt;
    }

    public String getempTopic() {
        return empTopic;
    }

    public void setempTopic(String empTopic) {
        this.empTopic = empTopic;
    }

    public String getempName() {
        return empName;
    }

    public void setempName(String empName) {
        this.empID = empID;
    }

    public String getempRd() {
        return empRd;
    }

    public void setempRd(String empRd) {
        this.empRd = empRd;
    }

    public String getempAllocation() {
        return empAllocation;
    }

    public void setempAllocation(String empAllocation) {
        this.empAllocation = empAllocation;
    }

    public String getempQuantity() {
        return empQuantity;
    }

    public void setempQuantity(String empQuantity) {
        this.empQuantity = empQuantity;
    }

    public String getempUp() {
        return empUp;
    }

    public void setempUp(String empUp) {
        this. empUp =  empUp;
    }

    public String getempMoney() {
        return empMoney;
    }

    public void setempMoney(String empMoney) {
        this.empMoney = empMoney;
    }

    public String getempAgent() {
        return empAgent;
    }

    public void setempAgent(String empAgent) {
        this.empAgent = empAgent;
    }

    public String getempTsn() {
        return empTsn;
    }

    public void setempTsn(String empTsn) {
        this.empTsn = empTsn;
    }

    public String getempRp() {
        return empRp;
    }

    public void setempRp(String empRp) {
        this.empRp = empRp;
    }

    public String getempDop() {
        return empDop;
    }

    public void setempDop(String empDop) {
        this.empDop = empDop;
    }


    public String getempTaftd() {
        return empTaftd;
    }

    public void setempTaftd(String empTaftd) {
        this.empTaftd = empTaftd;
    }


    public String getempIntensive() {
        return empIntensive;
    }

    public void setempIntensive(String empIntensive) {
        this.empIntensive = empIntensive;
    }

    public String getempRemark() {
        return empRemark;
    }

    public void setempRemark(String empRemark) {
        this.empRemark = empRemark;
    }

    public String getempPm() {
        return empPm;
    }

    public void setempPm(String empPm) {
        this.empPm = empPm;
    }

    public String getempQs() {
        return empQs;
    }

    public void setempQs(String empQs) {
        this.empQs = empQs;
    }

    public String getempCsd() {
        return empCsd;
    }

    public void setempCsd(String empCsd) {
        this.empCsd = empCsd;
    }

    public String getempCat() {
        return empCat;
    }

    public void setempCat(String empCat) {
        this.empCat = empCat;
    }

    public String getempWtaotg() {
        return empWtaotg;
    }

    public void setempWtaotg(String empWtaotg) {
        this.empWtaotg = empWtaotg;
    }

    public String getempAat() {
        return empAat;
    }

    public void setempAat(String empAat) {
        this.empAat = empAat;
    }

    public String getempPn() {
        return empPn;
    }

    public void setempPn(String empPn) {
        this.empPn = empPn;
    }

    public String getempTaote() {
        return empTaote;
    }

    public void setempTaote(String empTaote) {
        this.empTaote = empTaote;
    }

    public String getempTst() {
        return empTst;
    }

    public void setempTst(String empTst) {
        this.empTst = empTst;
    }

    public String getempTcc() {
        return empTcc;
    }

    public void setempTcc(String empTcc) {
        this.empTcc = empTcc;
    }

    public String getempCs() {
        return empCs;
    }

    public void setempCs(String empCs) {
        this.empCs = empCs;
    }


}

