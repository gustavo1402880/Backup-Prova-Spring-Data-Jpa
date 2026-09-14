package br.com.ctw.api_monitoramento_transformadores.infrastructure.repository;

import br.com.ctw.api_monitoramento_transformadores.core.entity.Transformador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Transformador - Repository
 *
 * <p>Camada de persistence de Transformador,
 * responsável pela persistencia de dados da entidade</p>
 *
 * @author gustavo_pelissari150
 * @version 1.0.0
 */
@Repository
public interface TransformadorRepository extends JpaRepository<Transformador, Long> {

    /**
     * Encontra entidade pelo número de série
     *
     * @param numeroSerie Identificador de série de Transformador
     * @return entidade {@link Transformador} caso seja encontrada
     */
    Optional<Transformador> findTransformadorByNumeroSerie(String numeroSerie);

    /**
     * Verifica se existe Transformador para aquela número de série
     *
     * @param numeroSerie Identificador de série de Transformador
     * @return valor lógico para quando for encontrado
     */
    boolean existsTransformadorByNumeroSerie(String numeroSerie);
}
