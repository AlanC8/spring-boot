package kz.kbtu.sis1;

import kz.kbtu.sis1.model.Quote;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.web.client.RestTemplate;


@SpringBootApplication
public class Sis1Application {
    private static final Logger log = LoggerFactory.getLogger(Sis1Application.class);

    public static void main(String[] args) {
        SpringApplication.run(Sis1Application.class, args);
    }

    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder.build();
    }

    @Bean
    @Profile("!test")
    public CommandLineRunner run(RestTemplate restTemplate) throws Exception {
        return args -> {
            Quote quote = restTemplate.getForObject(
                    "http://localhost:8080/api/random", Quote.class);
            log.info(quote.toString());
        };
    }
}
