package com.example.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

/**
 * @author Suxrob Sattorov, Thu 8:47 AM. 10/20/2022
 */

@Getter
@Setter
public class DavomatDto {
    private Long id;
    private String studentName;
    private String studentSurname;
    private Boolean exists;
    private LocalDateTime createdAt;
    private Long studentId;
}
