package com.yaruf.api.yarufood.yarufoodapi.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "tb_client")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Client {

    @Id
    @Column(name = "cpf")
    private String cpf;

    @Embedded
    private Contact contact;

    @Column(name = "email")
    private String email;

    @Column(name = "name")
    private String name;
}
