package edu.training;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

/**
 * Define a Listener which will display the data that send by the producer
 * using kafka
 */


@Component
public class KafkaListeners {

    /**
     * listener will display data comes from the producer
     *
     * @param data reference to the data sent by producer
     */


    @KafkaListener(topics = "TraineesTopic", groupId = "groupId")
    void listener(String data) {
        System.out.println("Listener received: " + data);
    }
}
