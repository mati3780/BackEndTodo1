package todo1.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalTime;

/**

 */
@Entity()
public @Data class Movement {

	@Id
	@GeneratedValue
	private Long id;
	
	@Column(name = "date", nullable = false, length = 20)
	private LocalTime date;

	@Column(name = "type", nullable = false, length = 5)
	private int type;

	@Column(name = "quantity", nullable = false, length = 50)
	private long quantity;

}
