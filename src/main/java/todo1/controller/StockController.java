package todo1.controller;

import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import todo1.dto.MovementDTO;
import todo1.dto.StockDTO;
import todo1.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT})
@RequestMapping("/api/v1/stocks")
public class StockController {

	@Autowired
	private StockService stockService;
	/**
	 *
	 * @return list of stocks
	 */
	@GetMapping("")
	public ResponseEntity<Object> get(){
		List<StockDTO> stockDTOList = stockService.getAll();
		return ResponseEntity.ok(stockDTOList);
	}

	/**
	 *
	 * @param
	 * @return
	 */
	@PostMapping("/post")
	public ResponseEntity<Object> create(@Valid @RequestBody StockDTO stockDTO) {
		stockDTO = stockService.add(stockDTO);
		//Create location
		URI location = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(stockDTO.getId())
				.toUri();

		return ResponseEntity.created(location).body(stockDTO);
	}

	/**
	 *
	 * @param id
	 * @return stockDto
	 */
	@PutMapping("/{id}/addMovement")
	public ResponseEntity<Object> addMovement(@PathVariable long id, @Valid @RequestBody MovementDTO movementDTO) {

		StockDTO stockDTO  = stockService.addMovement(id, movementDTO);

		return ResponseEntity.ok(stockDTO);

	}

}
