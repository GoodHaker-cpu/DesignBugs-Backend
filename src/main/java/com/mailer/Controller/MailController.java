package com.mailer.Controller;

import com.mailer.Service.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/emails")
@CrossOrigin("*")
public class MailController {

    @Autowired
    private MailService emailService;

    @PostMapping("/send")
    public String sendMail( @RequestParam String name,@RequestParam String email,@RequestParam String phoneNumber,@RequestParam String userQuestion) {
        return emailService.sendEmail(name,email,phoneNumber,userQuestion);
    }

}
