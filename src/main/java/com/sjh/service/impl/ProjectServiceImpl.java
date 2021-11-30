package com.sjh.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.sjh.mapper.ProjectMapper;
import com.sjh.pojo.Project;
import com.sjh.service.ProjectService;
import com.sjh.utils.Result;
import com.sjh.utils.ResultCode;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * @author sjh
 * @date 2020/5/7
 */
@Service("ProjectService")
@Transactional
public class ProjectServiceImpl implements ProjectService {

    @Resource
    private ProjectMapper projectMapper;

    //项目列表
    @Override
    public Result getProjectList(Project project) {
        QueryWrapper<Project> entityWrapper = new QueryWrapper<>();
        if(!StringUtils.isEmpty(project.getProName())){
            entityWrapper.like("PRONAME",project.getProName());//项目名称
        }
        entityWrapper.eq("STATUS",0);//正建设项目
        List<Project> projects = projectMapper.selectList(entityWrapper);
        return new Result(ResultCode.SUCCESS,projects);
    }

    //项目的添加和修改
    @Override
    public Result addOrUpdateProject(Project project) {
        int i = 0;
        if(!StringUtils.isEmpty(project.getProID())){//有项目ID则为修改
            i = projectMapper.updateById(project);
        }else{//无项目ID则为添加
            i = projectMapper.insert(project);
        }
        return i > 0 ? new Result(ResultCode.SUCCESS) : new Result(ResultCode.ERROR);
    }

    //删除项目（修改项目的状态改为1《非正建设》）
    @Override
    public Result updateProStatus(Project project) {
        project.setStatus("1");//状态改为1
        Integer integer = projectMapper.updateById(project);
        return integer > 0 ? new Result(ResultCode.SUCCESS) : new Result(ResultCode.ERROR);
    }

    //获取全部项目
    @Override
    public Result getProject() {
        QueryWrapper<Project> projectEntityWrapper = new QueryWrapper<>();
        projectEntityWrapper.eq("STATUS",0);
        List<Project> projects = projectMapper.selectList(projectEntityWrapper);
        return new Result(ResultCode.SUCCESS,projects);
    }

    //在建项目
    @Override
    public Result groupPro() {
        List<Map<String, String>> maps = projectMapper.groupPro();
        return  new Result(ResultCode.SUCCESS,maps);
    }
}
