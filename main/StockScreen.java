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
import javax.swing.JTextField;

public class StockScreen extends javax.swing.JFrame {
    Connection conn = null;
    ResultSet rs = null;
    PreparedStatement ps = null;
    

    /**
     * Creates new form StockScreen
     */
    public StockScreen() {
        initComponents();
        conn = JavaConnect.ConnecrDb();
        Update_table();
        Toolkit tk = getToolkit();
         Dimension size = tk.getScreenSize();
         setLocation(size.width/2- getWidth()/2, size.height/2 - getHeight()/2);
        
    }
     private void Clear_Screen(){
    IDF.setText("");
    ItemF.setText("");
    QuantityF.setText("");
    PriceF.setText("");
    WeaverF.setText("");
    
    }
     private void searchItem(){
     try{
        String sql = "select * from StockInfo where Item = ?";
        ps = conn.prepareStatement(sql);
        ps.setString(1,  searchF.getText());
        rs = ps.executeQuery();
        if(rs.next()){
        String addID = rs.getString("ItemID");
            IDF.setText(addID);
                
           String addItem = rs.getString("Item");
           ItemF.setText(addItem);
           
              String addQuantity = rs.getString("Quantity");
            QuantityF.setText(addQuantity);
            
            String addPrice = rs.getString("Price");
            PriceF.setText(addPrice);
             
            String addWeaver = rs.getString("Weaver");
           WeaverF.setText(addWeaver);
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
      try{
        String sql = "select * from StockInfo where ItemId = ?";
        ps = conn.prepareStatement(sql);
        ps.setString(1,  searchF.getText());
        rs = ps.executeQuery();
        if(rs.next()){
String addID = rs.getString("ItemID");
            IDF.setText(addID);
                
           String addItem = rs.getString("Item");
           ItemF.setText(addItem);
           
              String addQuantity = rs.getString("Quantity");
            QuantityF.setText(addQuantity);
            
            String addPrice = rs.getString("Price");
            PriceF.setText(addPrice);
             
            String addWeaver = rs.getString("Weaver");
           WeaverF.setText(addWeaver);
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
    }
    
    private void Update_table(){
    try{
    String sql = "Select * from StockInfo";
    ps = conn.prepareStatement(sql);
    rs = ps.executeQuery();
    Table_Info.setModel(DbUtils.resultSetToTableModel(rs));
    
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
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jSplitPane1 = new javax.swing.JSplitPane();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jSeparator1 = new javax.swing.JSeparator();
        jScrollPane3 = new javax.swing.JScrollPane();
        Table_Info = new javax.swing.JTable();
        Backbtn = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        ItemF = new javax.swing.JTextField();
        QuantityF = new javax.swing.JTextField();
        PriceF = new javax.swing.JTextField();
        WeaverF = new javax.swing.JTextField();
        Deletebtn = new javax.swing.JButton();
        Editbtn = new javax.swing.JButton();
        Addbtn = new javax.swing.JButton();
        IDF = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        Clearbtn = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        searchF = new javax.swing.JTextField();

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
        jScrollPane1.setViewportView(jTable1);

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(jTable2);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Table_Info.setModel(new javax.swing.table.DefaultTableModel(
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
        Table_Info.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Table_InfoMouseClicked(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                Table_InfoMouseReleased(evt);
            }
        });
        jScrollPane3.setViewportView(Table_Info);

        Backbtn.setText("Back");
        Backbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BackbtnActionPerformed(evt);
            }
        });

        jLabel1.setText("Item:");

        jLabel2.setText("Quantity:");

        jLabel3.setText("Price:");

        jLabel4.setText("Weaver:");

        ItemF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ItemFActionPerformed(evt);
            }
        });

