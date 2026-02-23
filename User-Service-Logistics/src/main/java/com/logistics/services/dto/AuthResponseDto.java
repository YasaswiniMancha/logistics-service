package com.logistics.services.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AuthResponseDto {
    private String accessToken;
    private String refreshToken;
    private String tokenType;
    private Long userId;
  //  private String 
}
