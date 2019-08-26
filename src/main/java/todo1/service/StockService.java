package todo1.service;

import todo1.dto.MovementDTO;
import todo1.dto.StockDTO;
import todo1.exceptions.OutOfStockException;
import todo1.exceptions.ProductNotFoundException;
import todo1.exceptions.StockNotFoundException;
import todo1.repository.ProductRepository;
import todo1.repository.StockRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import todo1.model.Movement;
import todo1.model.Product;
import todo1.model.Stock;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class StockService implements IStockService{

	@Autowired
	private StockRepository stockRepository;
	
	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private ModelMapper modelMapper;

	private static int inMovement = 1;

	private static int outMovement = 2;

	/**
	 * 
	 * @return
	 */
	public StockDTO add(StockDTO stockDTO) {
		Stock stock = new Stock();
		
		modelMapper.map(stockDTO, stock);
		Product product = productRepository.findById(stockDTO.getProduct().getId())
						.orElseThrow(() -> new ProductNotFoundException(stockDTO.getProduct().getId()));
		stock.setProduct(product);
		stockRepository.save(stock);
		modelMapper.map(stock , stockDTO );
		return stockDTO;

	}
	
	/**
	 * Agrega un Movimiento al Stock
	 * @param id identificador del Stock
	 * @param movementDTO objeto del movimiento
	 * @throws StockNotFoundException Cuando no encuentra el objeto al cual quiere hacer el movimiento.
	 * @throws Exception Cuando una operacion hace que el stock sea menor a cero.
	 */
	public StockDTO addMovement(long id, MovementDTO movementDTO) {

		//En el caso que no se encuentre se lanza excepción
		Stock stock = stockRepository.findById(id)
						.orElseThrow(() -> new StockNotFoundException(id));

		//Compruebo si el movimiento es de entrada o salida de producto
		if(movementDTO.getType() == inMovement) {//Movimiento de entrada
			stock.setQuantity(stock.getQuantity() + movementDTO.getQuantity());
		} else if(movementDTO.getType() == outMovement) {//Movimiento de salida
			long existencia = stock.getQuantity() - movementDTO.getQuantity();

			if(existencia < 0) {
				throw new OutOfStockException(stock.getProduct().getId());
			}

			stock.setQuantity(existencia);
		}
		
		//Se guarda el objeto Movement
		Movement movement = new Movement();
		movement.setQuantity(movementDTO.getQuantity());
		movement.setDate(LocalTime.now());
		movement.setType(movementDTO.getType());
		
		stock.addMovement(movement);
		stockRepository.save(stock);
		
		//actualizo la existencia para mostrarla en el front
		movementDTO.getStockDTO().setQuantity(stock.getQuantity());

		return movementDTO.getStockDTO();
	}

	@Override
	public List<StockDTO> getAll() {
		List<Stock> stockList = stockRepository.findAll();
		List<StockDTO> stockDTOList = new ArrayList<>();
		for (Stock stock:stockList) {
			StockDTO stockDTO = new StockDTO();
			modelMapper.map(stock, stockDTO);

			stockDTOList.add(stockDTO);
		}
		
		return stockDTOList;
	}
	
}
