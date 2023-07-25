package com.yaruf.api.yarufood.yarufoodapi.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ClientDTO {
    private String cpf;
    private String email;
    private String name;
    private String ddd;
    private String phone_number;
}
