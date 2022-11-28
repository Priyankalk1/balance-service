package com.maveric.balanceservice.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import java.util.Map;

@Getter
@Setter
@NoArgsConstructor
public class ErrorDto {
    String code;
    String message;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    Map<String, String> errors;
}
