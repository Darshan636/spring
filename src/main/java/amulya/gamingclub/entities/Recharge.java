package amulya.gamingclub.entities;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="recharges")

public class Recharge {
	public Recharge() {}
	public Recharge(Member member, float amount, LocalDateTime dateTime) {
		super();
		this.member = member;
		this.amount = amount;
		this.dateTime = dateTime;
	}
	@Id
	private int  id;
	@ManyToOne
	@JoinColumn(name="member_id")
	private Member member;
	private float amount;
	private LocalDateTime dateTime=LocalDateTime.now();
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Member getMember() {
		return member;
	}
	public void setMember(Member member) {
		this.member = member;
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

