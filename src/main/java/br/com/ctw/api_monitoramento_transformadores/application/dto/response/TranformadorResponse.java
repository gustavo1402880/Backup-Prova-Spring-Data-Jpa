package br.com.ctw.api_monitoramento_transformadores.application.dto.response;

import br.com.ctw.api_monitoramento_transformadores.core.entity.AlertaTermico;

import java.util.Set;

public record TranformadorResponse(
        Long id,
        String numeroSerie,
        String modelo,
        String subestacao,
        Double potenciaKva,
        Double limiteTempoOleo,
        Double limiteTempEnrol,
        Set<Long> tecnicos,
        Set<Long> alertas,
        Set<Long> leituras
) { }
