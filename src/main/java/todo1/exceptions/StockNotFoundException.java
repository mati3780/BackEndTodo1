package todo1.exceptions;


public class StockNotFoundException extends RuntimeException {

	public StockNotFoundException(Long id) {
		super("Stock no encontrado, id: " + id);
	}
}
