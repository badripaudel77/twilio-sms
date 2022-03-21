package com.example.twiliosmsjava;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TwilioSmsJavaApplication {
    static Logger logger = LoggerFactory.getLogger(TwilioSmsJavaApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(TwilioSmsJavaApplication.class, args);
        logger.debug("App is up and running ");
        System.out.println("app running ");
    }

}
