package com.ap.store.serviceproduct;

import com.ap.store.serviceproduct.entity.Category;
import com.ap.store.serviceproduct.entity.Product;
import com.ap.store.serviceproduct.repository.ProductRepository;
import com.ap.store.serviceproduct.service.ProductService;
import com.ap.store.serviceproduct.service.ProductServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.Optional;

@SpringBootTest
public class ProductServiceMockTest {

    @Mock
    private ProductRepository productRepository;

    private ProductService productService;

    Product product = Product.builder()
            .id(1L)
            .name("Mac Pro")
            .category(Category.builder().id(1L).build())
            .description("")
            .stock(Double.parseDouble("10"))
            .price(Double.parseDouble("2200.00"))
            .status("CREATED")
            .createdAt(new Date()).build();

    @BeforeEach
    public void setup(){
        MockitoAnnotations.openMocks(this);
        productService = new ProductServiceImpl(productRepository);

        Mockito.when(productRepository.findById(1L))
                .thenReturn(Optional.of(product));

        Mockito.when(productRepository.save(product)).thenReturn(product);
    }

    @Test
    public void whenValidGetById_thenReturnProduct(){
        Product found = productService.getProduct(1L);

        Assertions.assertThat(found.getName()).isEqualTo(product.getName());
    }

    @Test
    public void whenValidUpdateStock_thenReturnNewStock(){
        Product newStock = productService.updateStock(1L, Double.parseDouble("1"));

        Assertions.assertThat(newStock.getStock()).isEqualTo(Double.parseDouble("11"));

    }
}
