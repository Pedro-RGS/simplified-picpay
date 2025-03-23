package br.upe.desafio_picpay.business.service;

import br.upe.desafio_picpay.business.repository.UserRepository;
import br.upe.desafio_picpay.controller.dto.UserDto;
import br.upe.desafio_picpay.controller.mapper.UserMapper;
import org.springframework.stereotype.Service;


@Service
public class UserService {

    private UserRepository repository;
    private UserMapper mapper;

}
