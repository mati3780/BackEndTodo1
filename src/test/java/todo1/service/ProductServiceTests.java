package todo1.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import todo1.exceptions.ProductNotFoundException;
import todo1.repository.ProductRepository;

@SpringBootTest
public class ProductServiceTests {

	@InjectMocks
	private ProductService productService;

	@Mock
	private ProductRepository repository;
	/*
	 * Se busca un producto con un id inválido,
	 * se espera una exception ProductNotFoundException
	 */
	@Test
	public void getByIdWithProductNotFoundException() {

		Assertions.assertThrows(ProductNotFoundException.class, () -> {

			 productService.getById(99L);

		});
	}
}
