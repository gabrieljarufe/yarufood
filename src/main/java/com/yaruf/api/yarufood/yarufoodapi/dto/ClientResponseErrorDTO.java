package com.yaruf.api.yarufood.yarufoodapi.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;
import org.springframework.http.HttpStatus;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ClientResponseErrorDTO {
    public Integer code;
    public String message;
    public Throwable error;

    public ClientResponseErrorDTO(Integer code, String message){
        this.code = code;
        this.message = message;
    }
}
