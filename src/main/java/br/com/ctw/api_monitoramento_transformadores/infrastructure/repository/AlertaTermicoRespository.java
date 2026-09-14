package br.com.ctw.api_monitoramento_transformadores.infrastructure.repository;

import br.com.ctw.api_monitoramento_transformadores.core.entity.AlertaTermico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Alerta Térmico - Repository
 *
 * <p>Camada de persistence de AlertaTermico,
 * responsável pela persistencia de dados da entidade</p>
 *
 * @author gustavo_pelissari150
 * @version 1.0.0
 */
@Repository
public interface AlertaTermicoRespository extends JpaRepository<AlertaTermico, Long> {
}
