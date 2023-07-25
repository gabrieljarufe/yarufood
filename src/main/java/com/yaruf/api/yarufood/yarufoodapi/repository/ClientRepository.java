package com.yaruf.api.yarufood.yarufoodapi.repository;

import com.yaruf.api.yarufood.yarufoodapi.dto.ClientDTO;
import com.yaruf.api.yarufood.yarufoodapi.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface ClientRepository extends JpaRepository <Client, String>{
    @Query("SELECT NEW com.yaruf.api.yarufood.yarufoodapi.dto.ClientDTO(c.cpf, c.email, c.name, c.contact.ddd, c.contact.phone_number) FROM Client c")
    List<ClientDTO> findAllClients();

    Client findByCpf(String cpf);
}
