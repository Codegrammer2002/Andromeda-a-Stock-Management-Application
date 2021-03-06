/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business_application_ia;

/**
 *
 * @author Parv
 */
import java.awt.Dimension;
import java.awt.Toolkit;
import java.sql.*; 
import javax.swing.*;
import net.proteanit.sql.DbUtils; 
public class WeaverScreen extends javax.swing.JFrame {

    /**
     * Creates new form WeaverScreen
     */  Connection conn = null;
    ResultSet rs = null;
    PreparedStatement ps = null;
    
    public WeaverScreen() {
        initComponents();
          conn = JavaConnect.ConnecrDb();
         Update_table();
         Toolkit tk = getToolkit();
         Dimension size = tk.getScreenSize();
         setLocation(size.width/2- getWidth()/2, size.height/2 - getHeight()/2);
         
        
    }
    
      private void Update_table(){
    try{
    String sql = "Select * from WeaverInfo";
    ps = conn.prepareStatement(sql);
    rs = ps.executeQuery();
    Table_Weaver.setModel(DbUtils.resultSetToTableModel(rs));
    
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
    }
      private void Clear_Screen(){
      idF.setText("");
      NameF.setText("");
      EmailF.setText("");
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
        jTable1 = new javax.swing.JTable();
        jScrollPane1 = new javax.swing.JScrollPane();
        Table_Weaver = new javax.swing.JTable();
        backbtn = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        idF = new javax.swing.JTextField();
        NameF = new javax.swing.JTextField();
        EmailF = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        deletebtn = new javax.swing.JButton();
        Addbtn = new javax.swing.JButton();
        editbtn = new javax.swing.JButton();
        clearbtn = new javax.swing.JButton();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(jTable1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Table_Weaver.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        Table_Weaver.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Table_WeaverMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(Table_Weaver);

        backbtn.setText("Back");
        backbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backbtnActionPerformed(evt);
            }
        });

        jLabel1.setText("Name:");

        jLabel2.setText("ID");

        jLabel3.setText("Email");

        deletebtn.setText("Delete");
        deletebtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deletebtnActionPerformed(evt);
            }
        });

        Addbtn.setText("Add");
        Addbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddbtnActionPerformed(evt);
            }
        });

        editbtn.setText("Edit");
        editbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editbtnActionPerformed(evt);
            }
        });

        clearbtn.setText("Clear");
        clearbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearbtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(idF, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(37, 37, 37)
                        .addComponent(jLabel1)
                        .addGap(5, 5, 5)
                        .addComponent(NameF, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addComponent(EmailF, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(Addbtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(deletebtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(editbtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(clearbtn)
                        .addGap(98, 98, 98)
                        .addComponent(backbtn)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1)
                            .addComponent(EmailF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3)
                            .addComponent(NameF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addComponent(idF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(editbtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(Addbtn)
                        .addComponent(deletebtn)
                        .addComponent(backbtn)
                        .addComponent(clearbtn)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void backbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backbtnActionPerformed
        // TODO add your handling code here:
         MainScreen ms = new MainScreen();
        ms.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_backbtnActionPerformed

    private void Table_WeaverMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Table_WeaverMouseClicked
        // TODO add your handling code here:
           try{
            //JOptionPane.showMessageDialog(null, "Working");
            int row = Table_Weaver.getSelectedRow();
            String Table_click = (Table_Weaver.getModel().getValueAt(row, 0).toString());
            String sql = "Select * from WeaverInfo where WeaverID =' "+Table_click+ "' ";
             ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            if(rs.next()){
            String addID = rs.getString("WeaverID");
            idF.setText(addID);
                
           String addName = rs.getString("WeaverName");
           NameF.setText(addName);
           
            String addEmail = rs.getString("Email");
            EmailF.setText(addEmail);
            
           
            
          
            
            }
        
            
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
    }//GEN-LAST:event_Table_WeaverMouseClicked

    private void AddbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddbtnActionPerformed
        // TODO add your handling code here:
           try{
            String sql = "Insert into WeaverInfo(WeaverID, WeaverName, Email) values (?,?,?) ";
            ps = conn.prepareStatement(sql);
            ps.setString(1, idF.getText());
            
            ps.setString(2, NameF.getText());
            ps.setString(3, EmailF.getText());
            
            ps.execute();
            JOptionPane.showMessageDialog(null, "Data saved!");
        
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
        Update_table();
              Clear_Screen();
        
    }//GEN-LAST:event_AddbtnActionPerformed

    private void deletebtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deletebtnActionPerformed
        // TODO add your handling code here:
          int boolvar =  JOptionPane.showConfirmDialog(null, "Confirm deletion. " , "Deletion",JOptionPane.YES_NO_OPTION);
              if(boolvar == 0){
           String sql = "delete from WeaverInfo where WeaverID = ?";

        try{
            ps  =conn.prepareStatement(sql);
            ps.setString(1,idF.getText());
                    
            ps.execute();
            JOptionPane.showMessageDialog(null, "Succesfully deleted");
            
            
        }
        catch(Exception e){
            
            
        
        }
        finally {
            try{
                rs.close();
                ps.close();
    
              }
            catch(Exception e) {
                   }
      } 
        Update_table();
        Clear_Screen();

    }                                         
              else{ JOptionPane.showMessageDialog(null, "Deletion cancelled");}
        
    }//GEN-LAST:event_deletebtnActionPerformed

    private void editbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editbtnActionPerformed
        // TODO add your handling code here:
         try{
       
       String CustomerID = idF.getText();
       String Namev = NameF.getText();
       String Emailv = EmailF.getText();
   
       
       String sql = "update WeaverInfo set WeaverID= '"+CustomerID+"' , WeaverName ='"+Namev+"', Email = '"+Emailv+"' where WeaverID= '"+CustomerID+"'  ";
       ps = conn.prepareStatement(sql);
       
       ps.execute();
       JOptionPane.showMessageDialog(null, "Table has been sucessfully updated!");
       Clear_Screen();
       
       Update_table();
       
        
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
    }//GEN-LAST:event_editbtnActionPerformed

    private void clearbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearbtnActionPerformed
        // TODO add your handling code here:
        Clear_Screen();
    }//GEN-LAST:event_clearbtnActionPerformed

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
            java.util.logging.Logger.getLogger(WeaverScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(WeaverScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(WeaverScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(WeaverScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new WeaverScreen().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Addbtn;
    private javax.swing.JTextField EmailF;
    private javax.swing.JTextField NameF;
    private javax.swing.JTable Table_Weaver;
    private javax.swing.JButton backbtn;
    private javax.swing.JButton clearbtn;
    private javax.swing.JButton deletebtn;
    private javax.swing.JButton editbtn;
    private javax.swing.JTextField idF;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
