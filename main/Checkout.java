/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business_application_ia;

/**
 * 
 * !"£$%^&*()-_+=#~'@;:.>,<  ecfecf
 * @author Parv < greater sign can be used to change the comment colour.
 * vfv
 * 
 */
import com.itextpdf.text.Document;

import com.itextpdf.*;
import com.itextpdf.text.Paragraph;

import java.sql.*;
import javax.swing.*;
import java.util.Date;
import java.text.*;
import java.awt.*;
import java.text.SimpleDateFormat;
import com.itextpdf.text.pdf.PdfWriter;


import net.proteanit.sql.DbUtils;
import java.io.FileOutputStream;

public class Checkout extends javax.swing.JFrame {

    /**
     * Creates new form Checkout
     */
      Connection conn = null;
    ResultSet rs = null;
    PreparedStatement ps = null;
     Date dt = new Date();
        String date = dt.toString();
         String timing = date;
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    String strdate = sdf.format(dt);
    public Checkout() {
        initComponents();
        conn = JavaConnect.ConnecrDb();
          Toolkit tk = getToolkit();
         Dimension size = tk.getScreenSize();
         setLocation(size.width/2- getWidth()/2, size.height/2 - getHeight()/2);
        FillComboBox();
      FillItemBox();
      fillQtyBox();
      getSalesID();
      SalesIDF.setEditable(false);
       
        
        

    }
    public void FillComboBox(){
    
    try {
        String sql = "Select * from CustomerInfo" ;   
        ps = conn.prepareStatement(sql);
        rs = ps.executeQuery();
        while(rs.next()){
       String Customername = rs.getString("CustomerName");
          Customer_Combo.addItem(Customername);
        

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
    // __________________________________________________
    }
    private void FillItemBox(){
        
     try {
        String sql = "Select * from StockInfo" ;   
        ps = conn.prepareStatement(sql);
        rs = ps.executeQuery();
        while(rs.next()){
       String ItemName = rs.getString("Item");
        ItemBox.addItem(ItemName);
         }
        
                
                }
    catch(Exception e){
    JOptionPane.showMessageDialog(null, "FillItembox function error place");
        
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
    
    private void fillQtyBox(){
    try{
               String selectedValue = ItemBox.getSelectedItem().toString();
               String query1 = "Select Quantity from StockInfo where Item like '"+selectedValue+"'";
               ps = conn.prepareStatement(query1);
               rs = ps.executeQuery();
               String storedValue = rs.getString("Quantity");
               int qty = Integer.parseInt(storedValue);
               for(int i = 1; i <= qty; i++){
                String qty_str = Integer.toString(i);    
               Quantity_Box.addItem(qty_str);
               
               }
               
         }
         catch(Exception e)
          {
         // JOptionPane.showMessageDialog(null,  e);
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
    private void getSalesID(){
        try{
    String query = "SELECT * FROM SalesInfo  WHERE SalesID=(SELECT max(SalesID) FROM SalesInfo);";
    ps = conn.prepareStatement(query);
    rs = ps.executeQuery();
    String SalesID = rs.getString("SalesID");
     int salesID = Integer.parseInt(SalesID);
     salesID = salesID +1;
     SalesID = String. valueOf(salesID);
     
        SalesIDF.setText(SalesID);
        }
        catch(Exception e){
        JOptionPane.showMessageDialog(null,  e + " This is the error place the new getID method");
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
    private void modifyStockInfo(){
        int qty_stock;
        int qty_selected;
        int left_stock;
        try{
   String selectedValue = ItemBox.getSelectedItem().toString();
               String query1 = "Select Quantity from StockInfo where Item like '"+selectedValue+"'";
               ps = conn.prepareStatement(query1);
               rs = ps.executeQuery();
               String storedValue = rs.getString("Quantity");
                qty_stock = Integer.parseInt(storedValue);
                
                String qty =  Quantity_Box.getSelectedItem().toString();
            qty_selected = Integer.parseInt(qty);
             left_stock = qty_stock - qty_selected;
             String item_id = ItemIDv.getText();
             System.out.println("Left stock is " + left_stock);
             System.out.println("This statment is happenig");
             System.out.println("This is the item id" + item_id);
             
             String sql = "update StockInfo set  Quantity = '"+left_stock+"' where ItemId= '"+item_id+"'  ";
             ps = conn.prepareStatement(sql);
       
              ps.execute();
            
               
    
    } catch(Exception e){
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
    private void addToSalesInfo(){
       String onePrice = "42018";
       String itmname = ItemBox.getSelectedItem().toString();
        try{
            String qy = " Select Price from StockInfo where Item = '"+itmname+"'";
             ps = conn.prepareStatement(qy);
             rs = ps.executeQuery();
             onePrice = rs.getString("Price");
             
       } 
        catch(Exception e){
        JOptionPane.showMessageDialog(null, "New code error addtoSalesInfo : " +e);
        
        } 
    System.out.println("Parv");
     try{
            String sql = "Insert into SalesInfo(SalesID,ItemName, ItemPrice, ItemQuantity,TotalPrice,CustomerName, PaymentStatus, LeftAmount,Date) values (?,?,?,?,?,?,?,?,?) ";
            String Customer_name = Customer_Combo.getSelectedItem().toString();
                String Item_name = ItemBox.getSelectedItem().toString();
                String quantity = Quantity_Box.getSelectedItem().toString();
                String price = PriceF.getText();
                String Status = Status_Box.getSelectedItem().toString();
                String Left = paidF.getText();
                
            ps = conn.prepareStatement(sql);
            ps.setString(1, SalesIDF.getText());
            ps.setString(2, Item_name);
           
            ps.setString(3, onePrice);
            ps.setString(4, quantity);
            ps.setString(5, PriceF.getText());
            ps.setString(6, Customer_name);
            ps.setString(7, Status);
            ps.setString(8, Left);
            ps.setString(9,strdate);
            
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
    }
    private void printPdf(){
        Date dt = new Date();
        String date = dt.toString();
         String timing = date;
    Document doc = new Document();
           String selectedValue = Customer_Combo.getSelectedItem().toString();
           String selectedItem = ItemBox.getSelectedItem().toString();
           String quantity = Quantity_Box.getSelectedItem().toString();
           

    try{
    PdfWriter.getInstance(doc, new FileOutputStream(selectedValue   +" Bill Report.pdf"));
    doc.open();
      doc.addTitle("BILL REPORT");
          doc.add(new Paragraph("_________________________________________________________________________\n\n") );

    doc.add(new Paragraph( "Respected " +selectedValue+ ","+ "\n" + "This is a soft copy of your invoice."  ));
    
   doc.add(new Paragraph("The item you have bought is: " + selectedItem + "\n") );    
      doc.add(new Paragraph("The quantity is: " + quantity + "\n") );    
      doc.add(new Paragraph("The total price is: " + PriceF.getText()+ " rupees only " + "\n") );    
    doc.add(new Paragraph("_________________________________________________________________________\n\n") );
       doc.add(new Paragraph("                           THANK YOU FOR SHOPPING    \n") );

    doc.add(new Paragraph("_________________________________________________________________________\n\n") );

    doc.close();
    
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
            }
        
        
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        jTextField1 = new javax.swing.JTextField();
        Customer_Combo = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        IDv = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        ItemIDv = new javax.swing.JTextField();
        Backbtn = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        ItemBox = new javax.swing.JComboBox<>();
        CPbtn = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        Quantity_Box = new javax.swing.JComboBox<>();
        PriceF = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        calcbtn = new javax.swing.JButton();
        Printbtn = new javax.swing.JButton();
        generatebtn = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtArea = new javax.swing.JTextArea();
        clrbtn = new javax.swing.JButton();
        savePDFbtn = new javax.swing.JButton();
        Status_Box = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        paidF = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        SalesIDF = new javax.swing.JTextField();

        jButton1.setText("jButton1");

        jMenu1.setText("File");
        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        jTextField1.setText("jTextField1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Customer_Combo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Customer" }));
        Customer_Combo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Customer_ComboActionPerformed(evt);
            }
        });

        jLabel1.setText("Customer");

        jLabel2.setText("Item ID");

        IDv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IDvActionPerformed(evt);
            }
        });

        jLabel3.setText("Cusotmer ID:");

        ItemIDv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ItemIDvActionPerformed(evt);
            }
        });

        Backbtn.setText("Back");
        Backbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BackbtnActionPerformed(evt);
            }
        });

        jLabel4.setText("Item:");

        ItemBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Item" }));
        ItemBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ItemBoxActionPerformed(evt);
            }
        });

        CPbtn.setText("Confirm Payment");
        CPbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CPbtnActionPerformed(evt);
            }
        });

        jLabel5.setText("Quantity:");

        Quantity_Box.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Quantity_BoxMouseClicked(evt);
            }
        });
        Quantity_Box.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Quantity_BoxActionPerformed(evt);
            }
        });

        PriceF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PriceFActionPerformed(evt);
            }
        });

        jLabel6.setText("Price:");

        calcbtn.setText("Calculate Prize");
        calcbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                calcbtnActionPerformed(evt);
            }
        });

        Printbtn.setText("Print Receipt");
        Printbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PrintbtnActionPerformed(evt);
            }
        });

        generatebtn.setText("Generate Receipt");
        generatebtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                generatebtnActionPerformed(evt);
            }
        });

        txtArea.setColumns(20);
        txtArea.setRows(5);
        jScrollPane2.setViewportView(txtArea);

        clrbtn.setText("Clear Receipt");
        clrbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clrbtnActionPerformed(evt);
            }
        });

        savePDFbtn.setText("Save PDF");
        savePDFbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                savePDFbtnActionPerformed(evt);
            }
        });

        Status_Box.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select status", "C", "IC" }));
        Status_Box.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Status_BoxMouseClicked(evt);
            }
        });
        Status_Box.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Status_BoxActionPerformed(evt);
            }
        });

        jLabel7.setText("Payment Status:");

        jLabel8.setText("Amount to be paid:");

        paidF.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                paidFMouseClicked(evt);
            }
        });
        paidF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                paidFActionPerformed(evt);
            }
        });

        jLabel9.setText("Sales ID:");

        SalesIDF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SalesIDFActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel8))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(19, 19, 19)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(Status_Box, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(PriceF, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(paidF)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(SalesIDF, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(0, 0, Short.MAX_VALUE))))))
                            .addComponent(CPbtn)
                            .addComponent(jLabel9)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(19, 19, 19)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel5)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(calcbtn)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(IDv, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(ItemBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(Customer_Combo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ItemIDv, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(Quantity_Box, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(generatebtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(Printbtn)
                        .addGap(12, 12, 12)
                        .addComponent(clrbtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(savePDFbtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Backbtn))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 499, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Customer_Combo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addGap(5, 5, 5)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(IDv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addGap(15, 15, 15)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(ItemBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(ItemIDv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(33, 33, 33)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(Quantity_Box, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(calcbtn)
                        .addGap(27, 27, 27)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(PriceF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Status_Box, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7)))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 331, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(clrbtn)
                    .addComponent(generatebtn)
                    .addComponent(Printbtn)
                    .addComponent(Backbtn)
                    .addComponent(savePDFbtn)
                    .addComponent(jLabel8)
                    .addComponent(paidF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(13, 13, 13)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(SalesIDF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(CPbtn)
                .addContainerGap(82, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ItemIDvActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ItemIDvActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_ItemIDvActionPerformed

    private void IDvActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IDvActionPerformed
        // TODO add your handling code here:
     
     
    }//GEN-LAST:event_IDvActionPerformed

    private void Customer_ComboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Customer_ComboActionPerformed
        // TODO add your handling code here:
          
        try{
       String selectedValue = Customer_Combo.getSelectedItem().toString();
        IDv.setText(selectedValue);
       String sql = "Select CustomerId from CustomerInfo where CustomerName like '"+selectedValue+"' ";
       ps = conn.prepareStatement(sql);
        rs = ps.executeQuery();
        String cusItemID = rs.getString("CustomerId");
        IDv.setText(cusItemID);
               
        }
        catch(Exception e){
           // JOptionPane.showMessageDialog(null,"This is where things are going wrong");
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
    }//GEN-LAST:event_Customer_ComboActionPerformed

    private void BackbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BackbtnActionPerformed
        // TODO add your handling code here:
        MainScreen ms = new MainScreen();
        ms.setVisible(true);
        this.setVisible(false);
        
    }//GEN-LAST:event_BackbtnActionPerformed

    private void ItemBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ItemBoxActionPerformed
        // TODO add your handling code here:
        try{
       String selectedValue = ItemBox.getSelectedItem().toString();
        ItemIDv.setText(selectedValue);
       String sql = "Select ItemId from StockInfo where Item like '"+selectedValue+"' ";
       ps = conn.prepareStatement(sql);
        rs = ps.executeQuery();
        String nameItemId = rs.getString("ItemId");
        ItemIDv.setText(nameItemId);
               
        }
        catch(Exception e){
           // JOptionPane.showMessageDialog(null,"This is where things are going wrong");
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
        
        
        
    }//GEN-LAST:event_ItemBoxActionPerformed

    private void Quantity_BoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Quantity_BoxActionPerformed
         // TODO add your handling code here:
         
       
    }//GEN-LAST:event_Quantity_BoxActionPerformed

    private void Quantity_BoxMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Quantity_BoxMouseClicked
        // TODO add your handling code here:
             Quantity_Box.removeAllItems();
                
                 fillQtyBox();

    }//GEN-LAST:event_Quantity_BoxMouseClicked

    private void PriceFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PriceFActionPerformed
        // TODO add your handling code here:
       
    }//GEN-LAST:event_PriceFActionPerformed

    private void calcbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_calcbtnActionPerformed
        // TODO add your handling code here:
        try{
           String selectedValue = ItemBox.getSelectedItem().toString();

            String query1 = "Select Price from StockInfo where Item like '"+selectedValue+"'";
             ps = conn.prepareStatement(query1);
        rs = ps.executeQuery();
            String Price = rs.getString("Price");
            
      String qty =  Quantity_Box.getSelectedItem().toString();
           int qty_num = Integer.parseInt(qty);
           int Price_num = Integer.parseInt(Price);
           int totalPrice = qty_num * Price_num;
         //  System.out.println(totalPrice);
           String str_totalPrice = Integer.toString(totalPrice);
          
            PriceF.setText(str_totalPrice);
            
        } catch(Exception e){}
        finally {
            try{
                rs.close();
                ps.close();
    
              }
            catch(Exception e) {
                   }
      } 
    }//GEN-LAST:event_calcbtnActionPerformed

    private void CPbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CPbtnActionPerformed
        // TODO add your handling code here:
     int boolvar =  JOptionPane.showConfirmDialog(null, "Confirm Payment. " , "Confirmation",JOptionPane.YES_NO_OPTION);
     if(boolvar == 0){
     
             modifyStockInfo();     
            addToSalesInfo();
             
     JOptionPane.showMessageDialog(null, " Payment confiremd");
     }
     else{     JOptionPane.showMessageDialog(null, " Payment cancelled");
}
        
    }//GEN-LAST:event_CPbtnActionPerformed
    
    
    private void generatebtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_generatebtnActionPerformed
        txtArea.setText("");
        
        txtArea.setText( "____________________________________________________________________\n\n");
        
       txtArea.setText(txtArea.getText() + "                                                            BILL RECEIPT\n");

         txtArea.setText(txtArea.getText() + "____________________________________________________________________\n");
                String Customer_name = Customer_Combo.getSelectedItem().toString();
                String Item_name = ItemBox.getSelectedItem().toString();
                String quantity = Quantity_Box.getSelectedItem().toString();
                String price = PriceF.getText();
                
        txtArea.setText(txtArea.getText() + "\n" + " DATE:      " + timing + "\n\n");
        
        txtArea.setText(txtArea.getText() + "                    "+ "CUSTOMER NAME:  " + Customer_name +"\n\n");
        txtArea.setText(txtArea.getText() +"                    "+  "ITEM NAME:  "  + Item_name + "\n\n");
        txtArea.setText(txtArea.getText() + "                    "+ "QUANTITY:  " + quantity + "\n\n");
        //txtArea.setText(txtArea.getText() + "                    "+ "It:  " + Item_name+"\n\n");
        txtArea.setText(txtArea.getText() +"                    "+  "PRICE:  " + price + "  Rupees " + "\n\n");
         txtArea.setText(txtArea.getText() + "____________________________________________________________________\n");
                txtArea.setText(txtArea.getText() + "                                                            THANKS FOR SHOPPING\n");
                         txtArea.setText(txtArea.getText() + "____________________________________________________________________\n");


         
    }//GEN-LAST:event_generatebtnActionPerformed

    private void clrbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clrbtnActionPerformed
        // TODO add your handling code here:
        txtArea.setText("");
          
       
        
    }//GEN-LAST:event_clrbtnActionPerformed

    private void PrintbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PrintbtnActionPerformed
        // TODO add your handling code here:
        try{
        txtArea.print();
        
        
        }
        catch(Exception e){
        }
    }//GEN-LAST:event_PrintbtnActionPerformed

    private void savePDFbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_savePDFbtnActionPerformed
        // TODO add your handling code here:
        printPdf();
        JOptionPane.showMessageDialog(null, "PDF saved!");
    }//GEN-LAST:event_savePDFbtnActionPerformed

    private void SalesIDFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SalesIDFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SalesIDFActionPerformed

    private void paidFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_paidFActionPerformed
        // TODO add your handling code here:
      
    }//GEN-LAST:event_paidFActionPerformed

    private void paidFMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_paidFMouseClicked
        // TODO add your handling code here:
          String sb = Status_Box.getSelectedItem().toString();
      //  System.out.println(sb);
        if(sb.contains("IC")){
        paidF.setEditable(true);
  
        }
        else{paidF.setEditable(false); paidF.setText("0");}
    }//GEN-LAST:event_paidFMouseClicked

    private void Status_BoxMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Status_BoxMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_Status_BoxMouseClicked

    private void Status_BoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Status_BoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Status_BoxActionPerformed

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
            java.util.logging.Logger.getLogger(Checkout.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Checkout.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Checkout.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Checkout.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Checkout().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Backbtn;
    private javax.swing.JButton CPbtn;
    private javax.swing.JComboBox<String> Customer_Combo;
    private javax.swing.JTextField IDv;
    private javax.swing.JComboBox<String> ItemBox;
    private javax.swing.JTextField ItemIDv;
    private javax.swing.JTextField PriceF;
    private javax.swing.JButton Printbtn;
    private javax.swing.JComboBox<String> Quantity_Box;
    private javax.swing.JTextField SalesIDF;
    private javax.swing.JComboBox<String> Status_Box;
    private javax.swing.JButton calcbtn;
    private javax.swing.JButton clrbtn;
    private javax.swing.JButton generatebtn;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField paidF;
    private javax.swing.JButton savePDFbtn;
    private javax.swing.JTextArea txtArea;
    // End of variables declaration//GEN-END:variables
}
