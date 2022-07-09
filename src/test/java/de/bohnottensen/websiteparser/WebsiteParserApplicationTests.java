package de.bohnottensen.websiteparser;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;


@SpringBootTest
class WebsiteParserApplicationTests {

    @Autowired
    WebsiteParserApplication websiteParserApplication;

    @Test
    void contextLoads() throws Exception {
        assertThat(websiteParserApplication).isNotNull();
    }

}
