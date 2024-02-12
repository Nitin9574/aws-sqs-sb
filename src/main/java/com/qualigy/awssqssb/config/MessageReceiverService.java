package com.qualigy.awssqssb.config;

import io.awspring.cloud.sqs.annotation.SqsListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.stereotype.Component;

@Component
public class MessageReceiverService {

    Logger logger = LoggerFactory.getLogger(MessageReceiverService.class);
    @SqsListener("ni-queue")
    public void readMessage(String message) {

        logger.info("Message from AWS SQS Queue consumed  :" + message);
    }
}
