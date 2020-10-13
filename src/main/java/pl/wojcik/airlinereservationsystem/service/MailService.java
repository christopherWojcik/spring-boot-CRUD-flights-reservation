package pl.wojcik.airlinereservationsystem.service;

import lombok.RequiredArgsConstructor;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

@Service
@RequiredArgsConstructor
public class MailService {

    private final JavaMailSender javaMailSender;

    public void sendMail(String to, String subject, String text) throws MessagingException {
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);
        mimeMessageHelper.setTo(to);
        mimeMessageHelper.setFrom("kristricity@gmail.com");
        mimeMessageHelper.setSubject(subject);
        mimeMessageHelper.setText(text);
        System.out.println("before send ... ... ...");
        javaMailSender.send(mimeMessage);
        System.out.println("after send ... ... ...");

    }
}
