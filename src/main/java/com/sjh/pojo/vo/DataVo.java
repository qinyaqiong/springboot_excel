package com.sjh.pojo.vo;

import java.io.Serializable;

/**
 * 导出数据报表的包装类
 * @author sjh
 * @date 2020/5/9
 */

public class DataVo implements Serializable {

    private String comNameVo; //公司名称

    private String proNameVo; //项目名称

    private String empNameVo; //员工名称

    private String postVo; //员工职务

    private String codeLineVo; //代码行

    private String logDateVo; //日期

    public String getLogDateVo() {
        return logDateVo;
    }

    public void setLogDateVo(String logDateVo) {
        this.logDateVo = logDateVo;
    }

    public DataVo() {
    }

    public DataVo(String comNameVo, String proNameVo, String empNameVo, String postVo, String codeLineVo) {
        this.comNameVo = comNameVo;
        this.proNameVo = proNameVo;
        this.empNameVo = empNameVo;
        this.postVo = postVo;
        this.codeLineVo = codeLineVo;
    }

    public String getComNameVo() {
        return comNameVo;
    }

    public void setComNameVo(String comNameVo) {
        this.comNameVo = comNameVo;
    }

    public String getProNameVo() {
        return proNameVo;
    }

    public void setProNameVo(String proNameVo) {
        this.proNameVo = proNameVo;
    }

    public String getEmpNameVo() {
        return empNameVo;
    }

    public void setEmpNameVo(String empNameVo) {
        this.empNameVo = empNameVo;
    }

    public String getPostVo() {
        return postVo;
    }

    public void setPostVo(String postVo) {
        this.postVo = postVo;
    }

    public String getCodeLineVo() {
        return codeLineVo;
    }

    public void setCodeLineVo(String codeLineVo) {
        this.codeLineVo = codeLineVo;
    }
}


