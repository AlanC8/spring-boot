package kz.kbtu.sis5.controller;

import kz.kbtu.sis5.service.GreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {
    @Autowired
    private GreetingService greetingService;

    @GetMapping("/send")
    public String sendMessage(@RequestParam String message) {
        greetingService.sendGreeting(message);
        return "Message sent to Kafka: " + message;
    }
}
