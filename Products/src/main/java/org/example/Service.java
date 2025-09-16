package org.example;

import java.util.ArrayList;
import java.util.List;

public class Service {

    List<Product> products = new ArrayList<>();


    public void addProduct(Product p){
        products.add(p);
    }

    public List<Product>getAllProducts(){
        return products;
    }

    public Product getProduct(String name){
        for(Product p: products){
            if(p.getName().equals(name)){
                return p;
            }
        }
        return null;
    }

    public Product getPlace(String place){
        for(Product p: products){
            if(p.getPlace().equals(place)){
                return p;
            }
        }
        return null;
    }

    public Product getType(String type){
        for(Product p: products){
            if(p.getType().equals(type)){
                return p;
            }
        }
        return null;
    }

    public Product getWarranty(int warranty){
        for(Product p: products){
            if(p.getWarranty() == warranty){
                return p;
            }
        }
        return null;
    }

    public List<Product> getProductWithText(String text) {
        String str = text.toLowerCase();
        List<Product>prods = new ArrayList<>();

        for(Product p : products){
            String name = p.getName().toLowerCase();
            String type = p.getType().toLowerCase();
            String place = p.getPlace().toLowerCase();

            if(name.contains(text) || type.contains(text) || place.contains(text)){
                prods.add(p);
            }
        }

        return prods;
    }
}
