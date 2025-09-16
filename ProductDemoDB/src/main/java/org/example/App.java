package org.example;

import java.util.List;

/**
 * Hello world!
 *
 */
public class App
{
    public static void main( String[] args )
    {
        Service service = new Service();

        System.out.println("=======================================================");
        System.out.println("A particular product: ");
        service.getProduct("MacBook Pro");


        System.out.println("====================================================");
        System.out.println("Products containing a certain word");
        // Fetch products containing "Desk"
        List<Product> results = service.getProductWithText("black");
        results.forEach(System.out::println);


    }
}
