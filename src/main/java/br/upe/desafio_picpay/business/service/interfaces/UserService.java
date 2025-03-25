package br.upe.desafio_picpay.business.service.interfaces;

import br.upe.desafio_picpay.controller.dto.TransferResponseDto;
import br.upe.desafio_picpay.controller.dto.UserCreationDto;
import br.upe.desafio_picpay.controller.dto.UserDto;

public interface UserService {

    UserDto create(UserCreationDto dto);

    void delete(UserDto dto);

    TransferResponseDto makeTransfer(Integer payerId, Integer payeeId, Double amount);
}
