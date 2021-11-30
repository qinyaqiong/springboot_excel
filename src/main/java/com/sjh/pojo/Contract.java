package com.sjh.pojo;

import cn.afterturn.easypoi.excel.annotation.Excel;

import java.io.Serializable;

public class Contract implements Serializable {

    //@Excel(name = "序号",  isImportField = "true_st")
    private Integer con_id;

    @Excel(name = "申请单",isImportField = "true_st")
    private String con_application;

    @Excel(name = "合同号",  isImportField = "true_st")
    private String con_contract;

    @Excel(name = "类型",isImportField = "true_st")
    private String con_ct;

    @Excel(name = "课题号",  isImportField = "true_st")
    private String con_topic;

    @Excel(name = "合同名称",  isImportField = "true_st")
    private String con_name;

    @Excel(name = "合同登记日期",  isImportField = "true_st")
    private String con_rd;

    @Excel(name = "配置",  isImportField = "true_st")
    private String con_allocation;

    @Excel(name = "数量",  isImportField = "true_st")
    private String con_quantity;

    @Excel(name = "单价",  isImportField = "true_st")
    private String con_up;

    @Excel(name = "合同总额",  isImportField = "true_st")
    private String con_money;

    @Excel(name = "经办人",  isImportField = "true_st")
    private String con_agent;

    @Excel(name = "供方单位",  isImportField = "true_st")
    private String con_tsn;

    @Excel(name = "使用负责人",  isImportField = "true_st")
    private String con_rp;

    @Excel(name = "付款日期",  isImportField = "true_st")
    private String con_dop;

    @Excel(name = "投帐日期",  isImportField = "true_st")
    private String con_taftd;

    @Excel(name = "密级",  isImportField = "true_st")
    private String con_intensive;

    @Excel(name = "备注",  isImportField = "true_st")
    private String con_remark;

    @Excel(name = "采购方式",  isImportField = "true_st")
    private String con_pm;

    @Excel(name = "是否合格供方",  isImportField = "true_st")
    private String con_qs;

    @Excel(name = "合同盖章日期",  isImportField = "true_st")
    private String con_csd;

    @Excel(name = "合同到货时间",  isImportField = "true_st")
    private String con_Cat;

    @Excel(name = "是否到货",  isImportField = "true_st")
    private String con_wtaotg;

    @Excel(name = "实际到货时间",  isImportField = "true_st")
    private String con_aat;

    @Excel(name = "付款节点",  isImportField = "true_st")
    private String con_pn;

    @Excel(name = "到货时期",  isImportField = "true_st")
    private String con_taote;

    @Excel(name = "供方类型",  isImportField = "true_st")
    private String con_tst;

    @Excel(name = "合同类别",  isImportField = "true_st")
    private String con_tcc;

    @Excel(name = "付款状态",  isImportField = "true_st")
    private String con_cs;

    @Excel(name = "合同状态",  isImportField = "true_st")
    private String con_state;



    @Override
    public String toString() {
        return "Contract{" +
                "con_id='" + con_id + '\'' +
                ", con_application='" + con_application + '\'' +
                ", con_contract='" + con_contract + '\'' +
                ", con_ct='" + con_ct + '\'' +
                ", con_topic='" + con_topic + '\'' +
                ", con_name='" + con_name + '\'' +
                ", con_rd='" + con_rd + '\'' +
                ", con_allocation='" + con_allocation + '\'' +
                ", con_quantity='" + con_quantity + '\'' +
                ", con_up='" + con_up + '\'' +
                ", con_money='" + con_money + '\'' +
                ", con_agent='" + con_agent + '\'' +
                ", con_tsn='" + con_tsn + '\'' +
                ", con_rp='" + con_rp + '\'' +
                ", con_dop='" + con_dop + '\'' +
                ", con_taftd='" + con_taftd + '\'' +
                ", con_intensive='" + con_intensive + '\'' +
                ", con_remark='" + con_remark + '\'' +
                ", con_pm='" + con_pm + '\'' +
                ", con_qs='" + con_qs + '\'' +
                ", con_csd='" + con_csd + '\'' +
                ", con_Cat='" + con_Cat + '\'' +
                ", con_wtaotg='" + con_wtaotg + '\'' +
                ", con_aat='" + con_aat + '\'' +
                ", con_pn='" + con_pn + '\'' +
                ", con_taote='" + con_taote + '\'' +
                ", con_tst='" + con_tst + '\'' +
                ", con_tcc='" + con_tcc + '\'' +
                ", con_cs='" + con_cs + '\'' +
                '}';
    }

