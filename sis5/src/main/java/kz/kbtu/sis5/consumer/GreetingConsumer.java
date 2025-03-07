package kz.kbtu.sis5.consumer;

import kz.kbtu.sis5.model.Greeting;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class GreetingConsumer {
    @KafkaListener(
            topics = "${spring.kafka.topic-name}",
            containerFactory = "greetingKafkaListenerContainerFactory"
    )
    public void greetingListener(Greeting greeting) {
        System.out.println("Получен Greeting с текстом: " + greeting.getMsg());
    }
}
