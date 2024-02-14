package org.sumanthtp;

import java.time.Year;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Stream;

public class ProductService {
    List<Product> products = new ArrayList<Product>();
    ProductDB db = new ProductDB();

    public void addProduct(Product p) {
//        products.add(p);
        db.save(p);
    }

    public List<Product> getProducts() {
        return db.getAll();
    }

    public Product getProduct(String name) {
//        for(Product p: products) {
//            if(p.getName().equals(name)) {
//                return p;
//            }
//        }
//            return products.stream()
//                    .filter(product -> product.getName().equals(name))
//                    .findFirst()
//                    .orElse(null);
        return db.getProduct(name);
    }

    public List<Product> getWarrantyProducts() {
//        List<Product> ls = new ArrayList<>();
//        Stream<Product> stream =  products.stream()
//                .filter(product -> product.getWarranty() > Year.now().getValue());
//        stream.forEach(ls::add);
        return db.getWarrantyProducts();
    }

    public List<Product> getProductWithText(String text) {
        String search = text.toLowerCase();
//        List<Product> prods = new ArrayList<>();
//        for(Product p: products) {
//            if(p.getName().toLowerCase().contains(search) ||p.getPlace().toLowerCase().contains(search) ||p.getType().toLowerCase().contains(search)) {
//                prods.add(p);
//            }
//        }
        return db.searchText(search);
    }
}
