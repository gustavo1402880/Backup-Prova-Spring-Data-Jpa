package br.com.ctw.api_monitoramento_transformadores.dto.response;

import java.math.BigDecimal;
import java.util.Set;

/**
 * Transformador - Response - DTO
 *
 * <p>DTO de resposta para
 * transformador</p>
 *
 * @param numeroSerie Identificador de série
 * @param modelo Modelo do equipamento
 * @param subestacao Subestação do transformados
 * @param potenciaKva Potência do transformador
 * @param limiteTempoOleo Limite de temperatura do óleo
 * @param limiteTempEnrol Limite de temperatura de enrolamento
 * @param tecnicos Lista com os ids dos tecnicos
 * relacionados com o equipamento
 * @param alertas Lista com os ids dos alertas térmicos
 * relacionados com o equipamento
 * @param leituras Lista com os ids das leitura térmicas
 * relacionados com o equipamento
 * @author gustavo_pelissari150
 * @version 1.0.0
 */
public record TransformadorDetalhadoResponseDTO(
        Long id,
        String numeroSerie,
        String modelo,
        String subestacao,
        BigDecimal potenciaKva,
        BigDecimal limiteTempoOleo,
        BigDecimal limiteTempEnrol,
        Set<Long> tecnicos,
        Set<Long> alertas,
        Set<Long> leituras
) { }
