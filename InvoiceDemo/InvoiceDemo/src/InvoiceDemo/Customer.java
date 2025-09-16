/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package InvoiceDemo;

import java.util.ArrayList;

/**
 *
 * @author PC-User
 */
public class Customer {
    
   private int cusId;
   private String cusName;
   private String email;
   ArrayList<Invoice>invoices = new ArrayList<>();// arraylist with the class Invoice as its datatype is created
   
   Customer(int cusID,String cusName, String email){
       this.cusId = cusID;
       this.cusName = cusName;
       this.email = email;
   }
   

   public int getCusId(){
       return cusId;
   }
   
   public void setCusID(int cusId){
       this.cusId = cusId;
}
   
   public String getCustName(){
       return cusName;
   }
   
   public void setCusName(String cusName){
       this.cusName = cusName;
   }
   
   public String getCusEmail(){
       return email;
   }
   
   public void setCusEmail(String email){
       this.email = email;
   }
   
   
   public void addInvoice(Invoice invoice){
       invoices.add(invoice); // a new element is added to the arraylist
}

public void deleteInvoice(Invoice invoice){
       invoices.remove(invoice);
}

 public void display(){                          //the display function is used to output the information of the customers and invoices
       
       for(Invoice invoice: invoices){    // a for loop is used to iterate through the arraylist so that the information in it can be displayed using
           invoice.display();             // the display function from the Invoice class
       }
      
   }
   
}
