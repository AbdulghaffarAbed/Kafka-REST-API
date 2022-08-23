package edu.training;


import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.core.KafkaTemplate;

/**
 * This application will use kafka messaging system to send message using it
 * The application contains a very simple restApi with only post request the aim of this is to
 * display the received body from the rest API into kafka console ( use kafka as a communication channel)
 * this process required three cmd to execute one of the following command respictively (only one for each):
 * first command to start zookeeper that's used to manage and coordinate kafka broker:
 * .\bin\windows\zookeeper-server-start.bat .\config\zookeeper.properties
 * second command used to start kafka:
 * .\bin\windows\kafka-server-start.bat .\config\server.properties
 * third command to display kafka console and messages using our predefine topic ("TraineesTopic")
 * .\bin\windows\kafka-console-consumer.bat --topic TraineesTopic --from-beginning --bootstrap-server DESKTOP-DGBJSI9.exalt.ps:9092
 */
@SpringBootApplication
public class KafkaProjectApplication {

    public static void main(String[] args) {
        SpringApplication.run(KafkaProjectApplication.class, args);
    }

    /**
     * The aim of this method is to send a message when the spring application run
     * @param kafkaTemplate kafka built in template used to send data with a given topic
     * @return the message to display it on the console
     */


    @Bean
    CommandLineRunner commandLineRunner(KafkaTemplate<String,String> kafkaTemplate){
        return args -> {
            kafkaTemplate.send("TraineesTopic","hello Trainees with kafka");
        };
    }
}