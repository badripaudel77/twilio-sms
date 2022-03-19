package com.example.twiliosmsjava.services;

import com.example.twiliosmsjava.config.TwilioConfig;
import com.twilio.rest.api.v2010.account.MessageCreator;
import com.twilio.type.PhoneNumber;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
      }
      catch (Exception e) {
          System.out.println(e.getMessage());
          logger.error("Something went wrong");
          return false;
      }
    }
}
