package br.upe.desafio_picpay.business.repository;

import br.upe.desafio_picpay.infra.models.Transfer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransferRepository extends JpaRepository<Transfer, Integer> {
}
