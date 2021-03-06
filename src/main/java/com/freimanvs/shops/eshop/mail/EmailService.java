package com.freimanvs.shops.eshop.mail;

import org.apache.log4j.Logger;

import javax.annotation.Resource;
import javax.enterprise.context.RequestScoped;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Date;

@RequestScoped
public class EmailService {

    @Resource(name = "mail/Gmail")
    private Session session;

    private static final Logger LOGGER = Logger.getLogger(EmailService.class);

    public void sendEmail(String fromPerson, String fromEmail, String toEmail, String subject, String body){
        try {
            MimeMessage msg = new MimeMessage(session);
            msg.addHeader("Content-type", "text/HTML; charset=UTF-8");
            msg.addHeader("format", "flowed");
            msg.addHeader("Content-Transfer-Encoding", "8bit");

            msg.setFrom(new InternetAddress(fromEmail, fromPerson));

            msg.setReplyTo(InternetAddress.parse(fromEmail, false));

            msg.setSubject(subject, "UTF-8");

            msg.setText(body, "UTF-8");

            msg.setSentDate(new Date());

            msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toEmail, false));

            LOGGER.info("Message is ready");

            Transport.send(msg);

            LOGGER.info("Email Is Sent Successfully!!");
        }
        catch (Exception e) {
            LOGGER.warn(e.getLocalizedMessage());
            e.printStackTrace();
        }
    }
}
