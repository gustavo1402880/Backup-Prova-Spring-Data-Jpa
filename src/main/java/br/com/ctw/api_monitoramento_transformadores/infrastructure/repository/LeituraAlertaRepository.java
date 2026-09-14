package br.com.ctw.api_monitoramento_transformadores.infrastructure.repository;

import br.com.ctw.api_monitoramento_transformadores.core.entity.LeituraTermica;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Leitura Térmica - Repository
 *
 * <p>Camada de persistence de LeituraTermica,
 * responsável pela persistencia de dados da entidade</p>
 *
 * @author gustavo_pelissari150
 * @version 1.0.0
 */
@Repository
public interface LeituraAlertaRepository extends JpaRepository<LeituraTermica, Long> {
}
