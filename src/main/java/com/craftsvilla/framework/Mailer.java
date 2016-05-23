package com.craftsvilla.framework;



import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.io.File;
import java.util.List;
import java.util.Properties;


public class Mailer {


    private Session session;



    public Mailer(Properties properties){
        session = Session.getInstance(properties);
    }

    public Mailer(Properties properties, final String username, final String password){
        session = Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });
    }

    public void sendMessage(Message message) throws Exception{

        try{

            String to = "";
            List<String> receivers = message.getReceivers();

            for(int i = 0; i < receivers.size(); i++){
                to += receivers.get(i);

                if(i != receivers.size()-1){
                    to += ",";
                }
            }

            javax.mail.Message mes = new MimeMessage(session);
            mes.setFrom(new InternetAddress(message.getSender()));
            mes.setRecipients(javax.mail.Message.RecipientType.TO, InternetAddress.parse(to));
            mes.setSubject(message.getSubject());

            BodyPart messageBodyPart = new MimeBodyPart();
            messageBodyPart.setText(message.getBody());

            Multipart multipart = new MimeMultipart();
            multipart.addBodyPart(messageBodyPart);


            if(message.getAttachments() != null && !message.getAttachments().isEmpty()){

                for(File file : message.getAttachments()){

                    messageBodyPart = new MimeBodyPart();
                    DataSource ds = new FileDataSource(file);
                    messageBodyPart.setDataHandler(new DataHandler(ds));
                    messageBodyPart.setFileName(file.getName());
                    multipart.addBodyPart(messageBodyPart);
                }

            }

            mes.setContent(multipart);

            Transport.send(mes);


        }catch(MessagingException e){
            e.printStackTrace();
            throw e;
        }


    }


}
