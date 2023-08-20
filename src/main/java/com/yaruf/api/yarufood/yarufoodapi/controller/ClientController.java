package com.yaruf.api.yarufood.yarufoodapi.controller;

import com.yaruf.api.yarufood.yarufoodapi.dto.ClientDTO;
import com.yaruf.api.yarufood.yarufoodapi.dto.ClientResponseDTO;
import com.yaruf.api.yarufood.yarufoodapi.entity.Client;
import com.yaruf.api.yarufood.yarufoodapi.service.impl.ClientServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping( value = "/client")
public class ClientController {

    @Autowired
    ClientServiceImpl clientService;

    @GetMapping( value = "/all")
    public ResponseEntity<List<ClientDTO>> consultAll(){
        return ResponseEntity.ok(clientService.findAll());
    }

    @GetMapping( value = "/{cpf}")
    public ResponseEntity<ClientDTO> consultByCpf(@PathVariable String cpf) {
        return ResponseEntity.ok(clientService.findById(cpf));
    }

    @PatchMapping( value = "/update")
    public ResponseEntity<ClientResponseDTO> updateByCpf(
            @RequestBody(required = false) Client client) {
        return ResponseEntity.ok(clientService.updateByCpf(client));
    }

}
