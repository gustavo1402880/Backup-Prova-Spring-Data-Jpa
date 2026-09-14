package br.com.ctw.api_monitoramento_transformadores.mapper;

import br.com.ctw.api_monitoramento_transformadores.dto.request.TransformadorRequestDTO;
import br.com.ctw.api_monitoramento_transformadores.dto.request.TransformadorUpdateRequestDTO;
import br.com.ctw.api_monitoramento_transformadores.dto.response.TransformadorDetalhadoResponseDTO;
import br.com.ctw.api_monitoramento_transformadores.dto.response.TransformadorResponseDTO;
import br.com.ctw.api_monitoramento_transformadores.entity.AlertaTermico;
import br.com.ctw.api_monitoramento_transformadores.entity.LeituraTermica;
import br.com.ctw.api_monitoramento_transformadores.entity.Tecnico;
import br.com.ctw.api_monitoramento_transformadores.entity.Transformador;
import org.springframework.stereotype.Component;

import java.util.Set;
import java.util.stream.Collectors;

/**
 * Transfomador - Mapper
 *
 * <p>Objeto da camada mapper de Transfomador,
 * responsável por mapear entidade e dto</p>
 *
 * @author gustavo_pelissari150
 * @version 1.0.0
 */
@Component
public class TransformadorMapper {

    /**
     * Mapeia DTO Request para Entidade
     *
     * @param request DTO de requisição para Transformador
     * @return entidade {@link Transformador} mapeada corretamente
     */
    public Transformador toEntity(TransformadorRequestDTO request) {
        return Transformador.builder()
                .numeroSerie(request.numeroSerie())
                .modelo(request.modelo())
                .subestacao(request.subestacao())
                .potenciaKva(request.potenciaKva())
                .limiteTempoOleo(request.limiteTempoOleo())
                .limiteTempEnrol(request.limiteTempEnrol())
                .build();
    }

    /**
     * Mapeia Entidade para DTO Response
     *
     * @param entity Objeto entidade de Transformador
     * @return DTO de resposta de Transfomador
     */
    public TransformadorResponseDTO toResponse(Transformador entity) {
        return new TransformadorResponseDTO(
                entity.getId(),
                entity.getNumeroSerie(),
                entity.getModelo(),
                entity.getSubestacao(),
                entity.getPotenciaKva(),
                entity.getLimiteTempoOleo(),
                entity.getLimiteTempEnrol()
        );
    }

    /**
     * Atualiza entidade através da DTO update
     *
     * @param entity Objeto entidade de Transformador
     * @param request DTO de requisição para atualizar Transformador
     * @return entidade {@link Transformador} atualizada corretamente
     */
    public Transformador update(Transformador entity, TransformadorUpdateRequestDTO request) {
        entity.setLimiteTempoOleo(
                request.limiteTempoOleo() != null
                        ? request.limiteTempoOleo()
                        : entity.getLimiteTempoOleo()
        );
        entity.setLimiteTempEnrol(
                request.limiteTempEnrol() != null
                        ? request.limiteTempEnrol()
                        : entity.getLimiteTempEnrol()
        );

        return entity;
    }

    /**
     * Mapeia Entidade para DTO Response Detalhado
     *
     * @param entity Objeto entidade de Transformador
     * @return DTO de resposta de Transfomador detalhado
     * com mais campos
     */
    public TransformadorDetalhadoResponseDTO toDetalhadoResponse(Transformador entity) {
        return new TransformadorDetalhadoResponseDTO(
                entity.getId(),
                entity.getNumeroSerie(),
                entity.getModelo(),
                entity.getSubestacao(),
                entity.getPotenciaKva(),
                entity.getLimiteTempoOleo(),
                entity.getLimiteTempEnrol(),
                entity.getTecnicos() != null
                        ? entity.getTecnicos().stream()
                        .map(Tecnico::getId).collect(Collectors.toSet())
                        : Set.of(),
                entity.getAlertas() != null
                        ? entity.getAlertas().stream()
                        .map(AlertaTermico::getId).collect(Collectors.toSet())
                        : Set.of(),
                entity.getLeituras() != null
                        ? entity.getLeituras().stream()
                        .map(LeituraTermica::getId).collect(Collectors.toSet())
                        : Set.of()
        );
    }
}
