package com.sjh.service.impl;


import com.sjh.mapper.EmpMapper;
import com.sjh.mapper.MessageMapper;
import com.sjh.pojo.Company;
import com.sjh.pojo.Project;
import com.sjh.service.MessageService;
import com.sjh.utils.Result;
import com.sjh.utils.ResultCode;
import org.apache.logging.log4j.message.Message;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.annotation.Resource;


@Service("MessageService")
@Transactional
public class MessageServicelmpl implements MessageService {

    @Resource
    private MessageMapper messageMapper;
    @Resource
    private EmpMapper empMapper;

    //添加或修改内容
    @Override
    public Result addOrUpdateMessage(Message message) {
        int i = 0;
        if (!StringUtils.isEmpty(messageMapper)){
           i =messageMapper.updateById((Company) message);
        }else {
            i = messageMapper.insert((Company) message);
        }
        return i > 0 ? new Result(ResultCode.SUCCESS):new Result(ResultCode.ERROR);

    }


}
