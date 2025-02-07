package kz.kbtu.sis1.dependency;

import kz.kbtu.sis1.model.Item;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    @Bean
    public Item item1() {
        return new Item(1, "tort");
    }

    @Bean
    public Store store() {
        return new Store();
    }

    @Bean
    public Store storeSetter() {
        Item item = new Item(1, "tort");
        return new Store();
    }
}
