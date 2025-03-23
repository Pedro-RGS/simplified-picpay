package br.upe.desafio_picpay.controller.dto;

public record UserDto(
        Integer id,
        String completeName,
        Double walletBalance) {
}
