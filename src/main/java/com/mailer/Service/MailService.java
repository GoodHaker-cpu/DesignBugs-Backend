package com.mailer.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class MailService {

    @Autowired
    JavaMailSender mailSender;

    public String sendEmail(String name,String email, String phoneNumber, String userQuestion) {
        try {
            String body = "You have a new inquiry from a user:\n\n"
                    + "Name: " + name + "\n"
                    + "Email: " + email + "\n"
                    + "Phone Number: " + phoneNumber + "\n"
                    + "Question: " + userQuestion + "\n\n"
                    + "Regards,\nDesign-Bugs";
            SimpleMailMessage message = new SimpleMailMessage();
            message.setTo("akashvikas413@gmail.com");
            message.setSubject("User Details");
            message.setText(body);
            message.setFrom("iamakash2024@gmail.com");

            mailSender.send(message);
            return "Email sent successfully!";
        } catch (Exception e) {
            return "Error while sending email: " + e.getMessage();
        }
    }
}
