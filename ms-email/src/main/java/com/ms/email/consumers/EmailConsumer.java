package com.ms.email.consumers;

import com.ms.email.dtos.EmailRecord;
import com.ms.email.models.EmailModel;
import com.ms.email.services.EmailService;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.BeanUtils;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class EmailConsumer {

    private final EmailService emailService;

    @RabbitListener(queues = "${broker.queue.email.name}")
    public void listenEmailQueue(@Payload EmailRecord emailRecord) {
        var emailModel = new EmailModel();
        BeanUtils.copyProperties(emailRecord, emailModel);
        emailService.sendEmail(emailModel);
    }

}
