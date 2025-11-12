package com.eilco.ecomm.models.response;

import com.eilco.ecomm.repositories.entities.Category;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class CategoryResponse {
    Long id;
    String name;
}
