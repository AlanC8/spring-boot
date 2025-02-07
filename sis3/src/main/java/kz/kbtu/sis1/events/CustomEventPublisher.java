package kz.kbtu.sis1.events;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

@Component
public class CustomEventPublisher {
    private final ApplicationEventPublisher eventPublisher;

    public CustomEventPublisher(ApplicationEventPublisher eventPublisher) {
        this.eventPublisher = eventPublisher;
    }

    public void publish(String message) {
        eventPublisher.publishEvent(new CustomEvent(message));
        System.out.println("Published event: " + message);
    }
}
