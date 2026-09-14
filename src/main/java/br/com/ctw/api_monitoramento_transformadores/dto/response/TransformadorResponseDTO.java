package br.com.ctw.api_monitoramento_transformadores.dto.response;

import java.math.BigDecimal;

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
 * @author gustavo_pelissari150
 * @version 1.0.0
 */
public record TransformadorResponseDTO(
        Long id,
        String numeroSerie,
        String modelo,
        String subestacao,
        BigDecimal potenciaKva,
        BigDecimal limiteTempoOleo,
        BigDecimal limiteTempEnrol
) { }
