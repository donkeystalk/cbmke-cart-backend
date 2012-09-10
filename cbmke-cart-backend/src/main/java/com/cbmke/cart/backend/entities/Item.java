package com.cbmke.cart.backend.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="ITEMS")
public class Item {

	@Id 
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	private String name;
	
	private String description;
	
	private String manaCost;
	
	private Integer convertedManaCost;
	
	private Integer quantity;
	
	private Integer score;
	
	private Integer numVotes;
	
	@OneToOne
	@JoinColumn(name="CARDTYPES_ID")
	private CardType cardType;
	
	public Integer getScore() {
		return score;
	}
	
	public void setScore(Integer score) {
		this.score = score;
	}
	
	public Integer getNumVotes() {
		return numVotes;
	}
	
	public void setNumVotes(Integer numVotes) {
		this.numVotes = numVotes;
	}
	
	public Integer getConvertedManaCost() {
		return convertedManaCost;
	}
	
	public void setConvertedManaCost(Integer convertedManaCost) {
		this.convertedManaCost = convertedManaCost;
	}
	
	public String getManaCost() {
		return manaCost;
	}
	
	public void setManaCost(String manaCost) {
		this.manaCost = manaCost;
	}
	
	public CardType getCardType() {
		return cardType;
	}
	
	public Integer getQuantity() {
		return quantity;
	}
	
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getId() {
		return id;
	}
	
}
