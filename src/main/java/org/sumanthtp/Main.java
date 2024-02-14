package org.sumanthtp;


import java.util.List;

public class Main {
    public static void main(String[] args) {
        ProductService service = new ProductService();
//        service.addProduct(new Product("Laptop", "Computer", "Table", 2020));
//        service.addProduct(new Product("Iphone", "Smart phone", "Table", 2024));
//        service.addProduct(new Product("C type cable", "Wire", "Brown table", 2026));
//        service.addProduct(new Product("Headphones", "Accessories", "Drawer", 2028));
//        service.addProduct(new Product("Tablet", "Electronics", "Table", 2023));
//        service.addProduct(new Product("Mouse", "Accessories", "Wrist", 2026));
//        service.addProduct(new Product("Bluetooth Speaker", "Electronics", "Shelf", 2027));
//        service.addProduct(new Product("USB Flash Drive", "Accessories", "Drawer", 2020));
//        service.addProduct(new Product("Wireless Mouse", "Accessories", "Desk", 2023));
//        service.addProduct(new Product("Portable Mouse", "Accessories", "Bag", 2022));
//        service.addProduct(new Product("External Hard Drive", "Electronics", "Desk", 2024));

        System.out.println("=======================================================================================");
        System.out.println("All products");
        List<Product> ps = service.getProducts();
        for(Product prod : ps) {
            System.out.println(prod);
        }

        System.out.println("=======================================================================================");
        System.out.println("A particular product");
        Product p = service.getProduct("Bluetooth Speaker");
        System.out.println(p);

        System.out.println("=======================================================================================");
        System.out.println("A particular text");

        List<Product> prods = service.getProductWithText("Mouse");
        for(Product prod : prods) {
            System.out.println(prod);
        }

        System.out.println("=======================================================================================");
        System.out.println("Warranty products");
        prods = service.getWarrantyProducts();
        for(Product prod : prods) {
            System.out.println(prod);
        }
    }
}
