package amulya.gamingclub.entities;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;


@Entity
@Table(name="transactions")

public class Transaction {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int  id;
	@ManyToOne
	@JoinColumn(name="member_id")
	private Member members;
	@ManyToOne
	@JoinColumn(name="game_id")
	private Game games;
	private float amount;
	private LocalDateTime dateTime=LocalDateTime.now();
	
	public Transaction() {}
	public Transaction(Member member, Game games, float amount, LocalDateTime date) {
		super();
		this.members = member;
		this.games = games;
		this.amount = amount;
		this.dateTime = dateTime;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Member getMember() {
		return members;
	}
	public void setMember(Member member) {
		this.members = member;
	}
	public Game getGames() {
		return games;
	}
	public void setGames(Game games) {
		this.games = games;
	}
	public float getAmount() {
		return amount;
	}
	public void setAmount(float amount) {
		this.amount = amount;
	}
	public LocalDateTime getDateTime() {
		return dateTime;
	}
	public void setDateTime(LocalDateTime dateTime) {
		this.dateTime = dateTime;
	}
	
}
