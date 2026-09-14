package br.com.ctw.api_monitoramento_transformadores.controller;

import br.com.ctw.api_monitoramento_transformadores.dto.request.TransformadorRequestDTO;
import br.com.ctw.api_monitoramento_transformadores.dto.request.TransformadorUpdateRequestDTO;
import br.com.ctw.api_monitoramento_transformadores.dto.response.TransformadorDetalhadoResponseDTO;
import br.com.ctw.api_monitoramento_transformadores.dto.response.TransformadorResponseDTO;
import br.com.ctw.api_monitoramento_transformadores.service.TransformadorService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Tranformador - Controller
 *
 * <p>Camada controller de Transformador, responsável
 * por gerenciar endpoints para métodos HTTP</p>
 *
 * @author gustavo_pelissari150
 * @version 1.0.0
 */
@Tag(
        name = "Transformador - Controller",
        description = """
                Camada controller de Tranformador, responsável
                por gerenciar endpoints para métodos HTTP
                """
)
@RestController
@RequestMapping("/api/v1/transformadores")
public class TransformadorController {

    private final TransformadorService service;

    /**
     * Construtor padrão de injeção dependência para
     * TransformadorController
     *
     * @param service Objeto da camada service de Transformador
     */
    public TransformadorController(TransformadorService service) {
        this.service = service;
    }

    /**
     * Lista Transformadores
     *
     * <p>Busca e retorna um Page com os
     * Transformadores cadastrados</p>
     *
     * @param pageable Objeto paginável opcional para facilitar
     * buscas em grande escala
     * @return Page com dtos de resposta para os Transformadores encontrados
     */
    @Operation(
            summary = "Lista Transformadores",
            description = "Busca e retorna um Page com os Transformadores cadastrados"
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "Transformadores encontrados"
            )
    })
    @GetMapping
    public ResponseEntity<Page<TransformadorResponseDTO>> listAll(
            @Parameter(
                    name = "pageable",
                    description = """
                            Objeto paginável opcional para facilitar
                            buscas em grande escala
                            """
            )
            @PageableDefault(
                    page = 0,
                    size = 20,
                    sort = "numeroSerie"
            )
            Pageable pageable
    ) {
        return ResponseEntity.ok().body(
                service.findAll(pageable)
        );
    }

    /**
     * Cadastra Transformador
     *
     * <p>Cadastra um novo transformador validando
     * seus respectivos dados</p>
     *
     * @param request DTO de requisição para Transformador
     * @return DTO de resposta para Transformador
     */
    @Operation(
            summary = "Cadastra Transformador",
            description = """
                   Cadastra um novo transformador validando
                   seus respectivos dados
                   """
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "201",
                    description = "Transformador cadastrado"
            ),
            @ApiResponse(
                    responseCode = "409",
                    description = "Violação de regras de negócio"
            )
    })
    @PostMapping(
            consumes = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<TransformadorResponseDTO> create(
            @Parameter(
                    name = "Transformador Request DTO",
                    description = """
                        DTO de requisição para Transformador
                        """,
                    required = true
            )
            @RequestBody
            @Valid
            TransformadorRequestDTO request
    ) {
        return ResponseEntity
                .status(HttpStatus.CREATED).body(
                        service.create(request)
                );
    }

    /**
     * Busca Transformador por número de série
     *
     * <p>Busca e retorna um transformador através da
     * pesquisa pelo seu identificador de número de série</p>
     *
     * @param numeroSerie Identificador número de série único para
     * transformador
     * @return DTO de resposta para o Transformador encontrado
     */
    @Operation(
            summary = "Busca Transformador por número de série",
            description = """
                   Busca e retorna um transformador através da
                   pesquisa pelo seu identificador de número de série
                   """
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "Transformador encontrado"
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "Transformador não encontrado"
            )
    })
    @GetMapping(
            path = "/{numeroSerie}"
    )
    public ResponseEntity<TransformadorDetalhadoResponseDTO> findByNumeroSerie(
            @Parameter(
                    name = "Número de série",
                    description = "Identificador único para cada Transformador",
                    example = "TRF-2026-1001",
                    required = true
            )
            @PathVariable
            @Valid
            String numeroSerie
    ) {
        return ResponseEntity.ok().body(
                service.findByNumeroSerie(numeroSerie)
        );
    }

    /**
     * Atualiza Transformador
     *
     * <p>Atualiza os campos de limite de
     * temperatura de determinado
     * transformador</p>
     *
     * @param numeroSerie Identificador número de série único para
     * transformador
     * @param request DTO de requisição para atualizar
     * Transformador
     * @return DTO de resposta para Transformador
     */
    @Operation(
            summary = "Atualiza Transformador",
            description = """
                    Atualiza os campos de limite
                    de temperatura de determinado
                    transformador
                    """
    )
    @PutMapping(
            path = "/{numeroSerie}",
            consumes = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<TransformadorResponseDTO> update(
            @Parameter(
                    name = "Número de série",
                    description = "Identificador único para cada Transformador",
                    example = "TRF-2026-1001",
                    required = true
            )
            @PathVariable
            @Valid
            String numeroSerie,
            @Parameter(
                    name = "Transformador Update Request DTO",
                    description = """
                            DTO de requisição para atualizar
                            Transformador""",
                    required = true
            )
            @RequestBody
            @Valid
            TransformadorUpdateRequestDTO request
    ) {
        return ResponseEntity.ok().body(
                service.update(
                        numeroSerie,
                        request)
        );
    }

    /**
     * Deleta Transformador
     *
     * <p>Deleta transformador do sistema
     * através do identificador número de série
     * único</p>
     *
     * @param numeroSerie Identificador número de série único para
     * transformador
     * @return Resultado sem conteúdo
     */
    @Operation(
            summary = "Deleta Transformador",
            description = """
                    Deleta tranformador do sistema
                    através do identificador número de série
                    único
                    """
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "204",
                    description = "Transformador deletado"
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "Transformador não encontrado"
            )
    })
    @DeleteMapping("/{numeroSerie}")
    public ResponseEntity<Void> delete(
            @Parameter(
                    name = "Número de série",
                    description = "Identificador único para cada Transformador",
                    example = "TRF-2026-1001",
                    required = true
            )
            @PathVariable
            @Valid
            String numeroSerie
    ) {
        service.delete(numeroSerie);

        return ResponseEntity.noContent().build();
    }
}
