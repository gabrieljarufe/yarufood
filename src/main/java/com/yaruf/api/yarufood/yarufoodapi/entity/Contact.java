package com.yaruf.api.yarufood.yarufoodapi.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Embeddable
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Contact {
    @Column(name = "ddd")
    private String ddd;
    @Column(name = "phone_number")
    private String phone_number;
}
