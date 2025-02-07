package kz.kbtu.sis1.events;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class EventDemoRunner implements CommandLineRunner {
    private final CustomEventPublisher publisher;

    public EventDemoRunner(CustomEventPublisher publisher) {
        this.publisher = publisher;
    }

    @Override
    public void run(String... args) {
        publisher.publish("Hello, Spring Events!");
    }
}
