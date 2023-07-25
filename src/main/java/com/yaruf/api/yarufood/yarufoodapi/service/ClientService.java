package com.yaruf.api.yarufood.yarufoodapi.service;

import com.yaruf.api.yarufood.yarufoodapi.dto.ClientDTO;

import java.util.List;

public interface ClientService {
    ClientDTO findById(String cpf);
    List<ClientDTO> findAll();
}
