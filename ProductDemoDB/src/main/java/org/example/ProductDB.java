package org.example;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductDB {

    Connection con = null;

    public ProductDB(){
        try {
            con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Products_Demo", "postgres", "beigehawk21");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void Save(Product p) {
        String query = "insert into product (name, type, place, warranty) values(?,?,?,?)";
        try {
            PreparedStatement st = con.prepareStatement(query);
           st.setString(1, p.getName());
            st.setString(2, p.getType());
            st.setString(3, p.getPlace());
            st.setInt(4, p.getWarranty());
            st.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Product> getAll() {
        List<Product> products = new ArrayList<>();

        String query = "select name, type, place, warranty from product";
        try {
            PreparedStatement st = con.prepareStatement(query);
          ResultSet rs = st.executeQuery();

          while(rs.next()){
              Product p = new Product();
              p.setName(rs.getString(1));
              p.setType(rs.getString(2));
              p.setPlace(rs.getString(3));
              p.setWarranty(rs.getInt(4));
              products.add(p);
          }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return products;
    }


    // Get product by exact name
    public Product getExactProduct(String name) {
        String query = "SELECT name, type, place, warranty FROM product WHERE LOWER(name) = ?";
        try {
            PreparedStatement st = con.prepareStatement(query);
            st.setString(1, name.toLowerCase().trim());
            ResultSet rs = st.executeQuery();

            if (rs.next()) {
                Product p = new Product();
                p.setName(rs.getString("name"));
                p.setType(rs.getString("type"));
                p.setPlace(rs.getString("place"));
                p.setWarranty(rs.getInt("warranty"));
                return p;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    // Search products by text in name, type, or place
    public List<Product> getProductsByText(String text) {
        List<Product> products = new ArrayList<>();
        String query = "SELECT name, type, place, warranty FROM product " +
                "WHERE LOWER(name) LIKE ? OR LOWER(type) LIKE ? OR LOWER(place) LIKE ?";

        try {
            PreparedStatement st = con.prepareStatement(query);
            String search = "%" + text.toLowerCase().trim() + "%";
            st.setString(1, search);
            st.setString(2, search);
            st.setString(3, search);

            ResultSet rs = st.executeQuery();

            while (rs.next()) {
                Product p = new Product();
                p.setName(rs.getString("name"));
                p.setType(rs.getString("type"));
                p.setPlace(rs.getString("place"));
                p.setWarranty(rs.getInt("warranty"));
                products.add(p);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return products;
    }

}
