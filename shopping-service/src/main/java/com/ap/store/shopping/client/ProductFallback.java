package com.ap.store.shopping.client;

import com.ap.store.shopping.model.Customer;
import com.ap.store.shopping.model.Product;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class ProductFallback implements ProductClient{
    @Override
    public ResponseEntity<Product> getProduct(Long id) {
        Product product = Product.builder()
                .description("none")
                .name("none")
                .status("none")
                .build();

        return ResponseEntity.ok(product);
    }

    @Override
    public ResponseEntity<Product> updateStock(Long id, Double quantity) {
        return null;
    }
}
