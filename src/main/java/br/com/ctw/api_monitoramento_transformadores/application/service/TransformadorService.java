package br.com.ctw.api_monitoramento_transformadores.application.service;

import br.com.ctw.api_monitoramento_transformadores.application.dto.request.TransformadorRequestDTO;
import br.com.ctw.api_monitoramento_transformadores.application.dto.request.TransformadorUpdateRequestDTO;
import br.com.ctw.api_monitoramento_transformadores.application.dto.response.TransformadorDetalhadoResponseDTO;
import br.com.ctw.api_monitoramento_transformadores.application.dto.response.TransformadorResponseDTO;
import br.com.ctw.api_monitoramento_transformadores.application.mapper.TransformadorMapper;
import br.com.ctw.api_monitoramento_transformadores.core.entity.Transformador;
import br.com.ctw.api_monitoramento_transformadores.exception.EntityNotFoundException;
import br.com.ctw.api_monitoramento_transformadores.infrastructure.repository.TransformadorRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Transformador - Service
 *
 * <p>Camada service de Transformador,
 * responsável pela implementação das
 * regras de negócio</p>
 *
 * @author gustavo_pelissari150
 * @version 1.0.0
 */
@Service
public class TransformadorService {

    private final TransformadorRepository repository;
    private final TransformadorMapper mapper;

    /**
     * Construtor padrão de injeção dependência para
     * TransformadorService
     *
     * @param repository Interface da camada repository de Transformador
     * @param mapper Objeto da camada mapper de Transformador
     */
    public TransformadorService(TransformadorRepository repository, TransformadorMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    /**
     * Lista transformadores
     *
     * <p>Busca e retorna um Page com os
     * Transformadores cadastrados</p>
     *
     * @param pageable Objeto paginável para facilitar
     * buscas em grande escala
     * @return Page com dtos de resposta para os Transformadores encontrados
     */
    @Transactional(readOnly = true)
    public Page<TransformadorResponseDTO> findAll(Pageable pageable) {
        return repository.findAll(pageable)
                .map(mapper::toResponse);
    }

    /**
     * Cadastra transformador
     *
     * <p>Verifica se já não existe um objeto com
     * determinado número de série, lançando uma
     * exceção caso exista</p>
     *
     * <p>Cadastra um novo transformador
     * no sistema</p>
     *
     * @param request DTO de requisição para Transformador
     * @throws IllegalStateException exceção para quando
     * existir uma tentativa de cadastro de transformador com número de série
     * existente
     * @return DTO de resposta para Transformador atualizado com id
     */
    public TransformadorResponseDTO create(TransformadorRequestDTO request) {
        if (repository.existsTransformadorByNumeroSerie(request.numeroSerie())) {
            throw new IllegalStateException(
                    "Transformador já cadastrado no numero de série: "+request.numeroSerie()
            );
        }

        Transformador transformador = mapper.toEntity(request);

        return mapper.toResponse(repository.save(transformador));
    }

    /**
     * Busca transformador pelo número de série
     *
     * <p>Tenta buscar um tranformador pelo número
     * série, lançando uma exceção caso não encontrado</p>
     *
     * @param numeroSerie Identificador número de série único para
     * transformador
     * @throws EntityNotFoundException exceção para quando
     * entidade não for encontrada
     * @return DTO de resposta detalhado de Transformador
     */
    @Transactional(readOnly = true)
    public TransformadorDetalhadoResponseDTO findByNumeroSerie(
            String numeroSerie
    ) {
        return mapper.toDetalhadoResponse(
                repository.findTransformadorByNumeroSerie(numeroSerie)
                        .orElseThrow(() -> new EntityNotFoundException(
                                "Transformador não encontrado para o número de série: "+numeroSerie
                        ))
        );
    }

    /**
     * Atualiza campos de limite de Transformador
     *
     * <p>Tenta buscar um tranformador pelo número
     * série, lançando uma exceção caso não encontrado</p>
     *
     * <p>Atualiza os respectivos campos permitidos
     * de transformador</p>
     *
     * @param numeroSerie Identificador número de série único para
     * transformador
     * @param request DTO de requisição para atualizar
     * Transformador
     * @throws EntityNotFoundException exceção para quando
     * entidade não for encontrada
     * @return DTO de resposta de Transformador
     */
    public TransformadorResponseDTO update(
            String numeroSerie,
            TransformadorUpdateRequestDTO request
    ) {
        Transformador transformador = repository.findTransformadorByNumeroSerie(numeroSerie)
                .orElseThrow(() -> new EntityNotFoundException(
                        "Transformador não encontrado para o número de série: "+numeroSerie
                ));

        transformador = mapper.update(transformador, request);

        return mapper.toResponse(
                repository.save(transformador)
        );
    }

    /**
     * Deleta Transformador pelo número de série
     *
     * <p>Tenta buscar um tranformador pelo número
     * série, lançando uma exceção caso não encontrado</p>
     *
     * <p>Deleta o respectivo transformador do sistema</p>
     *
     * @param numeroSerie Identificador número de série único para
     * transformador
     * @throws EntityNotFoundException exceção para quando
     * entidade não for encontrada
     */
    public void delete(String numeroSerie) {
        Transformador transformador = repository.findTransformadorByNumeroSerie(numeroSerie)
                .orElseThrow(() -> new EntityNotFoundException(
                        "Transformador não encontrado para o número de série: "+numeroSerie
                ));

        repository.delete(transformador);
    }
}
