package todo1.service;

import todo1.dto.MovementDTO;
import todo1.dto.StockDTO;

import java.util.List;

public interface IStockService {

	public List<StockDTO> getAll();
	
	public StockDTO add(StockDTO stockDTO);
	
	public StockDTO addMovement(long id, MovementDTO movementDTO);

}
