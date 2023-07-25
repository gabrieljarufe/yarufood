package com.yaruf.api.yarufood.yarufoodapi.service.impl;

import com.yaruf.api.yarufood.yarufoodapi.dto.ClientDTO;
import com.yaruf.api.yarufood.yarufoodapi.entity.Client;
import com.yaruf.api.yarufood.yarufoodapi.exception.BusinessException;
import com.yaruf.api.yarufood.yarufoodapi.mapper.ClientDTOMapper;
import com.yaruf.api.yarufood.yarufoodapi.repository.ClientRepository;
import com.yaruf.api.yarufood.yarufoodapi.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ClientServiceImpl implements ClientService {

    @Autowired
    ClientRepository clientRepository;

    @Override
    public ClientDTO findById(String cpf) {
        Optional<Client> clientOptional = Optional.ofNullable(clientRepository.findByCpf(cpf));
        ClientDTO client;
        if (clientOptional.isPresent()) {
            client = ClientDTOMapper.toFormatClient(clientOptional.get());
        } else {
            throw new BusinessException(HttpStatus.NOT_FOUND, "Client could not be found with CPF");
        }
        return client;
    }

    @Override
    public List<ClientDTO> findAll() {
        List<ClientDTO> clientDTOList = clientRepository.findAllClients();
        if (clientDTOList.size() == 0) {
            throw new BusinessException(HttpStatus.NOT_FOUND, "Client could not be found with CPF");
        }
        return clientDTOList;
    }

}
