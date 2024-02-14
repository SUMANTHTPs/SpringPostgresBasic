package org.sumanthtp;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductDB {
    Connection conn = null;

    public ProductDB() {
        try {
            conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/learn1", "postgres","1998");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void save(Product p) {
        String query = "insert into product (name, type, place, warranty) values (?,?,?,?)";

        try {
            PreparedStatement st = conn.prepareStatement(query);
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
        List<Product> prods = new ArrayList<>();
        String query = "select name, type, place, warranty from product";

        try {
            PreparedStatement st = conn.prepareStatement(query);
            ResultSet rs = st.executeQuery();
            while(rs.next()) {
                Product p = new Product();
                p.setName(rs.getString(1));
                p.setType(rs.getString(2));
                p.setPlace(rs.getString(3));
                p.setWarranty(rs.getInt(4));
                prods.add(p);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return prods;
    }

    public Product getProduct(String name) {
        String query = "select name, type, place, warranty from product where name=?";
        try {
            PreparedStatement st = conn.prepareStatement(query);
            st.setString(1, name);
            ResultSet rs = st.executeQuery();
            if(rs.next()) {
                Product p = new Product();
                p.setName(rs.getString(1));
                p.setType(rs.getString(2));
                p.setPlace(rs.getString(3));
                p.setWarranty(rs.getInt(4));
                return p;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    public List<Product> getWarrantyProducts() {
        List<Product> ls = new ArrayList<>();
        String query = "select name, type, place, warranty from product where warranty > date_part('year', now())";

        try {
            PreparedStatement st = conn.prepareStatement(query);
            ResultSet rs = st.executeQuery();
            while(rs.next()) {
                Product p = new Product();
                p.setName(rs.getString(1));
                p.setType(rs.getString(2));
                p.setPlace(rs.getString(3));
                p.setWarranty(rs.getInt(4));
                ls.add(p);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return ls;
    }

    public List<Product> searchText(String search) {
        List<Product> prods = new ArrayList<>();
        String query = "SELECT name, type, place, warranty FROM product WHERE LOWER(name) = ? OR LOWER(type) = ? OR LOWER(place) = ?";

        try {
            PreparedStatement st = conn.prepareStatement(query);
            st.setString(1, search);
            st.setString(2,search);
            st.setString(3,search);
            ResultSet rs = st.executeQuery();
            while(rs.next()) {
                Product p = new Product();
                p.setName(rs.getString(1));
                p.setType(rs.getString(2));
                p.setPlace(rs.getString(3));
                p.setWarranty(rs.getInt(4));
                prods.add(p);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return prods;
    }
}
