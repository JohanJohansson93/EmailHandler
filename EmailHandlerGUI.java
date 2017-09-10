package Epost;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * This class acts as a gui for Epost.EmailHandler.
 * It extends JFrame and implements ActionListener.
 */
public class EmailHandlerGUI extends JFrame implements ActionListener{
    /*
        Creates and declares instance variables.
    */
    private EmailHandler email;
    private JTextField server, port, from, pw, to, subject;
    private JTextArea message;
    private JButton btn;
    private JPanel jPanel;
    /*
        This constructor takes a reference to Epost.EmailHandler as argument.
        It sets up the gui.
    */
    public EmailHandlerGUI(EmailHandler email){
        this.email = email;
        server = new JTextField();
        port = new JTextField();
        from = new JTextField();
        pw = new JTextField();
        to = new JTextField();
        subject = new JTextField();
        message = new JTextArea();
        btn = new JButton("Send Email");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jPanel = new JPanel();
        jPanel.setLayout(new GridLayout(6, 2));
        jPanel.add(new JLabel("Server:"));
        jPanel.add(this.server);
        jPanel.add(new JLabel("Port:"));
        jPanel.add(this.port);
        jPanel.add(new JLabel("From:"));
        jPanel.add(this.from);
        jPanel.add(new JLabel("Password:"));
        jPanel.add(this.pw);
        jPanel.add(new JLabel("To:"));
        jPanel.add(this.to);
        jPanel.add(new JLabel("Subject:"));
        jPanel.add(this.subject);
        btn.addActionListener(this);
        this.getContentPane().add("North", jPanel);
        this.getContentPane().add("South", btn);
        this.getContentPane().add("Center", new JScrollPane(message));
        this.setSize(600, 300);
        this.setVisible(true);
    }
    /*
        This method sets the title of the gui.
    */
    public void setHead(String title){
        setTitle(title);
    }
    /*
        This method returns the text.
    */
    public String getServerText(){
        return server.getText();
    }
    /*
        This method returns the text.
    */
    public String getPortText(){
        return port.getText();
    }
    /*
        This method returns the text.
    */
    public String getFromText(){
        return from.getText();
    }
    /*
        This method returns the text.
    */
    public String getPwText(){
        return pw.getText();
    }
    /*
        This method returns the text.
    */
    public String getToText(){
        return to.getText();
    }
    /*
        This method returns the text.
    */
    public String getSubjectText(){
        return subject.getText();
    }
    /*
        This method returns the text.
    */
    public String getMsgText(){
        return message.getText();
    }
    /*
        When the button is pressed this method is invoked.
        It triggers the sendEmail method and the setText methods.
    */
    @Override
    public void actionPerformed(ActionEvent e) {
        email.sendEmail();
        from.setText("");
        pw.setText("");
        to.setText("");
        subject.setText("");
        message.setText("");
    }

}
