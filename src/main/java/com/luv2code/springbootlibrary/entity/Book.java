package com.luv2code.springbootlibrary.entity;

import lombok.Data;
import jakarta.persistence.*;

@Entity
@Table(name="Book")
@Data

public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    
    @Column(name="id")
    private Long id;

    @Column(name="title")
    private String title;

    @Column(name="author")
    private String author;

    @Column(name="description")
    private String dscription;

    @Column(name="copies")
    private int copies;

    @Column(name="copies_available")
    private int copiesAvailable;

    @Column(name ="category")
    private String category;

    @Column(columnDefinition = "TEXT")
    private String img;


}
