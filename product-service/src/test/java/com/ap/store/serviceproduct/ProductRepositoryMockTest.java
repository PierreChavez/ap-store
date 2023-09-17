package com.ap.store.serviceproduct;

import com.ap.store.serviceproduct.entity.Category;
import com.ap.store.serviceproduct.entity.Product;
import com.ap.store.serviceproduct.repository.ProductRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Date;
import java.util.List;

@DataJpaTest
public class ProductRepositoryMockTest {

    @Autowired
    private ProductRepository productRepository;

    @Test
    public void whenFindByCategory_thenReturnListProduct() {
        Product product = Product.builder()
                .name("Mac Mini")
                .category(Category.builder().id(1L).build())
                .description("")
                .stock(Double.parseDouble("10"))
                .price(Double.parseDouble("1200.00"))
                .status("Created")
                .createdAt(new Date()).build();

        productRepository.save(product);

        List<Product> productList = productRepository.findByCategory(product.getCategory());

        Assertions.assertThat(productList.size()).isEqualTo(2);

    }
}
