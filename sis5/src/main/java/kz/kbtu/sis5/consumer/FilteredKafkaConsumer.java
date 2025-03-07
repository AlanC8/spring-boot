package kz.kbtu.sis5.consumer;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class FilteredKafkaConsumer {

    @KafkaListener(
            topics = "${spring.kafka.topic-name}",
            containerFactory = "filterKafkaListenerContainerFactory"
    )
    public void listenFiltered(String message) {
        System.out.println("Filtered Listener received: " + message);
    }
}
