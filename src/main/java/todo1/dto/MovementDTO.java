package todo1.dto;

import lombok.Data;

import java.time.LocalTime;

/**
 * 
 * @author Administrator
 *
 */
@Data
public class MovementDTO {

	private StockDTO stockDTO;
	
	private Long id;
	
	private LocalTime date;
	
	private long quantity;
	
	private int type;

}
