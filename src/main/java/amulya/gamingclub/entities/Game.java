package amulya.gamingclub.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import jakarta.persistence.*;

@Entity
@Table(name="games")

public class Game {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
private int  id;
private String name;
private String description;
private float amount;




public Game() {}
public Game(String name, String description, float amount) {
	super();
	this.name = name;
	this.description = description;
	this.amount = amount;
	
}


public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getDescription() {
	return description;
}
public void setDescription(String description) {
	this.description = description;
}
public float getAmount() {
	return amount;
}
public void setAmount(float amount) {
	this.amount = amount;
}

}
