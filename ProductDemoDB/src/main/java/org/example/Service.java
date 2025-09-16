package org.example;

import java.util.ArrayList;
import java.util.List;

public class Service {

    List<Product> products = new ArrayList<>();
     ProductDB db = new ProductDB();

    public void addProduct(Product p){
       // products.add(p);
        db.Save(p);
    }

    public List<Product>getAllProducts(){
        return db.getAll();
    }


    // Get a single product by exact name
    public Product getProduct(String name) {
        return db.getExactProduct(name);
    }

    // Get products containing text in name, type, or place
    public List<Product> getProductWithText(String text) {
        return db.getProductsByText(text);
    }


}
