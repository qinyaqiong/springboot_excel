package com.sjh.service;

import com.sjh.utils.Result;
import org.apache.logging.log4j.message.Message;

public interface MessageService {

    Result addOrUpdateMessage(Message message);
}
