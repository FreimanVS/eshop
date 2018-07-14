package com.freimanvs.shops.eshop.mail;

import org.apache.log4j.Logger;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.annotation.Resource;
import javax.enterprise.context.RequestScoped;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URISyntaxException;
import java.util.Date;

@RequestScoped
public class EmailUtil {

    @Resource(name = "mail/Gmail")
    private Session session;

    private static final String FROM = "eshop@mail.ru";
    private static final String WHO = "eshop manager";

    private static final Logger LOGGER = Logger.getLogger(EmailUtil.class);

    public void sendEmail(String toEmail, String subject, String body){
        try {
            MimeMessage msg = new MimeMessage(session);
            //set message headers
            msg.addHeader("Content-type", "text/HTML; charset=UTF-8");
            msg.addHeader("format", "flowed");
            msg.addHeader("Content-Transfer-Encoding", "8bit");

            msg.setFrom(new InternetAddress(
                    FROM
//                    "vitr1988@gmail.com"
                    ,
                    WHO
//                    "Vitalii Ivanov"
            ));

            msg.setReplyTo(InternetAddress.parse(
                    FROM
//                    "vitr.ivanov@gmail.com"
                    , false));

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

    public void sendAttachmentEmail(String toEmail, String subject, String body, String filename){
        try{
            MimeMessage msg = new MimeMessage(session);
            msg.addHeader("Content-type", "text/HTML; charset=UTF-8");
            msg.addHeader("format", "flowed");
            msg.addHeader("Content-Transfer-Encoding", "8bit");

            msg.setFrom(new InternetAddress("vitr1988@gmail.com", "Vitalii Ivanov"));

            msg.setReplyTo(InternetAddress.parse("vitr.ivanov@gmail.com", false));

            msg.setSubject(subject, "UTF-8");

            msg.setSentDate(new Date());

            msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toEmail, false));

            // Create the message body part
            BodyPart messageBodyPart = new MimeBodyPart();

            // Fill the message
            messageBodyPart.setText(body);

            // Create a multipart message for attachment
            Multipart multipart = new MimeMultipart();

            // Set text message part
            multipart.addBodyPart(messageBodyPart);

            // Second part is attachment
            messageBodyPart = new MimeBodyPart();
//            DataSource source = new FileDataSource(new File(EmailUtil.class.getResource("/" + filename).toURI()));
            DataSource source = new FileDataSource(new File("reports/" + filename));
            messageBodyPart.setDataHandler(new DataHandler(source));
            messageBodyPart.setFileName(filename);
            multipart.addBodyPart(messageBodyPart);

            // Send the complete message parts
            msg.setContent(multipart);

            // Send message
            Transport.send(msg);
            LOGGER.info("EMail Sent Successfully with attachment!!");
        }catch (MessagingException | UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

    public void sendImageEmail(String toEmail, String subject, String body){
        try{
            MimeMessage msg = new MimeMessage(session);
            msg.addHeader("Content-type", "text/HTML; charset=UTF-8");
            msg.addHeader("format", "flowed");
            msg.addHeader("Content-Transfer-Encoding", "8bit");

            msg.setFrom(new InternetAddress("vitr1988@gmail.com", "Vitalii Ivanov"));

            msg.setReplyTo(InternetAddress.parse("vitr.ivanov@gmail.comcom", false));

            msg.setSubject(subject, "UTF-8");

            msg.setSentDate(new Date());

            msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toEmail, false));

            // Create the message body part
            BodyPart messageBodyPart = new MimeBodyPart();

            messageBodyPart.setText(body);

            // Create a multipart message for attachment
            Multipart multipart = new MimeMultipart();

            // Set text message part
            multipart.addBodyPart(messageBodyPart);

            // Second part is image attachment
            messageBodyPart = new MimeBodyPart();
            String filename = "image.png";
            DataSource source = new FileDataSource(filename);
            messageBodyPart.setDataHandler(new DataHandler(source));
            messageBodyPart.setFileName(filename);
            //Trick is to add the content-id header here
            messageBodyPart.setHeader("Content-ID", "image_id");
            multipart.addBodyPart(messageBodyPart);

            //third part for displaying image in the email body
            messageBodyPart = new MimeBodyPart();
            messageBodyPart.setContent("<h1>Attached Image</h1>" +
                    "<img src='cid:image_id'>", "text/html");
            multipart.addBodyPart(messageBodyPart);

            //Set the multipart message to the email message
            msg.setContent(multipart);

            // Send message
            Transport.send(msg);

            System.out.println("EMail Sent Successfully with image!!");
        }catch (MessagingException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }
}