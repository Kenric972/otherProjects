/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package InvoiceDemo;

/**
 *
 * @author PC-User
 */
public class Invoice {
    private int id;
    private double amount;
    Customer customer; //this is a customer object (Composition Relationship)
    
    Invoice(int id,Customer customer ,double amount){
        this.amount = amount;
        this.customer = customer;
        this.id = id;
    }
    
    public int getID(){
        return id;
    }
    
    public void setID(int id){
        this.id = id;
}
    public double getAmount(){
        return amount;
    }
    public void setAmount(double amount){
        this.amount = amount;
    }
    
    public void setCustomer(Customer customer){
        this.customer = customer;
    }
    
    public Customer getCustomer(){
        return customer;
    }
    
    public void display(){  // A function created to display the customer and invoice information
        System.out.println("Invoice ID: "+id);
        System.out.println("Customer: "+customer.getCustName() + "("+customer.getCusEmail() + ")");
        System.out.println("Amount: $"+amount);
           
       }
                
    }

