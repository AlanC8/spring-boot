package kz.kbtu.sis4;

import kz.kbtu.sis4.db.migration.FlywayDatabaseSeeder;
import org.flywaydb.core.Flyway;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.flyway.FlywayMigrationStrategy;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class Sis4Application {

    public static void main(String[] args) {
        SpringApplication.run(Sis4Application.class, args);
    }

    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder.interceptors(new LoggingInterceptor()).build();
    }

    @Bean
    public FlywayMigrationStrategy flywayMigrationStrategy() {
        return (flywayOld) -> {

		/*
		 Update the existing autoconfigured Flyway
		 bean to include our callback class
		*/
            Flyway flyway = Flyway.configure()
                    .configuration(flywayOld.getConfiguration())
                    .callbacks(new FlywayDatabaseSeeder())
                    .load();

            flyway.migrate();

        };
    }
}
