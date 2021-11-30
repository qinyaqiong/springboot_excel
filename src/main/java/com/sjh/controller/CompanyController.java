package com.sjh.controller;

import com.sjh.pojo.Company;
import com.sjh.service.CompanyService;
import com.sjh.utils.Result;

import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author sjh
 * @date 2020/5/8
 */
@RestController
@CrossOrigin
public class CompanyController {

    @Resource
    private CompanyService companyService;

    //公司列表
    @PostMapping("getCompanyList")
    private Result getCompanyList(@RequestBody Company company){
        return  companyService.getCompanyList(company);
    }

    @PostMapping("getCompany")
    private Result getCompany(){
        return companyService.getCompany();
    }

    //添加或修改公司
    @PostMapping("addOrUpdateCompany")
    private Result addOrUpdateCompany(@RequestBody Company company){
        return companyService.addOrUpdateCompany(company);
    }


    //删除公司
    @DeleteMapping("deleteCompany")
    private Result deleteCompany(@RequestBody Company company){
        return companyService.deleteCompany(company);
    }
}
