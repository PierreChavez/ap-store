package com.ap.store.shopping.client;

import com.ap.store.shopping.model.Customer;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class CustomerFallback implements CustomerClient {


    @Override
    public ResponseEntity<Customer> getCustomer(long id) {

        Customer customer = Customer.builder()
                .email("none")
                .firstName("none")
                .lastName("none")
                .photoUrl("none")
                .build();
        return ResponseEntity.ok(customer);
    }
}


