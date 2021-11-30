package com.sjh.service;

import com.sjh.pojo.Company;
import com.sjh.utils.Result;

public interface CompanyService {
    Result getCompanyList(Company company);

    Result addOrUpdateCompany(Company company);

    Result deleteCompany(Company company);

    Result getCompany();
}
