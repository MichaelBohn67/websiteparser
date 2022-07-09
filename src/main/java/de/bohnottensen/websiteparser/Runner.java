package de.bohnottensen.websiteparser;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Runner implements CommandLineRunner {

    private ParserService parserService;
    
    public Runner(ParserService parserService) {
        this.parserService = parserService;
    }

    @Override
    public void run(String... args) throws Exception {
        parserService.parseSite();
    }
}
