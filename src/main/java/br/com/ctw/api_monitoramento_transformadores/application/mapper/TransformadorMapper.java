package br.com.ctw.api_monitoramento_transformadores.application.mapper;

import br.com.ctw.api_monitoramento_transformadores.application.dto.request.TranformadorRequest;
import br.com.ctw.api_monitoramento_transformadores.application.dto.response.TranformadorResponse;
import br.com.ctw.api_monitoramento_transformadores.core.entity.AlertaTermico;
import br.com.ctw.api_monitoramento_transformadores.core.entity.LeituraTermica;
import br.com.ctw.api_monitoramento_transformadores.core.entity.Tecnico;
import br.com.ctw.api_monitoramento_transformadores.core.entity.Transformador;
import org.springframework.stereotype.Component;

import java.util.Set;
import java.util.stream.Collectors;

@Component
public class TransformadorMapper {

    public Transformador toEntity(TranformadorRequest request) {
        return Transformador.builder()
                .numeroSerie(request.numeroSerie())
                .modelo(request.modelo())
                .subestacao(request.subestacao())
                .potenciaKva(request.potenciaKva())
                .limiteTempoOleo(request.limiteTempoOleo())
                .limiteTempEnrol(request.limiteTempEnrol())
                .build();
    }

    public TranformadorResponse toResponse(Transformador entity) {
        return new TranformadorResponse(
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
