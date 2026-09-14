package br.com.ctw.api_monitoramento_transformadores.application.dto.request;

public record TranformadorRequest(
        String numeroSerie,
        String modelo,
        String subestacao,
        Double potenciaKva,
        Double limiteTempoOleo,
        Double limiteTempEnrol
) { }
