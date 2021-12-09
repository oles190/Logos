package com.shop.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data@
NoArgsConstructor
public class CartNodeDTO {

  private   ProductDTO productDTO;
    private Long count;
}
