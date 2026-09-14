package br.com.ctw.api_monitoramento_transformadores.infrastructure.repository;

import br.com.ctw.api_monitoramento_transformadores.core.entity.AlertaTermico;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlertaTermicoRespository extends JpaRepository<AlertaTermico, Long> {
}
