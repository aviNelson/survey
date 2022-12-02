package com.example.survey;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
@ConfigurationPropertiesScan
public class SurveyApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(SurveyApplication.class, args);

    }
}
