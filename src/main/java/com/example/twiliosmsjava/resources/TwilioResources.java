package com.example.twiliosmsjava.resources;

import com.example.twiliosmsjava.services.TwilioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TwilioResources {
    // Inject the TwilioSMS service
    @Autowired
    TwilioService twilioService;

    @GetMapping("/sms")
    public String sendSMS() {
        // send the message
        boolean isSent = twilioService.sendSMS();
        if(isSent) {
            return  "SMS Sent Successfully to the provided number";
        }
        return "SMS Couldn't be sent";
    }
}
