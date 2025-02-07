package kz.kbtu.sis1.events;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class CustomEventListener {
    @EventListener
    public void handleEvent(CustomEvent event) {
        System.out.println("Received event: " + event.getMessage());
    }
}
