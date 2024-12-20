package com.xworkz.service;

import com.xworkz.util.EncryptionDecryption;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;


@Service
public class EmailClass {

    @Autowired
    private EncryptionDecryption encryptionDecryption;

    @Autowired
    private JavaMailSender mailSender;

    public String getOtp() {
        Random random = new Random();
        int randomNum = random.nextInt(999999);
        return String.format("%06d", randomNum);
    }


    public String emailSend(String email) {
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setFrom("rajendra18raj@gmail.com");
        simpleMailMessage.setTo(email);
        simpleMailMessage.setSubject("reset Password Otp");
        String otp = getOtp();
        simpleMailMessage.setText(otp);
        mailSender.send(simpleMailMessage);
        return otp;
    }

    public String mimeMessage(String email) {

        MimeMessagePreparator preparator = mimeMessage -> {
            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage,"UTF-8");
            helper.setFrom("rajendra18raj@gmail.com");
            helper.addTo(email);
            helper.setSubject("Metro Registration");
            String content = "<html>" +
                    "<body>" +
                    "<p>Your registration was completed successfully!</p>" +
                    "</body>" +
                    "</html>";

            helper.setText(content,true);
        };
        mailSender.send(preparator);

        return "Mail sent successfully";

    }



    public String ticketMessage(String email,String ticketNumber) {

        MimeMessagePreparator preparator = mimeMessage -> {
            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage,"UTF-8");
            helper.setFrom("rajendra18raj@gmail.com");
            helper.addTo(email,ticketNumber);
            helper.setSubject("Metro Ticket");
            String content = ("<html>" +
                    "<body>" +
                    "<h2>Ticket Booked Successfully<h2>" +
                    "</body>" +
                    "</html>");
            helper.setText(content,true);
        };
        mailSender.send(preparator);

        return "Mail sent successfully";

    }

}
