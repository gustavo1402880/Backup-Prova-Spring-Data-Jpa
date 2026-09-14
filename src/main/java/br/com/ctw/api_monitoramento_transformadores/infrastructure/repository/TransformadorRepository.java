package br.com.ctw.api_monitoramento_transformadores.infrastructure.repository;

import br.com.ctw.api_monitoramento_transformadores.core.entity.Transformador;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransformadorRepository extends JpaRepository<Transformador, Long> {

    boolean existsTransformadorByNumeroSerie(String numeroSerie);
}
