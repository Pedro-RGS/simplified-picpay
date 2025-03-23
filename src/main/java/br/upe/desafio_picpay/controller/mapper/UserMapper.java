package br.upe.desafio_picpay.controller.mapper;

import br.upe.desafio_picpay.controller.dto.UserDto;
import br.upe.desafio_picpay.infra.models.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserDto toDto(User user);
}
