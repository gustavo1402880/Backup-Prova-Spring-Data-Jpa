package br.com.ctw.api_monitoramento_transformadores.exception.config;

import br.com.ctw.api_monitoramento_transformadores.exception.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.ErrorResponse;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * Global Exception Handler
 *
 * <p>Objeto global responsável por gerenciar
 * exceções durante execução da API</p>
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

    /**
     * Gerencia exceção EntityNotFound
     *
     * @param e {@link EntityNotFoundException}
     * @return Resposta de erro da API
     */
    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleEntityNotFound(
            EntityNotFoundException e
    ) {
        ErrorResponse error = ErrorResponse.create(
                e,
                HttpStatus.NOT_FOUND,
                e.getMessage()
        );

        return ResponseEntity.status(
                error.getStatusCode()
        ).body(error);
    }

    /**
     * Gerencia exceção IllegalState
     *
     * @param e {@link IllegalStateException}
     * @return Resposta de erro da API
     */
    @ExceptionHandler(IllegalStateException.class)
    public ResponseEntity<ErrorResponse> handleIllegalState(
            IllegalStateException e
    ) {
        ErrorResponse error = ErrorResponse.create(
                e,
                HttpStatus.CONFLICT,
                e.getMessage()
        );

        return ResponseEntity.status(
                error.getStatusCode()
        ).body(error);
    }

    /**
     * Gerencia exceção para mensagem Http não aceita
     *
     * @param e {@link HttpMessageNotReadableException}
     * @return Resposta de erro da API
     */
    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<ErrorResponse> handleHttpMessageNotReadable(
            HttpRequestMethodNotSupportedException e
    ) {
        ErrorResponse error = ErrorResponse.create(
                e,
                HttpStatus.BAD_REQUEST,
                e.getMessage()
        );

        return ResponseEntity.status(
                error.getStatusCode()
        ).body(error);
    }

    /**
     * Gerencia exceção para método Http não suportado
     *
     * @param e {@link HttpRequestMethodNotSupportedException}
     * @return Resposta de erro da API
     */
    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public ResponseEntity<ErrorResponse> handleHttpRequestMethodNotSupported(
            HttpRequestMethodNotSupportedException e
    ) {
        ErrorResponse error = ErrorResponse.create(
                e,
                HttpStatus.METHOD_NOT_ALLOWED,
                e.getMessage()
        );

        return ResponseEntity.status(
                error.getStatusCode()
        ).body(error);
    }

    /**
     * Gerencia exceção genérica
     *
     * @param e {@link Exception}
     * @return Resposta de erro da API
     */
    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<ErrorResponse> handleException(
            IllegalArgumentException e
    ) {
        ErrorResponse error = ErrorResponse.create(
                e,
                HttpStatus.INTERNAL_SERVER_ERROR,
                e.getMessage()
        );

        return ResponseEntity.status(
                error.getStatusCode()
        ).body(error);
    }
}
