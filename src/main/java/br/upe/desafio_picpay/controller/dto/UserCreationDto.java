package br.upe.desafio_picpay.controller.dto;

import br.upe.desafio_picpay.infra.enums.UserTypeEnum;
import jakarta.validation.constraints.NotNull;

public record UserCreationDto (
        @NotNull(message = "The user's CPF cannot be blank")
        String cpf,
        @NotNull(message = "The user's email cannot be blank")
        String email,
        @NotNull(message = "The user need a type")
        UserTypeEnum userType,
        @NotNull(message = "The user's name cannot be blank")
        String completeName,
        @NotNull(message = "The user's password cannot be blank")
        String password){
}
