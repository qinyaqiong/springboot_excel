package com.sjh.service;

import com.sjh.pojo.Employee;
import com.sjh.pojo.Employee;
import com.sjh.utils.Result;

import java.util.Map;

/**
 * @author sjh
 * @date 2020/5/7
 */
public interface EmpService {
  Result  addOrUpdateEmployee(Employee employee);

  Result addOrUpdateEmp(com.sjh.pojo.Employee employee);
}
