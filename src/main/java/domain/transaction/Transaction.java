package domain.transaction;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import domain.user.User;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name="transactions")
@Table(name="transactions")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of= "id")
public class Transaction {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private BigDecimal anount;
	@ManyToOne
	@JoinColumn(name= "sender_id")
	private User sender;
	@ManyToOne
	@JoinColumn(name= "receiver_id")
	private User reciver;
	private LocalDateTime timestamp;
	
	public Object getAnount() {
		// TODO Auto-generated method stub
		return null;
	}

	public void setAnount(Object anount2) {
		// TODO Auto-generated method stub
		
	}

	public void setSender(User sender2) {
		// TODO Auto-generated method stub
		
	}

	public void setReceiver(User receiver) {
		// TODO Auto-generated method stub
		
	}

	public void setTimetamp(LocalDateTime now) {
		// TODO Auto-generated method stub
		
	}
	

}
