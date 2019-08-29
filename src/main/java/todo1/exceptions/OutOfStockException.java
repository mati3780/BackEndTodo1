package todo1.exceptions;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 */
public class OutOfStockException extends RuntimeException {

    private static final long serialVersionUID = 1L;
    private static final Logger log = LoggerFactory.getLogger(OutOfStockException.class);

    public OutOfStockException(Long id) {
        super("Producto fuera de stock, id: " + id);
        log.error("Producto id: " + id + " sin stock");
    }

    public OutOfStockException(String message, Throwable cause) {
        super(message, cause);
    }
}
