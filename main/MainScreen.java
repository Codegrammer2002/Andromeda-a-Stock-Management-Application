/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business_application_ia;

import com.github.sarxos.webcam.Webcam;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.util.Random;
import javax.imageio.ImageIO;

/**
 *
 * @author Parv
 */

public class MainScreen extends javax.swing.JFrame {

    /**
     * Creates new form MainScreen
     */
    static String passcode ="";
    static String dup;
    static int Switch;
    
   // JTextField jt = new JTextField(40);
      Connection conn = null;
    ResultSet rs = null;
    PreparedStatement ps = null;
   EmailScreen es = new EmailScreen();
    public MainScreen() {
        initComponents();
        LoginPage lp = new LoginPage();
      String name  =  LoginPage.global_username;
        // UserF.setText(name);
        userLabel.setText(name);
             conn = JavaConnect.ConnecrDb();
          //UserF.setEditable(false);
          Toolkit tk = getToolkit();
         Dimension size = tk.getScreenSize();
         setLocation(size.width/2- getWidth()/2, size.height/2 - getHeight()/2);
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
          
           Transport.send(message);    
          JOptionPane.showMessageDialog(null, " Email sent successfully");    
          } 
          catch (MessagingException e) {
           throw new RuntimeException(e);
          
          
          }   
           
          
           
          
    }
    private void checkPinCode(){
        try{
        String sql = "Select Pincode from PincodeInfo ";
        ps = conn.prepareStatement(sql);
        rs = ps.executeQuery();
        passcode = rs.getString("Pincode");
         dup = passcode;
        }
        catch(Exception e){
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
      String code =  JOptionPane.showInputDialog(this, "Enter code");
      
      if (code.equals(passcode) ){
      if(Switch ==1){    
      RevenueScreen rs  = new RevenueScreen();
      rs.setVisible(true);
      this.setVisible(false);
      }
      else if(Switch == 2){
      UserDatabaseScreen uds = new UserDatabaseScreen();
      uds.setVisible(true);
      this.setVisible(false);
      }
      }
      else{
          JOptionPane.showMessageDialog(null, "Access denied \n You must have the authorization to access the revenue");
           int boolvar =  JOptionPane.showConfirmDialog(null, "Forgot password. Do you want to change it? " , "Confirmation",JOptionPane.YES_NO_OPTION);
           if(boolvar  ==0){
               String email = JOptionPane.showInputDialog(this, "Enter your work email");
               if (email.equals("iacsapp2002@gmail.com")){
               JOptionPane.showMessageDialog(null, "Email sent successully. Please check your email. Click OK to proceed ");
      
               Random rand = new Random(); //instance of random class
      
      
                int upperbound = 1000;
           

                 int int_random = rand.nextInt( upperbound); 
                 String ranum = Integer.toString(int_random);
                 
               Mailer.send("iacsapp2002@gmail.com", "potet123",  "iacsapp2002@gmail.com", "Code verfication" ,ranum + " \nThis email has been requested by " + userLabel.getText() );
                       
              String con_key = JOptionPane.showInputDialog(null, "Please enter the code");
              if(con_key.equals(ranum)){
              JOptionPane.showMessageDialog(null, "Code entered is correct. this is your new code for accessing revenue");
              try{
              String sql = ("Update PincodeInfo  set Pincode = '"+ranum+"' where Pincode = '"+dup+"' ");
               ps = conn.prepareStatement(sql);
       
                ps.execute();
              } 
              catch(Exception e){
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
              passcode = con_key;
              
              }
              else{ JOptionPane.showMessageDialog(null, "Code entered is wrong. Please try again later");}
               }
               
               else{ JOptionPane.showMessageDialog(null, "Wrong email entered. Please repeat the same process ");}
           }
           else{JOptionPane.showMessageDialog(null, "Password retriveal process cancelled ");}
           
      }
    
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jToggleButton3 = new javax.swing.JToggleButton();
        jToggleButton1 = new javax.swing.JToggleButton();
        jToggleButton2 = new javax.swing.JToggleButton();
        jLabel2 = new javax.swing.JLabel();
        Stockbtn = new javax.swing.JButton();
        Customerbtn = new javax.swing.JButton();
        Checkoutbtn = new javax.swing.JButton();
        Weaversbtn = new javax.swing.JButton();
        revenuebtn = new javax.swing.JButton();
        salesInfobtn = new javax.swing.JButton();
        Emailbtn = new javax.swing.JButton();
        Userbtn = new javax.swing.JButton();
        userLabel = new javax.swing.JLabel();

        jLabel1.setText("jLabel1");

        jToggleButton3.setText("jToggleButton3");

        jToggleButton1.setText("Stock");

        jToggleButton2.setText("Customers");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel2.setText("Welcome:");

        Stockbtn.setText("Stock");
        Stockbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                StockbtnActionPerformed(evt);
            }
        });

        Customerbtn.setText("Customers");
        Customerbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CustomerbtnActionPerformed(evt);
            }
        });

        Checkoutbtn.setText("Bill/ Checkout");
        Checkoutbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CheckoutbtnActionPerformed(evt);
            }
        });

        Weaversbtn.setText("Weavers");
        Weaversbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                WeaversbtnActionPerformed(evt);
            }
        });

        revenuebtn.setText("Revenue");
        revenuebtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                revenuebtnActionPerformed(evt);
            }
        });

        salesInfobtn.setText("Sales");
        salesInfobtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salesInfobtnActionPerformed(evt);
            }
        });

        Emailbtn.setText("Send emails");
        Emailbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EmailbtnActionPerformed(evt);
            }
        });

        Userbtn.setText("Users");
        Userbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UserbtnActionPerformed(evt);
            }
        });

        userLabel.setText(" ");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(userLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(Userbtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(Checkoutbtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(Stockbtn, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(Customerbtn, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(102, 116, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(Weaversbtn, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                        .addComponent(revenuebtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(salesInfobtn, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Emailbtn, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(63, 63, 63))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(userLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(50, 50, 50)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Stockbtn)
                            .addComponent(Weaversbtn))
                        .addGap(51, 51, 51)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Customerbtn)
                            .addComponent(revenuebtn))
                        .addGap(58, 58, 58)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Checkoutbtn)
                            .addComponent(salesInfobtn))
                        .addGap(0, 94, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Emailbtn)
                            .addComponent(Userbtn))
                        .addContainerGap())))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void StockbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_StockbtnActionPerformed
        // TODO add your handling code here:
       
        StockScreen ss = new StockScreen();
       
        ss.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_StockbtnActionPerformed

    private void CustomerbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CustomerbtnActionPerformed
        // TODO add your handling code here:
        CustomerScreen  cs = new CustomerScreen();
        cs.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_CustomerbtnActionPerformed

    private void CheckoutbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CheckoutbtnActionPerformed
        // TODO add your handling code here:
        Checkout co = new Checkout();
        co.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_CheckoutbtnActionPerformed

    private void WeaversbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_WeaversbtnActionPerformed
        // TODO add your handling code here:
        WeaverScreen ws = new WeaverScreen();
        ws.setVisible(true);
        this.setVisible(false);
                
    }//GEN-LAST:event_WeaversbtnActionPerformed

    private void salesInfobtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salesInfobtnActionPerformed
        // TODO add your handling code here:
        RevenueScreen.int_back_global = 0;
        
        SalesInfoScreen sis = new SalesInfoScreen();
        sis.setVisible(true);
        this.setVisible(false);
        
    }//GEN-LAST:event_salesInfobtnActionPerformed

    private void EmailbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EmailbtnActionPerformed
        // TODO add your handling code here:
        EmailScreen es = new EmailScreen();
        es.setVisible(true);
        this.setVisible(false);
        
    }//GEN-LAST:event_EmailbtnActionPerformed

    private void revenuebtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_revenuebtnActionPerformed
        // TODO add your handling code here:
        Switch =1;
        checkPinCode();
        
       /**< 
       try{
        String sql = "Select Pincode from PincodeInfo ";
        ps = conn.prepareStatement(sql);
        rs = ps.executeQuery();
        passcode = rs.getString("Pincode");
         dup = passcode;
        }
        catch(Exception e){
                      JOptionPane.showMessageDialog(null, e);

        }
      String code =  JOptionPane.showInputDialog(this, "Enter code");
      if (code.equals(passcode) && Switch == 1){
          
      BillReport br  = new BillReport();
      br.setVisible(true);
      this.setVisible(false);
      
      }
      else{
          JOptionPane.showMessageDialog(null, "Access denied \n You must have the authorization to access the revenue");
           int boolvar =  JOptionPane.showConfirmDialog(null, "Forgot password. Do you want to change it? " , "Confirmation",JOptionPane.YES_NO_OPTION);
           if(boolvar  ==0){
               String email = JOptionPane.showInputDialog(this, "Enter your work email");
               if (email.equals("iacsapp2002@gmail.com")){
               JOptionPane.showMessageDialog(null, "Email sent successully. Please check your email. Click OK to proceed ");
      
               Random rand = new Random(); //instance of random class
      
      
                int upperbound = 1000;
           

                 int int_random = rand.nextInt( upperbound); 
                 String ranum = Integer.toString(int_random);
               Mailer.send("iacsapp2002@gmail.com", "potet123",  "iacsapp2002@gmail.com", "Code verfication",ranum );
                       
              String con_key = JOptionPane.showInputDialog(null, "Please enter the code");
              if(con_key.equals(ranum)){
              JOptionPane.showMessageDialog(null, "Code entered is correct. this is your new code for accessing revenue");
              try{
              String sql = ("Update PincodeInfo  set Pincode = '"+ranum+"' where Pincode = '"+dup+"' ");
               ps = conn.prepareStatement(sql);
       
                ps.execute();
              } 
              catch(Exception e){
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
              passcode = con_key;
              
              }
              else{ JOptionPane.showMessageDialog(null, "Code entered is wrong. Please try again later");}
               }
               
               else{ JOptionPane.showMessageDialog(null, "Wrong email entered. Please repeat the same process ");}
           }
           else{JOptionPane.showMessageDialog(null, "Password retriveal process cancelled ");}
           
      } */
    }//GEN-LAST:event_revenuebtnActionPerformed

    private void UserbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UserbtnActionPerformed
        // TODO add your handling code here:
        Switch =2;
        
        checkPinCode();
        
        
    }//GEN-LAST:event_UserbtnActionPerformed

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
            java.util.logging.Logger.getLogger(MainScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainScreen().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Checkoutbtn;
    private javax.swing.JButton Customerbtn;
    private javax.swing.JButton Emailbtn;
    private javax.swing.JButton Stockbtn;
    private javax.swing.JButton Userbtn;
    private javax.swing.JButton Weaversbtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JToggleButton jToggleButton1;
    private javax.swing.JToggleButton jToggleButton2;
    private javax.swing.JToggleButton jToggleButton3;
    private javax.swing.JButton revenuebtn;
    private javax.swing.JButton salesInfobtn;
    private javax.swing.JLabel userLabel;
    // End of variables declaration//GEN-END:variables
}