    public Integer getCon_id() {
        return con_id;
    }

    public void setCon_id(Integer con_id) {
        this.con_id = con_id;

    }

    public String getCon_application() {
        return con_application;
    }

    public void setCon_application(String con_application) {
        this.con_application = con_application;
    }


    public String getCon_contract() {
        return con_contract;
    }

    public void setCon_contract(String con_contract) {
        this.con_contract = con_contract;
    }

    public String getCon_ct() {
        return con_ct;
    }

    public void setCon_ct(String con_ct) {
        this.con_ct = con_ct;
    }

    public String getCon_topic() {
        return con_topic;
    }

    public void setCon_topic(String con_topic) {
        this.con_topic = con_topic;
    }

    public String getCon_name() {
        return con_name;
    }

    public void setCon_name(String con_name) {
        this.con_name = con_name;
    }

    public String getCon_rd() {
        return con_rd;
    }

    public void setCon_rd(String con_rd) {
        this.con_rd = con_rd;
    }

    public String getCon_allocation() {
        return con_allocation;
    }

    public void setCon_allocation(String con_allocation) {
        this.con_allocation = con_allocation;
    }

    public String getCon_quantity() {
        return con_quantity;
    }

    public void setCon_quantity(String con_quantity) {
        this.con_quantity = con_quantity;
    }

    public String getCon_up() {
        return con_up;
    }

    public void setCon_up(String con_up) {
        this.con_up = con_up;
    }

    public String getCon_money() {
        return con_money;
    }

    public void setCon_money(String con_money) {
        this.con_money = con_money;
    }

    public String getCon_agent() {
        return con_agent;
    }

    public void setCon_agent(String con_agent) {
        this.con_agent = con_agent;
    }

    public String getCon_tsn() {
        return con_tsn;
    }

    public void setCon_tsn(String con_tsn) {
        this.con_tsn = con_tsn;
    }

    public String getCon_rp() {
        return con_rp;
    }

    public void setCon_rp(String con_rp) {
        this.con_rp = con_rp;
    }

    public String getCon_dop() {
        return con_dop;
    }

    public void setCon_dop(String con_dop) {
        this.con_dop = con_dop;
    }

    public String getCon_taftd() {
        return con_taftd;
    }

    public void setCon_taftd(String con_taftd) {
        this.con_taftd = con_taftd;
    }

    public String getCon_intensive() {
        return con_intensive;
    }

    public void setCon_intensive(String con_intensive) {
        this.con_intensive = con_intensive;
    }

    public String getCon_remark() {
        return con_remark;
    }

    public void setCon_remark(String con_remark) {
        this.con_remark = con_remark;
    }

    public String getCon_pm() {
        return con_pm;
    }

    public void setCon_pm(String con_pm) {
        this.con_pm = con_pm;
    }

    public String getCon_qs() {
        return con_qs;
    }

    public void setCon_qs(String con_qs) {
        this.con_qs = con_qs;
    }

    public String getCon_csd() {
        return con_csd;
    }

    public void setCon_csd(String con_csd) {
        this.con_csd = con_csd;
    }

    public String getCon_cat() {
        return con_Cat;
    }

    public void setCon_cat(String con_Cat) {
        this.con_Cat = con_Cat;
    }

    public String getCon_wtaotg() {
        return con_wtaotg;
    }

    public void setCon_wtaotg(String con_wtaotg) {
        this.con_wtaotg = con_wtaotg;
    }

    public String getCon_aat() {
        return con_aat;
    }

    public void setCon_aat(String con_aat) {
        this.con_aat = con_aat;
    }

    public String getCon_pn() {
        return con_pn;
    }

    public void setCon_pn(String con_pn) {
        this.con_pn = con_pn;
    }

    public String getCon_taote() {
        return con_taote;
    }

    public void setCon_taote(String con_taote) {
        this.con_taote = con_taote;
    }

    public String getCon_tst() {
        return con_tst;
    }

    public void setCon_tst(String con_tst) {
        this.con_tst = con_tst;
    }

    public String getCon_tcc() {
        return con_tcc;
    }

    public void setCon_tcc(String con_tcc) {
        this.con_tcc = con_tcc;
    }

    public String getCon_cs() {
        return con_cs;
    }

    public void setCon_cs(String con_cs) {
        this.con_cs = con_cs;
    }

    public String getCon_Cat() {
        return con_Cat;
    }

    public void setCon_Cat(String con_Cat) {
        this.con_Cat = con_Cat;
    }

    public String getCon_state() {
        return con_state;
    }

    public void setCon_state(String con_state) {
        this.con_state = con_state;
    }
}

