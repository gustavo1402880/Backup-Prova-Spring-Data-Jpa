package br.com.ctw.api_monitoramento_transformadores.application.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

/**
 * Transformador - Request - DTO
 *
 * <p>DTO de requisição para
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
@Schema(
        name = "Transformador - Request - DTO",
        description = "DTO de requisição para Transformador"
)
public record TransformadorRequestDTO(
        @Schema(
                name = "numeroSerie",
                description = """
                        Representa o identificador de série
                        de determinador Transformador""",
                maxLength = 100)
        @NotNull
        String numeroSerie,

        @Schema(
                name = "modelo",
                description = """
                        Representa o modelo do equipamento
                        """,
                maxLength = 100)
        @NotNull
        String modelo,

        @Schema(
                name = "subestacao",
                description = """
                        Representa a subestação
                        operacional do Transformador
                        """,
                maxLength = 100)
        String subestacao,

        @Schema(
                name = "potenciaKva",
                description = """
                        Representa a potencia em kva
                        do Transformador
                        """
        )
        @NotNull
        BigDecimal potenciaKva,

        @Schema(
                name = "limiteTempoOleo",
                description = """
                        Representa o limite de temperatura do óleo
                        que pode ser atingido
                        """
        )
        @NotNull
        BigDecimal limiteTempoOleo,

        @Schema(
                name = "limiteTempEnrol",
                description = """
                        Representa o limite de temperatura
                        de enrolamento que pode ser atingido
                        """
        )
        @NotNull
        BigDecimal limiteTempEnrol
) { }
