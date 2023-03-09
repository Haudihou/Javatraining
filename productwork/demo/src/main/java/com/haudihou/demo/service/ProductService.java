package com.haudihou.demo.service;

import java.util.ArrayList;
import java.util.HashMap;
//import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import Data.Product;

@Service
public class ProductService {
    private List<Product> products = new ArrayList<>();

    public ProductService() {

            products.add(new Product(0, "Laptop", 1000));
            products.add(new Product(1, "Mouse", 50));
            products.add(new Product(2, "Keyboard", 100));
            products.add(new Product(3, "Monitor", 200));
            products.add(new Product(4, "Headphones", 150));
        
    }

//Lisää tuotteen

    public void addProduct(Product product){
        products.add(product);
    }

//Palauttaa tuotteen

    public List<Product> getProducts(){
        return new ArrayList<>(products);
    }

//Tuotteen hakeminen

    public Product searchProduct(int id){
        for (Product product : products) {
            if(product.getId() == id){
                return product;
            }
        }
        return null;
    }

//Tuotteen poistaminen

    public boolean deleteProduct(int id){
        Product p = searchProduct(id);

        if(p != null){
            return products.remove(p);
        }

        return false;
    }

    public Map<String, Object> getOverallInfo(){

        Map<String,Object> info = new HashMap<>();

        info.put("count", products.size());

        double price = 0;
        for (Product product : products) {
            price += product.getPrice();
        }

        info.put("totalPrice", price);

        return info;
    }

}
