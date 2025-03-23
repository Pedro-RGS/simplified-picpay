package br.upe.desafio_picpay.controller.dto;

public record TransferResponseDto(
        Double amount,
        Integer payerId,
        Integer payeeId) {

}
