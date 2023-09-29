package com.ap.store.shopping.client;

import com.ap.store.shopping.model.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping(value = "/products")
@FeignClient(name="product-service")
public interface ProductClient {

 		@GetMapping(value = "/{id}")
    public ResponseEntity<Product> getProduct(@PathVariable("id") Long id);

      @GetMapping(value="/{id}/stock")
    public ResponseEntity<Product> updateStock(@PathVariable("id") Long id,@RequestParam(name="quantity", required = true) Double quantity);
}
