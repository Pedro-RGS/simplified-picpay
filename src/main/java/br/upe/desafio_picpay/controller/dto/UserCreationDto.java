package br.upe.desafio_picpay.controller.dto;

import br.upe.desafio_picpay.infra.enums.UserTypeEnum;

public record UserCreationDto (
        String cpf,
        String email,
        UserTypeEnum userType,
        String completeName,
        String password){
}
