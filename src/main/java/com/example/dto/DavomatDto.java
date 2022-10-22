package com.example.dto;

import lombok.Builder;
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
    private Boolean exists1;
    private Boolean exists2;
    private Boolean exists3;
    private Boolean exists4;
    private Boolean exists5;
    private LocalDateTime createdAt;
    private Long studentId;
}
