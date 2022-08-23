package edu.training;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * A demo rest controller include post request that accept a string message
 * then it will send the message using kafka
 * URL: http://localhost:8080/api/trainees
 */


@RestController
@RequestMapping("/api/trainees")
public class MessageController {
    private KafkaTemplate<String,String> kafkaTemplate;

    public MessageController(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @PostMapping
    public void publishTrainee(@RequestBody String messageRequest){
        kafkaTemplate.send("TraineesTopic",messageRequest);
    }
}
