package com.sjh.controller;

import com.sjh.pojo.Project;
import com.sjh.service.ProjectService;
import com.sjh.utils.Result;

import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;


@RestController
@CrossOrigin
public class ProjectController {

   @Resource
   private ProjectService projectService;
//
//    //项目列表
//    @PostMapping("getProjectList")
//    private Result getProjectList(@RequestBody Project project){
//        return projectService.getProjectList(project);
//    }
//
//    //全部项目
    @PostMapping("getProject")
    private Result getProject(){
        return projectService.getProject();
    }

    //添加和修改项目
    @PostMapping("addOrUpdateProject")
    private Result addOrUpdateProject(@RequestBody Project project){
        return projectService.addOrUpdateProject(project);
    }

    //删除项目(修改项目的状态)
    @PutMapping("updateProStatus")
    private Result updateProStatus(@RequestBody Project project){
        return projectService.updateProStatus(project);
    }

    //在建项目
    @PostMapping("groupPro")
    private Result groupPro(){
        return projectService.groupPro();
    }
}
