package br.com.ctw.api_monitoramento_transformadores.infrastructure.repository;

import br.com.ctw.api_monitoramento_transformadores.core.entity.LeituraTermica;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LeituraAlertaRepository extends JpaRepository<LeituraTermica, Long> {
}
