package com.example.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * @author Suxrob Sattorov, Mon 11:03 AM. 10/10/2022
 */

@Getter
@Setter
@Entity
public class Student {

    @Id
    @GeneratedValue( strategy = GenerationType.AUTO )
    private Long id;

    @Column( nullable = false )
    private String name;

    @Column( nullable = false )
    private String surname;

    private LocalDateTime createdAt = LocalDateTime.now();

}
