package com.example.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;

/**
 * @author Suxrob Sattorov, Thu 8:50 AM. 10/20/2022
 */

@Getter
@Setter
@Entity
public class Davomat {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Boolean exists = false;

    private LocalDateTime createdAt = LocalDateTime.now();

    private Long studentId;

}
