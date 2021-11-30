package com.sjh.service;

import com.sjh.pojo.Project;
import com.sjh.utils.Result;

public interface ProjectService {
    Result getProjectList(Project project);

    Result addOrUpdateProject(Project project);

    Result updateProStatus(Project project);

    Result getProject();

    Result groupPro();
}
