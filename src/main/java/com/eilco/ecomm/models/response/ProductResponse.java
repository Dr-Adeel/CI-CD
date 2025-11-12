package com.eilco.ecomm.models.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProductResponse {
    Long id;
    String name;
    private BigDecimal price;
    private String description;
    private LocalDateTime updatedAt;
    private Long categoryId;
}
