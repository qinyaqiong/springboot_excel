package com.sjh.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.sjh.mapper.CompanyMapper;
import com.sjh.mapper.EmpMapper;
import com.sjh.pojo.Company;
import com.sjh.pojo.Employee;
import com.sjh.service.CompanyService;
import com.sjh.utils.Result;
import com.sjh.utils.ResultCode;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author sjh
 * @date 2020/5/7
 */
@Service("CompanyService")
@Transactional
public class CompanyServiceImpl implements CompanyService {

    @Resource
    private CompanyMapper companyMapper;
    @Resource
    private EmpMapper empMapper;

    //公司列表
    @Override
    public Result getCompanyList(Company company) {
        QueryWrapper<Company> entityWrapper = new QueryWrapper<>();
        if(!StringUtils.isEmpty(company.getComName())){
            entityWrapper.like("COMNAME",company.getComName());
        }
        List<Company> companies = companyMapper.selectList(entityWrapper);
        return new Result(ResultCode.SUCCESS,companies);
    }

    //添加或修改公司
    @Override
    public Result addOrUpdateCompany(Company company) {
        int i= 0;
        if(!StringUtils.isEmpty(company.getComID())){//公司ID不为空则为修改
            i = companyMapper.updateById(company);
        }else{//添加新公司
            i = companyMapper.insert(company);
        }
        return i > 0 ? new Result(ResultCode.SUCCESS):new Result(ResultCode.ERROR);
    }

    //删除公司
    @Override
    public Result deleteCompany(Company company) {
        //这家公司所有员工
        QueryWrapper<Employee> entityWrapper = new QueryWrapper<Employee>();
        entityWrapper.eq("COMID",company.getComID());
        List<Employee> emps = empMapper.selectList(entityWrapper);
        if(emps.size() != 0){
            //删除员工与项目的关系
            for (Employee emp : emps) {
                empMapper.deleteEmpByPro(emp.getempID());
            }
            //删除这家公司的所有员工
            for (Employee emp : emps) {
                Integer integer = empMapper.deleteById(emp.getempID());
            }
        }
        //删除这家公司
        Integer integer1 = companyMapper.deleteById(company.getComID());
        return new Result(ResultCode.SUCCESS);
    }

    @Override
    public Result getCompany() {
        List<Company> companies = companyMapper.selectList(null);
        return new Result(ResultCode.SUCCESS,companies);
    }
}
