/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor. j
 */
package business_application_ia;

import static com.sun.javafx.scene.control.skin.FXVK.attach;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;
import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import net.proteanit.sql.DbUtils; 
/**
 *
 * @author Parv
 */
public class EmailScreen extends javax.swing.JFrame {

    /**
     * Creates new form EmailScreen
     */
    
    Connection conn = null;
    ResultSet rs = null;
    PreparedStatement ps = null;

    public EmailScreen() {
        initComponents();
        conn = JavaConnect.ConnecrDb();
        getCustomerEmail();
        Toolkit tk = getToolkit();
         Dimension size = tk.getScreenSize();
         setLocation(size.width/2- getWidth()/2, size.height/2 - getHeight()/2);
         getWeaverEmail();
        
        
    }
    public void getCustomerEmail(){
       try{
         String sql = "Select CustomerEmail from CustomerInfo ";

        ps = conn.prepareStatement(sql);
        rs = ps.executeQuery();
        
        while(rs.next()){
       String ItemName = rs.getString("CustomerEmail");
        toEmailsBox.addItem(ItemName);
         }
       }
        catch(SQLException e){
        JOptionPane.showMessageDialog(null, e);
        
        }
       finally {
            try{
                rs.close();
                ps.close();
    
              }
            catch(Exception e) {
                   }
      } 
        
    
    }
    public void getWeaverEmail(){
     try{
         String sql = "Select Email from WeaverInfo ";

        ps = conn.prepareStatement(sql);
        rs = ps.executeQuery();
        
        while(rs.next()){
       String ItemName = rs.getString("Email");
        toEmailsBox.addItem(ItemName);
         }
       }
        catch(SQLException e){
        JOptionPane.showMessageDialog(null, e);
        
        }
       finally {
            try{
                rs.close();
                ps.close();
    
              }
            catch(Exception e) {
                   }
      } 
    }
     public void send(String from,String password,String to,String sub,String msg) throws IOException{  
          //Get properties object    
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
           return new PasswordAuthentication("iacsapp2002@gmail.com","potet123");  
           }    
          });    
          //compose message    
          try {    
           MimeMessage message = new MimeMessage(session);    
           message.addRecipient(Message.RecipientType.TO,new InternetAddress(to));    
           message.setSubject(sub);    
           message.setText(msg);    
           /*
           //send message  
           Multipart emailContent = new MimeMultipart();
           // text body part
          MimeBodyPart textBodyPart = new MimeBodyPart();
          textBodyPart.setText(msg);
          //attachment body part
          MimeBodyPart pdfAttachment = new MimeBodyPart();
          pdfAttachment.attachFile("C:\\Users\\Parv\\Desktop\\sample.txt");
          emailContent.addBodyPart(textBodyPart);
          emailContent.addBodyPart(pdfAttachment);
          message.setContent(emailContent); */
          
           Transport.send(message);    
          JOptionPane.showMessageDialog(null, " Email sent successfully");    
          } 
          catch (MessagingException e) {
           throw new RuntimeException(e);
          
          
          }   
           
          
           /**    try {    
           MimeMessage message = new MimeMessage(session);    
           message.addRecipient(Message.RecipientType.TO,new InternetAddress(to));    
           message.setSubject(sub); 
           BodyPart mbp1 = new MimeBodyPart();
           mbp1.setText(msg);
           MimeBodyPart mbp2 = new MimeBodyPart();
           String filename = "sample.txt";
            DataSource src = new FileDataSource(filename);
            
          mbp2.setDataHandler(new DataHandler(src));
           mbp2.setFileName(filename);
           
          
          Multipart multipart = new MimeMultipart();
          multipart.addBodyPart(mbp1);
          multipart.addBodyPart(mbp2);
       
          
          
          message.setContent(multipart);
           //send message  
           Transport.send(message);    
          JOptionPane.showMessageDialog(null, " Email sent successfully");    
          } 
          catch (MessagingException e) {throw new RuntimeException(e);
          
          }  
           */  
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        jEditorPane1 = new javax.swing.JEditorPane();
        paymentRadio = new javax.swing.JRadioButton();
        billRadio = new javax.swing.JRadioButton();
        salesRadio = new javax.swing.JRadioButton();
        toEmailsBox = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        subjectF = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        bodyTxt = new javax.swing.JTextArea();
        jLabel3 = new javax.swing.JLabel();
        backbtn = new javax.swing.JButton();
        clearbn = new javax.swing.JButton();
        Sendbtn = new javax.swing.JButton();
        attachbtn = new javax.swing.JButton();
        ReorderRadio = new javax.swing.JRadioButton();

        jScrollPane2.setViewportView(jEditorPane1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        paymentRadio.setText("Payment Reminder");
        paymentRadio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                paymentRadioActionPerformed(evt);
            }
        });

        billRadio.setText("Send Bill Report");
        billRadio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                billRadioActionPerformed(evt);
            }
        });

        salesRadio.setText("Sales Info");
        salesRadio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salesRadioActionPerformed(evt);
            }
        });

        toEmailsBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Email" }));
        toEmailsBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                toEmailsBoxActionPerformed(evt);
            }
        });

        jLabel1.setText("TO:");

        subjectF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                subjectFActionPerformed(evt);
            }
        });

        jLabel2.setText("Subect:");

        bodyTxt.setColumns(20);
        bodyTxt.setRows(5);
        jScrollPane1.setViewportView(bodyTxt);

        jLabel3.setText("Body:");

        backbtn.setText("Back");
        backbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backbtnActionPerformed(evt);
            }
        });

        clearbn.setText("Clear fields");
        clearbn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearbnActionPerformed(evt);
            }
        });

        Sendbtn.setText("Send");
        Sendbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SendbtnActionPerformed(evt);
            }
        });

        attachbtn.setText("Attach files and send");
        attachbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                attachbtnActionPerformed(evt);
            }
        });

        ReorderRadio.setText("Reorder");
        ReorderRadio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ReorderRadioActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(paymentRadio)
                        .addGap(18, 18, 18)
                        .addComponent(salesRadio)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(billRadio)
                        .addGap(18, 18, 18)
                        .addComponent(ReorderRadio))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(30, 30, 30)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(clearbn)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(attachbtn)
                                .addGap(18, 18, 18)
                                .addComponent(Sendbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(subjectF, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(toEmailsBox, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 452, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(0, 55, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(backbtn)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(paymentRadio)
                    .addComponent(salesRadio)
                    .addComponent(billRadio)
                    .addComponent(ReorderRadio))
                .addGap(47, 47, 47)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(toEmailsBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(subjectF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addComponent(jLabel3))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(Sendbtn)
                        .addComponent(attachbtn))
                    .addComponent(clearbn))
                .addGap(30, 30, 30)
                .addComponent(backbtn)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void subjectFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_subjectFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_subjectFActionPerformed

    private void salesRadioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salesRadioActionPerformed
        // TODO add your handling code here:
        paymentRadio.setSelected(false);
        billRadio.setSelected(false);
        salesRadio.setSelected(true);
                ReorderRadio.setSelected(false);

              subjectF.setText("");
        bodyTxt.setText("");
        subjectF.setText(" Sales happening soon");
        bodyTxt.setText("Respected Sir/ Ma'am\n\n The brand new sale is happening soon. \n\n Come vist us! and buy latest item right now \n\n For any queries regarding please contact us at this email "
                + "iacsapp2002@gmail.com \n\n Thanks and Regards, \n\n Sanskriti Saree businnes");
    }//GEN-LAST:event_salesRadioActionPerformed

    private void backbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backbtnActionPerformed
        // TODO add your handling code here:
        MainScreen ms = new MainScreen();
        ms.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_backbtnActionPerformed

    private void toEmailsBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_toEmailsBoxActionPerformed
        // TODO add your handling code here:
      
    }//GEN-LAST:event_toEmailsBoxActionPerformed

    private void billRadioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_billRadioActionPerformed
        // TODO add your handling code here:
        paymentRadio.setSelected(false);
        billRadio.setSelected(true);
        salesRadio.setSelected(false);
        ReorderRadio.setSelected(false);
              subjectF.setText("");
        bodyTxt.setText("");
        subjectF.setText(" Bill information");
        bodyTxt.setText("Respected Sir/ Ma'am\n\n Thank for shopping with us \n\n Please find the attached bill infomration below. \n\n For any queries please contact us at this email "
                + "iacsapp2002@gmail.com \n\n Thanks and Regards, \n\n Sanskriti Saree businnes");
        
        
        
        
    }//GEN-LAST:event_billRadioActionPerformed

    private void paymentRadioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_paymentRadioActionPerformed
        // TODO add your handling code here:
        paymentRadio.setSelected(true);
        billRadio.setSelected(false);
        salesRadio.setSelected(false);
                ReorderRadio.setSelected(false);

        subjectF.setText("");
        bodyTxt.setText("");
        
        subjectF.setText(" Payment reminder. Please pay as soon as possible");
        bodyTxt.setText("Respected Sir/ Ma'am\n\n Thank for shopping with us \n\n This is kind reminder that your payment for item +Item Name+ is due on +Date+ \n\n For any queries please contact us at this email "
                + "iacsapp2002@gmail.com \n\n Thanks and Regards, \n\n Sanskriti Saree businnes");
    }//GEN-LAST:event_paymentRadioActionPerformed

    private void SendbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SendbtnActionPerformed
        // TODO add your handling code here:
        String toEmail = toEmailsBox.getSelectedItem().toString();
        
             Mailer.send("iacsapp2002@gmail.com","potet123",toEmail,subjectF.getText(),bodyTxt.getText());  

    }//GEN-LAST:event_SendbtnActionPerformed

    private void clearbnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearbnActionPerformed
        // TODO add your handling code here:
        paymentRadio.setSelected(false);
        billRadio.setSelected(false);
        salesRadio.setSelected(false);
        subjectF.setText("");
        bodyTxt.setText("");
    }//GEN-LAST:event_clearbnActionPerformed

    private void attachbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_attachbtnActionPerformed
        // TODO add your handling code here:
        AttachmentMailer am = new AttachmentMailer();
                String toEmail = toEmailsBox.getSelectedItem().toString();

        am.sendAttachment(toEmail, subjectF.getText(), bodyTxt.getText());
    }//GEN-LAST:event_attachbtnActionPerformed

    private void ReorderRadioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ReorderRadioActionPerformed
        // TODO add your handling code here:
         paymentRadio.setSelected(false);
        billRadio.setSelected(false);
        salesRadio.setSelected(false);
                ReorderRadio.setSelected(true);

              subjectF.setText("");
        bodyTxt.setText("");
        subjectF.setText(" Reorder request");
        bodyTxt.setText("Respected Sir/ Ma'am\n\n Please send -ItemName- \n\n Our adress is -Address- "
                + "iacsapp2002@gmail.com \n\n Thanks and Regards, \n\n Sanskriti Saree businnes");
    }//GEN-LAST:event_ReorderRadioActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(EmailScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EmailScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EmailScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EmailScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EmailScreen().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton ReorderRadio;
    private javax.swing.JButton Sendbtn;
    private javax.swing.JButton attachbtn;
    private javax.swing.JButton backbtn;
    private javax.swing.JRadioButton billRadio;
    private javax.swing.JTextArea bodyTxt;
    private javax.swing.JButton clearbn;
    private javax.swing.JEditorPane jEditorPane1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JRadioButton paymentRadio;
    private javax.swing.JRadioButton salesRadio;
    private javax.swing.JTextField subjectF;
    private javax.swing.JComboBox<String> toEmailsBox;
    // End of variables declaration//GEN-END:variables
    
}

  /***<
        JFileChooser choose = new JFileChooser();
        choose.showOpenDialog(null);
        File fl = choose.getSelectedFile();
       attachment_path = fl.getAbsolutePath();
       path = attachment_path;
      pathF.setText(attachment_path); */