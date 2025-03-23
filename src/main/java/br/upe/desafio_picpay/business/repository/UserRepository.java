package br.upe.desafio_picpay.business.repository;

import br.upe.desafio_picpay.infra.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}
