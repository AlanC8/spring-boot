package kz.kbtu.sis5.service;

import kz.kbtu.sis5.model.Greeting;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class GreetingService {
    @Autowired
    private KafkaTemplate<String, Greeting> kafkaTemplate;

    @Value("${spring.kafka.topic-name}")
    private String topicName;

    public void sendGreeting(String msg) {
        Greeting greeting = new Greeting(msg);
        kafkaTemplate.send(topicName, greeting);
    }
}
