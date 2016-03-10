package uk.ac.ebi.spot.messaging;

import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by tburdett on 09/03/2016.
 */
@Configuration
public class SampleTopicConfig {
    private final String topic = Topics.SAMPLES;

    @Bean
    TopicExchange exchange() {
        return new TopicExchange(topic);
    }

}
