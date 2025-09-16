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

        service.addProduct(new Product("Asus Vivobook", "laptop", "Brown Table", 2022));
        service.addProduct(new Product("HP Pavilion", "laptop", "Wooden Desk", 2021));
        service.addProduct(new Product("Dell Inspiron", "laptop", "Glass Table", 2023));
        service.addProduct(new Product("Lenovo IdeaPad", "laptop", "White Shelf", 2020));
        service.addProduct(new Product("MacBook Pro", "laptop", "Metal Rack", 2022));
        service.addProduct(new Product("Acer Aspire", "laptop", "Office Desk", 2023));
        service.addProduct(new Product("MSI GF63", "laptop", "Black Counter", 2021));
        service.addProduct(new Product("Samsung Galaxy Book", "laptop", "Gaming Desk", 2022));
        service.addProduct(new Product("LG Gram", "laptop", "Reception Table", 2023));
        service.addProduct(new Product("Razer Blade", "laptop", "Green Stand", 2022));
        service.addProduct(new Product("Microsoft Surface Laptop", "laptop", "Study Table", 2024));

        List<Product> products = service.getAllProducts();


        System.out.println("=======================================================");
        System.out.println("A particular product: ");

        Product p = service.getProduct("MacBook Pro");
        System.out.println(p);

        System.out.println("=======================================================");
        System.out.println("A particular text");
        List<Product>prods = service.getProductWithText("black");

        for(Product product: prods){
            System.out.println(product);
        }

    }
}
