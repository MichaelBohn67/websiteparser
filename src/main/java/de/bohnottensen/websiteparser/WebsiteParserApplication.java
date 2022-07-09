package de.bohnottensen.websiteparser;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@RequiredArgsConstructor
public class WebsiteParserApplication {

    public static void main(String[] args) {
        SpringApplication.run(WebsiteParserApplication.class, args);
    }

}
