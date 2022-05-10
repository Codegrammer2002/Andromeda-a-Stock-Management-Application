package business_application_ia;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.File;
import java.util.HashSet;
/**
 *
 * @author Parv
 */import java.util.Properties;    
import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.*;    
import javax.mail.internet.*;    
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
 import java.util.Date;
    
  
//public class SendMailSSL{    
 
public class AttachmentMailer {
    //public static void send(String from,String password,String to,String sub,String msg){  
          //Get properties object    
   static String attachment;    
   static String name;
    public  void getFile(){
        JFileChooser choose = new JFileChooser();
        choose.showOpenDialog(null);
        File file = choose.getSelectedFile();
        attachment = file.getAbsolutePath();
        
    }
    public  void getName(){
   name = JOptionPane.showInputDialog(null, "Please give the name for the file");
    
    }
    
    public void sendAttachment(String to, String subject, String body) {
 Properties props = new Properties();    
          props.put("mail.smtp.host", "smtp.gmail.com");    
          props.put("mail.smtp.socketFactory.port", "465");    
          props.put("mail.smtp.socketFactory.class",    
                    "javax.net.ssl.SSLSocketFactory");    
          props.put("mail.smtp.auth", "true");    
          props.put("mail.smtp.port", "465");    
          //get Session   
          Session session = Session.getDefaultInstance(props,    
           new javax.mail.Authenticator() {    
           protected PasswordAuthentication getPasswordAuthentication() {    
           return new PasswordAuthentication("iacsapp2114@gmail.com","Unh@ck@ble");  
           }    
          });    
          //compose message
          int check = LoginPage.global_int;
          System.out.println(check);
          if(check !=1){
          try {    
           MimeMessage message = new MimeMessage(session);    
           message.addRecipient(Message.RecipientType.TO,new InternetAddress(to));    
           message.setSubject(subject);    
           
           MimeBodyPart mbp = new MimeBodyPart();
           mbp.setText(body);
           Multipart mp = new MimeMultipart();
           mp.addBodyPart(mbp);
           mbp = new MimeBodyPart();
           getFile();
           getName();
              System.out.println(attachment);
           DataSource src = new FileDataSource(attachment);
           mbp.setDataHandler(new DataHandler(src));
           mbp.setFileName(name);
           mp.addBodyPart(mbp);
           message.setContent(mp);

           //send message  
           Transport.send(message);    
           System.out.println("message sent successfully");    
          } 
         catch (MessagingException e) {throw new RuntimeException(e);}    
    }   
          else{
              try {    
           MimeMessage message = new MimeMessage(session);    
           message.addRecipient(Message.RecipientType.TO,new InternetAddress("iacsapp2114@gmail.com"));    
           message.setSubject("Alert! Security breach ");    
           
           MimeBodyPart mbp = new MimeBodyPart();
           Date dt = new Date();
       
           mbp.setText("Breach alert. Somebody is tyring to access the application on" + dt + " \n\n Please check the attached photo. If it is not you" );
           Multipart mp = new MimeMultipart();
           mp.addBodyPart(mbp);
           mbp = new MimeBodyPart();
   
              System.out.println("");
           DataSource src = new FileDataSource("C:\\Users\\DELL\\Business_Application_IA-20211023T164529Z-001\\Business_Application_IA\\Capture.jpg");
           mbp.setDataHandler(new DataHandler(src));
           mbp.setFileName("Breach Capture");
           mp.addBodyPart(mbp);
           message.setContent(mp);

           //send message  
           Transport.send(message);    
           System.out.println("message sent successfully alert");    
          } 
         catch (MessagingException e) {throw new RuntimeException(e);}   
          }
     //from,password,to,subject,message  
    // Mailer.send("iacsapp2002@gmail.com","potet123","@gmail.com"," open","using code to send this to you!!!");  
     
     //change from, password and to  
// }    
}
}
