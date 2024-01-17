package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "book")
@Data
public class BookEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "book_id", nullable = false)
    private Long bookId;
    @Column(name = "name", nullable = false)
    private String name;
    @Column(name = "isbn", nullable = false)
    private String ISBN;
    @Column(name = "image", nullable = false)
    private String image;
}
