package com.yaruf.api.yarufood.yarufoodapi.service;

import com.fasterxml.jackson.databind.JsonMappingException;
import com.yaruf.api.yarufood.yarufoodapi.dto.ClientDTO;
import com.yaruf.api.yarufood.yarufoodapi.dto.ClientResponseDTO;
import com.yaruf.api.yarufood.yarufoodapi.entity.Client;

import java.util.List;

public interface ClientService {
    ClientDTO findById(String cpf);
    List<ClientDTO> findAll();

    ClientResponseDTO updateByCpf(Client client) throws JsonMappingException;
}
