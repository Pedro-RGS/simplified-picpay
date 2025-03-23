package br.upe.desafio_picpay.controller.mapper;

import br.upe.desafio_picpay.controller.dto.TransferResponseDto;
import br.upe.desafio_picpay.infra.models.Transfer;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TransferMapper {

    TransferResponseDto toDto(Transfer transfer);
}
