package com.ap.store.shopping.client;

import com.ap.store.shopping.model.Customer;
import io.github.resilience4j.circuitbreaker.CallNotPermittedException;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "customer-service", path = "/customers", fallback = CustomerFallback.class)
public interface CustomerClient {

    @GetMapping(value = "/{id}")
    public ResponseEntity<Customer> getCustomer(@PathVariable("id") long id);

}
