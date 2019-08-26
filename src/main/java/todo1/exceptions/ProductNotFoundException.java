package todo1.exceptions;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ProductNotFoundException extends RuntimeException {
	private static final Logger log = LoggerFactory.getLogger(ProductNotFoundException.class);
	public ProductNotFoundException(Long id) {
		super("Producto no encontrado, id: " + id);
		log.error("Producto id: " + id + " no encontrado.");
	}
}
