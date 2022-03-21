package com.example.twiliosmsjava.services;

import com.example.twiliosmsjava.config.TwilioConfig;
import com.twilio.rest.api.v2010.account.MessageCreator;
import com.twilio.type.PhoneNumber;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;

@EnableScheduling
@Service
public class TwilioService {
    private static final Logger logger = LoggerFactory.getLogger(TwilioService.class);
    @Autowired
    TwilioConfig twilioConfig;

    public boolean sendSMS() {
        MessageCreator creator = new MessageCreator(
                new PhoneNumber("+yours"),
                new PhoneNumber(twilioConfig.getTrialNumber()),
                "Hello From Twilio"
        );
        try {
            creator.create();
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            logger.error("Something went wrong");
            return false;
        }
    }

    //@Scheduled(cron ="0/30 0/1 * 1/1 * ?") // every twenty second
    public boolean sendBirthdayWishToCustomer() {
        // get all the customers who have birthday marked as today
        // send sms to their phone number
        System.out.println("Happy birthday dear John, best regards ABC Bank");
        return true;
    }

    @Scheduled(cron ="0/30 0/1 * 1/1 * ?") // every thirty second
    public void greet() {
        System.out.println("Every Thirty Seconds");
    }

    @Scheduled(fixedRate = 5000)
    public void reportCurrentTime() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
        System.out.println("The time is now : " +  dateFormat.format(new Date()));
    }
}
