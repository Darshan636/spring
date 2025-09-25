package amulya.gamingclub.entities;

import java.time.LocalDate;
import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;



@Entity
@Table(name="collections")
public class Collection {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int  id;
	private LocalDate date = LocalDate.now();
	private float amount;
	
	
	public Collection() {}
	public Collection(LocalDate date, float amount) {
		super();
		this.date = date;
		this.amount = amount;
	}
	
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public LocalDate getDateTime() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	public float getAmount() {
		return amount;
	}
	public void setAmount(float amount) {
		this.amount = amount;
	}
	
}
	