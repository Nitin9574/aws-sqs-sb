package com.qualigy.awssqssb.controller;

import io.awspring.cloud.sqs.operations.SqsTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping("/sqs")
public class SQSController {

    Logger logger = LoggerFactory.getLogger(SQSController.class);
    @Autowired
    private SqsTemplate sqsTemplate;

    @Value("${cloud.aws.end-point.uri}")
    private String endPoint;

    @GetMapping("/send/{message}")
    public void sendMessageToAwsSQS(@PathVariable String message) {
        sqsTemplate.send(endPoint, MessageBuilder.withPayload(message).build());
    }
}
