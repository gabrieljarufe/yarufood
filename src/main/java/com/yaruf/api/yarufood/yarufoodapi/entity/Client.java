package com.yaruf.api.yarufood.yarufoodapi.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "tb_client")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
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
