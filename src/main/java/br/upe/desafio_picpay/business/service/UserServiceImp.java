package br.upe.desafio_picpay.business.service;

import br.upe.desafio_picpay.business.repository.UserRepository;
import br.upe.desafio_picpay.business.service.interfaces.UserService;
import br.upe.desafio_picpay.controller.dto.TransferResponseDto;
import br.upe.desafio_picpay.controller.dto.UserCreationDto;
import br.upe.desafio_picpay.controller.dto.UserDto;
import br.upe.desafio_picpay.controller.mapper.UserMapper;
import br.upe.desafio_picpay.infra.exception.InsufficientBalanceException;
import br.upe.desafio_picpay.infra.exception.NotFoundException;
import br.upe.desafio_picpay.infra.models.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


@Service
public class UserServiceImp implements UserService {

    private UserRepository repository;
    private UserMapper mapper;

    @Override
    public UserDto create(UserCreationDto dto) {
        User newUser = mapper.toEntity(dto);
        repository.save(newUser);

        return mapper.toDto(newUser);
    }

    @Override
    public void delete(UserDto dto) {
        User user = repository.findById(dto.id()).orElse(null);

        if (user == null) {
            throw new NotFoundException("This user was not found");
        }

        repository.delete(user);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public TransferResponseDto makeTransfer(Integer payerId, Integer payeeId, Double amount) {
        if (amount <= 0.0){
            throw new IllegalArgumentException("Amount must be greater than zero");
        }

        if (payerId.equals(payeeId)){
            throw new IllegalArgumentException("The payer cannot send a transfer for himself");
        }

        User payer = repository.findById(payerId).orElseThrow(
                () -> new NotFoundException("User with id " + payerId + " was not found"));
        User payee = repository.findById(payeeId).orElseThrow(
                () -> new NotFoundException("User with id " + payeeId + " was not found"));

        if (payer.getWalletBalance() < amount){
            throw new InsufficientBalanceException("The payer has insufficient balance");
        }

        payer.setWalletBalance(payer.getWalletBalance() - amount);
        payee.setWalletBalance(payee.getWalletBalance() + amount);

        return new TransferResponseDto(amount, payerId, payeeId);
    }
}
