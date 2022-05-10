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
import com.itextpdf.text.Document;

import com.itextpdf.*;
import com.itextpdf.text.Paragraph;

import java.sql.*;
import javax.swing.*;
import java.util.Date;
import java.text.*;
import java.awt.*;

import com.itextpdf.text.pdf.PdfWriter;


import net.proteanit.sql.DbUtils;
import java.io.FileOutputStream;

public class testReport {
    static int i =2;
     public static void printPdf(){
     
     
    Document doc = new Document();
    try{
    PdfWriter.getInstance(doc, new FileOutputStream(i+ "report.pdf"));
    doc.open();
    
    doc.add(new Paragraph("Bill Report man hoola"));
            
    doc.close();
    i++;
    
    
    }
    catch(Exception e){
    
    
    }
            }
     public static void main(String args[]){
        // printPdf();
         System.out.println("fe");
     
     }
}
