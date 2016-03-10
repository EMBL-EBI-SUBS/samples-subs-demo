package uk.ac.ebi.spot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.messaging.converter.MappingJackson2MessageConverter;
import org.springframework.messaging.converter.MessageConverter;

@SpringBootApplication
public class SampleSubsDemoApplication {
    @Bean
    public MessageConverter messageConverter() {
        return new MappingJackson2MessageConverter();
    }

    public static void main(String[] args) throws InterruptedException {
        SpringApplication.run(SampleSubsDemoApplication.class, args);
    }
}
