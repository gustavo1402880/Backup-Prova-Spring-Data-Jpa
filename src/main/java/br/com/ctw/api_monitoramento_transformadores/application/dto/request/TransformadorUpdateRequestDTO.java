package br.com.ctw.api_monitoramento_transformadores.application.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

/**
 * Transformador - Update Request - DTO
 *
 * <p>DTO de requisição para
 * atualizar transformador</p>
 *
 * @param limiteTempoOleo limite de temperatura do óleo
 * @param limiteTempEnrol limite de temperatura de enrolamento
 * @author gustavo_pelissari150
 * @version 1.0.0
 */
@Schema(
        name = "Tranformador - Update Request - DTO",
        description = """
                DTO de requisição para atualizar
                transformador
                """
)
public record TransformadorUpdateRequestDTO(
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
