/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package InvoiceDemo;

/**
 *
 * @author PC-User
 */
public class InvoiceDemo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

         Customer customer1 = new Customer(101, "Kenric Clarke", "KenricClarke@gmai.com");
        Customer customer2 = new Customer(102, "Demario Lennon", "Lennon@gmail.com");


        Invoice invoice1 = new Invoice(1, customer1, 150.75);
        Invoice invoice2 = new Invoice(2, customer2, 99.99);


        customer1.addInvoice(invoice1);
        customer2.addInvoice(invoice2);



        customer1.display();

        customer2.display();
    }
    
}
// the purpose of this program is to create an invoice for customers


/*Both classes have a "has a" relationship with invoice meaning that they're
bound together*/