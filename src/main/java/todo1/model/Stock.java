package todo1.model;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity()
public @Data class Stock {

	@Id
	@GeneratedValue
	private Long id;


	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "product_id", referencedColumnName = "id")
	private Product product;
	
	@OneToMany(
	        cascade = CascadeType.ALL,
	        orphanRemoval = true
	)
	@JoinColumn
	private List<Movement> movementList = new ArrayList<>();
	
	@Column(name = "quantity", nullable = false, length = 5)
	private Long quantity;
	
	/**
	 * 
	 * @param movement
	 */
	public void addMovement(Movement movement) {
		this.movementList.add(movement);
	}

	/**
	 * 
	 * @param movement
	 */
	public void removeMovement(Movement movement) { this.movementList.remove(movement); }
	
}
