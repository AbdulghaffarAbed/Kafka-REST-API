package edu.training.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

/**
 * kafkaTopicConfig is responsible for creating topics
 */


@Configuration
public class kafkaTopicConfig {

    /**
     * Define a topic to store data transferred through kafka inside it
     * where the topic contains one or more portions
     * @return a topic to store data
     */


    @Bean
    public NewTopic Topic(){
        return TopicBuilder.name("TraineesTopic")
                .build();
    }
}