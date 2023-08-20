package com.yaruf.api.yarufood.yarufoodapi.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.yaruf.api.yarufood.yarufoodapi.dto.ClientDTO;
import com.yaruf.api.yarufood.yarufoodapi.dto.ClientResponseDTO;
import com.yaruf.api.yarufood.yarufoodapi.entity.Client;
import com.yaruf.api.yarufood.yarufoodapi.exception.BusinessException;
import com.yaruf.api.yarufood.yarufoodapi.mapper.ClientDTOMapper;
import com.yaruf.api.yarufood.yarufoodapi.repository.ClientRepository;
import com.yaruf.api.yarufood.yarufoodapi.service.ClientService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientServiceImpl implements ClientService {

    @Autowired
    ClientRepository clientRepository;

    @Autowired
    private ObjectMapper objectMapper;

    @Override
    public ClientDTO findById(String cpf) {
        ClientDTO client;
        try{
            Optional<Client> clientOptional = Optional.ofNullable(clientRepository.findByCpf(cpf));
            if (clientOptional.isPresent()) {
                client = ClientDTOMapper.toFormatClient(clientOptional.get());
            } else {
                throw new BusinessException(HttpStatus.NOT_FOUND, "Client could not be found with CPF");
            }
        }catch (BusinessException e){
            throw new BusinessException(e);
        }

        return client;
    }

    @Override
    public List<ClientDTO> findAll() {
        List<ClientDTO> clientDTOList = clientRepository.findAllClients();
        if (clientDTOList.isEmpty()) {
            throw new BusinessException(HttpStatus.NOT_FOUND, "Clients could not be found.");
        }
        return clientDTOList;
    }

    @Override
    @Transactional
    public ClientResponseDTO updateByCpf(Client upClient){

        ClientResponseDTO response = null;
        validateClient(upClient);

        Optional<Client> clientFound = Optional.ofNullable(clientRepository.findByCpf(upClient.getCpf()));
        if(clientFound.isPresent()){
            try{
                objectMapper.updateValue(clientFound.get(),upClient);
                response = new ClientResponseDTO(String.valueOf(HttpStatus.OK.value()),"Client updated with success!");
            }catch (Exception e){
                throw new BusinessException(HttpStatus.INTERNAL_SERVER_ERROR, "Couldn't update Client.. try again later", e);
            }
        }else{
            throw new BusinessException(HttpStatus.NOT_FOUND, "Could not find Client by cpf..");
        }
        return response;
    }

    public void validateClient(Client client){

        try{
            if(client == null){
                throw new BusinessException(HttpStatus.BAD_REQUEST, "Missing request body");
            }
        }catch (BusinessException e){
            throw new BusinessException(e);
        }

    }

}
