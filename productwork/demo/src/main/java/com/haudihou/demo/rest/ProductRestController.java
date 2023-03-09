package com.haudihou.demo.rest;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import Data.Product;
import com.haudihou.demo.service.ProductService;

@RestController
public class ProductRestController {

    ProductService pc;

    @Autowired
    public ProductRestController(ProductService pc) {
        this.pc = pc;
    }

    @GetMapping("/products")
    public List<Product> getProducts() {
        return pc.getProducts();
    }

    @GetMapping("/total")
    public Map<String, Object> getTotal() {
        return pc.getOverallInfo();
    }

    @PostMapping("/product")
    public String addProduct(@RequestBody Product product) {
        pc.addProduct(product);
        return "Product added";
    }

    @DeleteMapping("/delproduct")
    public String deleteProduct(@RequestBody Product product){
        pc.deleteProduct(product.getId());
        return "Product deleted";
    }

    @GetMapping("/product/{id}")
    public ResponseEntity<Product> getProduct(@PathVariable int id) {
        Product p = pc.searchProduct(id);

        if (p != null) {
            return new ResponseEntity<>(p, HttpStatus.OK);
        } 

            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    

