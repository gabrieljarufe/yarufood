package com.yaruf.api.yarufood.yarufoodapi.controller;

import com.yaruf.api.yarufood.yarufoodapi.dto.ClientDTO;
import com.yaruf.api.yarufood.yarufoodapi.service.impl.ClientServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping( value = "/client")
public class ClientController {

    @Autowired
    ClientServiceImpl clientService;

    @GetMapping( value = "all")
    private ResponseEntity<List<ClientDTO>> consultAll(){
        return ResponseEntity.ok(clientService.findAll());
    }

    @GetMapping( value = "/{cpf}")
    private ResponseEntity<ClientDTO> consultByCpf(@PathVariable String cpf) throws Exception {
        return ResponseEntity.ok(clientService.findById(cpf));
    }
}
