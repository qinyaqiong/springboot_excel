package com.sjh.controller;


import com.sjh.service.CompanyService;
import com.sjh.service.MessageService;
import com.sjh.utils.Result;
import org.apache.logging.log4j.message.Message;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@CrossOrigin
public class MessageController {
    @Resource
    private MessageService messageService;

    //添加或修改内容
    @PostMapping("addOrUpdateMessage")
    private Result addOrUpdateMessage(@RequestBody Message message){
        return messageService.addOrUpdateMessage(message);
    }
}
