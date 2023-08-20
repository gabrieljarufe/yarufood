package com.yaruf.api.yarufood.yarufoodapi.mapper;

import com.yaruf.api.yarufood.yarufoodapi.dto.ClientDTO;
import com.yaruf.api.yarufood.yarufoodapi.entity.Client;

public class ClientDTOMapper {
    public static ClientDTO toFormatClient(Client client){
        return ClientDTO.builder()
                .email(client.getEmail())
                .cpf(client.getCpf())
                .phone_number(client.getContact().getPhoneNumber())
                .ddd(client.getContact().getDdd())
                .name(client.getName())
                .build();
    }
}
