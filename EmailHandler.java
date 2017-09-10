package Epost;

import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
/**
 * This class acts as a EmailConnector.
 */
public class EmailHandler{

    /*
        Creates and declares instance variables.
    */
    private EmailHandlerGUI gui;
    private Properties properties;
    private Session session;
    private MimeMessage mimeMessage;
    private InternetAddress intaddress;
    private Address[] address;
    private final String SSL_FACTORY = "javax.net.ssl.SSLSocketFactory";

    /*
        This constructor creates a new instance of Epost.EmailHandlerGUI.
        It also sets the title.
    */
    public EmailHandler() {
        gui = new EmailHandlerGUI(this);
        gui.setTitle("Jmail");
    }
    /*
       This method defines a mail session. The Session object takes advantage of the Properties object.
       The Properties object is filled with information like mail server, port, username etc.
       The MimeMessage object creates the message. And finally the Transport class sends the message.
    */
    public void sendEmail() {
        properties = new Properties();
        properties.put("mail.smtp.host", gui.getServerText());
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.setProperty("mail.smtp.socketFactory.class", SSL_FACTORY);
        properties.setProperty("mail.smtp.socketFactory.fallback", "false");
        properties.put("mail.smtp.port", gui.getPortText());
        session = Session.getDefaultInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(gui.getFromText(), gui.getPwText());
            }
        });
        try {
            mimeMessage = new MimeMessage(session);
            intaddress = new InternetAddress(gui.getFromText());
            mimeMessage.setFrom(intaddress);
            address = new InternetAddress[]{new InternetAddress(gui.getToText())};
            mimeMessage.setRecipients(Message.RecipientType.TO, address);
            mimeMessage.setSubject(gui.getSubjectText());
            mimeMessage.setText(gui.getMsgText());
            Transport.send(mimeMessage);
            System.out.println("Email sent!");
        }
        catch (MessagingException msgException) {
            System.out.println(msgException);
        }
    }
    /*
        The main method. Creates an instance of Epost.EmailHandler.
    */
    public static void main(String[] args) {
        new EmailHandler();
    }
}