        Deletebtn.setText("Delete Item");
        Deletebtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                DeletebtnMouseClicked(evt);
            }
        });
        Deletebtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeletebtnActionPerformed(evt);
            }
        });

        Editbtn.setText("Edit Item");
        Editbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EditbtnActionPerformed(evt);
            }
        });

        Addbtn.setText("Add Item");
        Addbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddbtnActionPerformed(evt);
            }
        });

        jLabel5.setText("ID");

        Clearbtn.setText("Clear");
        Clearbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ClearbtnActionPerformed(evt);
            }
        });

        jLabel6.setText("Search:");

        searchF.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                searchFKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(Addbtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Editbtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(Deletebtn)
                        .addGap(34, 34, 34)
                        .addComponent(Clearbtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(Backbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(PriceF)
                                    .addComponent(WeaverF, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(ItemF)
                                    .addComponent(QuantityF, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(IDF, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(searchF, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 105, Short.MAX_VALUE)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 374, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 372, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(ItemF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(31, 31, 31)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(QuantityF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addGap(31, 31, 31)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(PriceF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addGap(31, 31, 31)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(WeaverF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addGap(31, 31, 31)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(IDF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(searchF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(31, 31, 31)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Deletebtn)
                    .addComponent(Editbtn)
                    .addComponent(Backbtn)
                    .addComponent(Clearbtn)
                    .addComponent(Addbtn))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        setBounds(0, 0, 658, 463);
    }// </editor-fold>//GEN-END:initComponents

    private void BackbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BackbtnActionPerformed
        // TODO add your handling code here:
        MainScreen ms = new MainScreen();
        ms.setVisible(true);
        this.setVisible(false);
        
        
        
        
    }//GEN-LAST:event_BackbtnActionPerformed

    private void EditbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EditbtnActionPerformed
        // TODO add your handling code here:
        try{
       
       String ItemID = IDF.getText();
       String Itemv = ItemF.getText();
       String Quantityv = QuantityF.getText();
       String  Pricev  = PriceF.getText();
       String Weaverv = WeaverF.getText();
       
       String sql = "update StockInfo set ItemId= '"+ItemID+"' , Item ='"+Itemv+"', Quantity = '"+Quantityv+"', Price ='"+Pricev+"', Weaver ='"+Weaverv+"' where ItemId= '"+ItemID+"'  ";
       ps = conn.prepareStatement(sql);
       
       ps.execute();
       JOptionPane.showMessageDialog(null, "Table has been successfully updated");
       Update_table();
       Clear_Screen();
       
        
        
        }
        catch(Exception e){
        JOptionPane.showMessageDialog(null, e);
        }
              
    }//GEN-LAST:event_EditbtnActionPerformed

    private void AddbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddbtnActionPerformed
        // TODO add your handling code here:
        
        try{
            String sql = "Insert into StockInfo(ItemId, Item, Quantity,Price,Weaver) values (?,?,?,?,?) ";
            ps = conn.prepareStatement(sql);
            ps.setString(1, IDF.getText());

            ps.setString(2, ItemF.getText());
            ps.setString(3, QuantityF.getText());
            ps.setString(4, PriceF.getText());
            ps.setString(5, WeaverF.getText());

            ps.execute();
            JOptionPane.showMessageDialog(null, "Data saved!");

        }
        catch(Exception e){

                        JOptionPane.showMessageDialog(null, "Error: Item ID must be unique");

        }
        Update_table();
        Clear_Screen();
        
        
        
    }//GEN-LAST:event_AddbtnActionPerformed

    private void DeletebtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DeletebtnMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_DeletebtnMouseClicked

    private void Table_InfoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Table_InfoMouseClicked
        // TODO add your handling code here:
        //Deletebtn.setVisible(true);
        //Editbtn.setVisible(true);
        
        try{
            //JOptionPane.showMessageDialog(null, "Working");
            int row = Table_Info.getSelectedRow();
            String Table_click = (Table_Info.getModel().getValueAt(row, 0).toString());
            String sql = "Select * from StockInfo where ItemId =' "+Table_click+ "' ";
             ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            if(rs.next()){
            String addID = rs.getString("ItemID");
            IDF.setText(addID);
                
           String addItem = rs.getString("Item");
           ItemF.setText(addItem);
           
              String addQuantity = rs.getString("Quantity");
            QuantityF.setText(addQuantity);
            
            String addPrice = rs.getString("Price");
            PriceF.setText(addPrice);
             
            String addWeaver = rs.getString("Weaver");
           WeaverF.setText(addWeaver);
            
          
            
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
        
    }//GEN-LAST:event_Table_InfoMouseClicked

    private void Table_InfoMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Table_InfoMouseReleased
        // TODO add your handling code here:
       //  Deletebtn.setVisible(false);
      //  Editbtn.setVisible(false);
    }//GEN-LAST:event_Table_InfoMouseReleased

    private void DeletebtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeletebtnActionPerformed
        // TODO add your handling code here:
      int boolvar =  JOptionPane.showConfirmDialog(null, "Confirm deletion. " , "Deletion",JOptionPane.YES_NO_OPTION);
                String sql = "delete from StockInfo where ItemId = ?";
         if(boolvar == 0){

        try{
            ps  =conn.prepareStatement(sql);
            ps.setString(1, IDF.getText());
                    
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
        
    }//GEN-LAST:event_DeletebtnActionPerformed
         else{ JOptionPane.showMessageDialog(null, "Deletion cancelled");}
    }
    private void ClearbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ClearbtnActionPerformed
        // TODO add your handling code here:
        Clear_Screen();
        
    }//GEN-LAST:event_ClearbtnActionPerformed

    private void ItemFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ItemFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ItemFActionPerformed

    private void searchFKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchFKeyReleased
        // TODO add your handling code here:
        searchItem();
    }//GEN-LAST:event_searchFKeyReleased

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
            java.util.logging.Logger.getLogger(StockScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(StockScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(StockScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(StockScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new StockScreen().setVisible(true);
                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Addbtn;
    private javax.swing.JButton Backbtn;
    private javax.swing.JButton Clearbtn;
    private javax.swing.JButton Deletebtn;
    private javax.swing.JButton Editbtn;
    private javax.swing.JTextField IDF;
    private javax.swing.JTextField ItemF;
    private javax.swing.JTextField PriceF;
    private javax.swing.JTextField QuantityF;
    private javax.swing.JTable Table_Info;
    private javax.swing.JTextField WeaverF;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSplitPane jSplitPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTextField searchF;
    // End of variables declaration//GEN-END:variables
}
