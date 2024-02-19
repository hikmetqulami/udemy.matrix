package com.UdemyProject.Udemy.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "cousrses")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String description;

    @Column(nullable = false, precision = 6, scale = 2)
    @Min(1)
    private BigDecimal price;

    @Column(precision = 3, scale = 1, nullable = false)
    @DecimalMax("5.0")
    private BigDecimal rating;

    private String language;
    private String author;
    private LocalDateTime dateOfCreated;


    @ColumnDefault(value = "FALSE")
    @Column(nullable = false)
    private Boolean isFeatured = false;


}

