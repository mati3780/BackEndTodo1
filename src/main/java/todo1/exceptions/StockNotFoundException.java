package todo1.exceptions;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class StockNotFoundException extends RuntimeException {
	private static final Logger log = LoggerFactory.getLogger(StockNotFoundException.class);
	public StockNotFoundException(Long id) {
		super("Stock no encontrado, id: " + id);
		log.error("Stock id: " + id + " no encontrado.");
	}
}
