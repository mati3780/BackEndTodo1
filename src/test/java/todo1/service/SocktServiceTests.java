package todo1.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import todo1.dto.StockDTO;
import todo1.dto.MovementDTO;
import todo1.exceptions.OutOfStockException;
import todo1.exceptions.StockNotFoundException;
import todo1.model.Brand;
import todo1.model.Product;
import todo1.model.Stock;
import todo1.repository.StockRepository;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.Mockito.when;

@SpringBootTest
public class SocktServiceTests {

	@InjectMocks
	private StockService stockService;
	@Mock
	private StockRepository repository;

	private static int inMovement = 1;

	private static int outMovement = 2;

	@BeforeEach
	void setMock() {
		Product product = new Product();
		product.setCode(2L);
		product.setBrand(new Brand());
		product.setDescription("CAMISETA");
		product.setId(22L);

		Optional<Stock> stockIn = Optional.of(new Stock());

		stockIn.map(
				x -> {
					x.setQuantity(0L);
					x.setProduct(product);
					x.setId(1L);
					return x;
				});

		when(repository.findById(1L)).thenReturn(stockIn);

		Optional<Stock> stockOut = Optional.of(new Stock());

		stockOut.map(
				x -> {
					x.setQuantity(5L);
					x.setId(2L);
					return x;
				});
		
		when(repository.findById(2L)).thenReturn(stockOut);
	}
	

	/*
	 * Se actualiza el stock inicial de un producto con cantidad inicial en cero. Se ingresa una cantidad para ese
	 * producto y el tipo de operación del tipo "in" y se espera que devuelva la existencia
	 * actualizada sin exceptions
	 */
	@Test
	public void addMovementAdditionSucess() {

		MovementDTO movementDTO = new MovementDTO();
		movementDTO.setType(inMovement);
		movementDTO.setQuantity(3L);
		movementDTO.setStockDTO(new StockDTO());
		
		try {
			StockDTO stockDTO = stockService.addMovement(1L, movementDTO);
			assertEquals(3L, stockDTO.getQuantity().longValue());

		} catch (OutOfStockException | StockNotFoundException out) {
			fail();
		} catch (Exception e) {
			fail();
		}

	}

	/*
	 * Se actualiza el stock inicial de un producto con cantidad inicial en cero. Se ingresa una cantidad para ese
	 * producto y el tipo de operación del tipo "out" y se espera que devuelva la existencia
	 * actualizada sin exceptions
	 */
	@Test
	public void addMovementSubtractionSucces() {

		MovementDTO movementDTO = new MovementDTO();
		movementDTO.setType(outMovement);
		movementDTO.setQuantity(3L);
		movementDTO.setStockDTO(new StockDTO());

		try {
			StockDTO stockDTO = stockService.addMovement(2L, movementDTO);
			assertEquals(2L, stockDTO.getQuantity().longValue());

		} catch (OutOfStockException | StockNotFoundException out) {
			fail();
		} catch (Exception e) {
			fail();
		}

	}

	/*
	 * Dado un Stock inicial con existencia
	 * con un id válido y un egreso
	 * se espera una exception OutOfStockException
	 */
	@Test
	public void addMovementWithOutOfStockException() {

		Assertions.assertThrows(OutOfStockException.class, () -> {

			MovementDTO movementDTO = new MovementDTO();
			movementDTO.setType(outMovement);
			movementDTO.setQuantity(3L);
			
			StockDTO stockDTO = stockService.addMovement(1L, movementDTO);
			assertEquals(2L, stockDTO.getQuantity().longValue());

		});
	}


	/*
	 * Dado un Stock inicial
	 * con un id invalido, se adiciona un movimiento de egreso,
	 * se espera una exception StockNotFoundException
	 */
	@Test
	public void addMovementWithStockNotFoundException() {

		Assertions.assertThrows(StockNotFoundException.class, () -> {

			MovementDTO movementDTO = new MovementDTO();
			movementDTO.setType(outMovement);
			movementDTO.setQuantity(3L);
			
			StockDTO stockDTO = stockService.addMovement(4L,movementDTO);
			assertEquals(2L, stockDTO.getQuantity().longValue());

		});
	}
}
