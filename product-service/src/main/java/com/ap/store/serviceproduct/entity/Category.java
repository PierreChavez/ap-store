package com.ap.store.serviceproduct.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="category")
@Data @AllArgsConstructor @NoArgsConstructor @Builder
public class Category {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;



}
