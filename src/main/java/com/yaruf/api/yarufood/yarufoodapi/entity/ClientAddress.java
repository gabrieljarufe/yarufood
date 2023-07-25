package com.yaruf.api.yarufood.yarufoodapi.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "tb_client_address")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ClientAddress {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "client_address_id")
    private Integer id;

    @Column(name = "address_name")
    private String addressName;

    @ManyToOne
    @JoinColumn(name = "address_id", referencedColumnName = "address_id")
    private Address address;

    @ManyToOne
    @JoinColumn(name = "client_cpf", referencedColumnName = "cpf")
    private Client client;
}
