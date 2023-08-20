package com.yaruf.api.yarufood.yarufoodapi.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ClientResponseDTO {
    public String code;
    public String message;
}
