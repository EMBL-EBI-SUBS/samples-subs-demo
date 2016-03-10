package uk.ac.ebi.spot.repository;

import org.springframework.amqp.rabbit.core.RabbitMessagingTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.core.annotation.HandleAfterCreate;
import org.springframework.data.rest.core.annotation.HandleBeforeSave;
import org.springframework.data.rest.core.annotation.RepositoryEventHandler;
import org.springframework.messaging.converter.MessageConverter;
import org.springframework.stereotype.Service;
import uk.ac.ebi.spot.messaging.Channels;
import uk.ac.ebi.spot.model.Sample;

/**
 * Created by tburdett on 09/03/2016.
 */
@Service
@RepositoryEventHandler(Sample.class)
public class SampleRepositoryEventHandler {
    private RabbitMessagingTemplate rabbitTemplate;

    @Autowired
    public SampleRepositoryEventHandler(RabbitMessagingTemplate rabbitTemplate, MessageConverter messageConverter) {
        this.rabbitTemplate = rabbitTemplate;
        this.rabbitTemplate.setMessageConverter(messageConverter);
    }

    @HandleBeforeSave
    public void handleSampleSave(Sample sample) {
        System.out.println("Dispatching sample save message...");
//        rabbitTemplate.convertAndSend(Channels.SAMPLE_SAVE, "Saved a sample (" + sample.getAccession() + ")");
        rabbitTemplate.convertAndSend(Channels.SAMPLE_SAVE, sample);
    }

    @HandleAfterCreate
    public void handleSampleCreate(Sample sample) {
        System.out.println("Dispatching sample creation message...");
//        rabbitTemplate.convertAndSend(Channels.SAMPLE_CREATION, "Created a sample (" + sample.getAccession() + ")");
        rabbitTemplate.convertAndSend(Channels.SAMPLE_CREATION, sample);
    }
}
