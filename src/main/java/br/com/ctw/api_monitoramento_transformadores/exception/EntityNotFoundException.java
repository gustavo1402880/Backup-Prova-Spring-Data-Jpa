package br.com.ctw.api_monitoramento_transformadores.exception;

/**
 * EntityNotFound - Exception
 *
 * <p>Exceção para quando uma entidade
 * não for encontrada</p>
 *
 * @author gustavo_pelissari150
 * @version 1.0.0
 */
public class EntityNotFoundException extends RuntimeException {
    public EntityNotFoundException(String message) {
        super(message);
    }

    public EntityNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
