package todo1.exceptions;


public class ProductNotFoundException extends RuntimeException {

	public ProductNotFoundException(Long id) {
		super("Producto no encontrado, id: " + id);
	}
}
