package com.lambdaschool.javacities;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class CityMessageListener
{
    @RabbitListener(queues = JavacitiesApplication.QUEUE_NAME_SECRET)
    public void receiveMessage(CityMessage cm)
    {
        log.info("Received Message: {} ", cm.toString());
    }
}
