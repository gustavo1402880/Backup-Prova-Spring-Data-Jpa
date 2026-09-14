package br.com.ctw.api_monitoramento_transformadores.application.service;

import br.com.ctw.api_monitoramento_transformadores.application.dto.request.TranformadorRequest;
import br.com.ctw.api_monitoramento_transformadores.application.dto.response.TranformadorResponse;
import br.com.ctw.api_monitoramento_transformadores.application.mapper.TransformadorMapper;
import br.com.ctw.api_monitoramento_transformadores.infrastructure.repository.TransformadorRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;

@Service
public class TranformadorService {

    private final TransformadorRepository repository;
    private final TransformadorMapper mapper;

    public TranformadorService(TransformadorRepository repository, TransformadorMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Transactional(readOnly = true)
    public Page<TranformadorResponse> listarTodos(Pageable pageable) {
        return repository.findAll(pageable)
                .map(mapper::toResponse);
    }

    @Transactional(readOnly = false)
    public TranformadorResponse criar(TranformadorRequest request) {
        if (repository.existsTransformadorByNumeroSerie(request.numeroSerie())) {

        }
    }
}
