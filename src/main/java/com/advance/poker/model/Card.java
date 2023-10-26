package com.advance.poker.model;

import java.util.Objects;

public class Card implements Comparable<Card> {
	private String value;
	private int valueIndex;
	private String suit;
	private int suitIndex;
	private String displayValue;

	public Card(int valueIndex, String value, String suit, int suitIndex, String displayValue) {
		this.valueIndex = valueIndex;
		this.value = value;
		this.suit = suit;
		this.suitIndex = suitIndex;
		this.displayValue = displayValue;
	}

	public int getValueIndex() {
		return valueIndex;
	}

	public void setValueIndex(int valueIndex) {
		this.valueIndex = valueIndex;
	}
	
	public String getSuit() {
		return suit;
	}

	public void setSuit(String suit) {
		this.suit = suit;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getDisplayValue() {
		return displayValue;
	}

	public void setDisplayValue(String displayValue) {
		this.displayValue = displayValue;
	}

	public int getSuitIndex() {
		return suitIndex;
	}

	public void setSuitIndex(int suitIndex) {
		this.suitIndex = suitIndex;
	}

	@Override
	public int compareTo(Card o) {
		if (this.valueIndex != o.valueIndex) {
			return this.valueIndex - o.valueIndex;
		} 
		return this.suitIndex - o.suitIndex;		 
	}

	@Override
	public int hashCode() {
		return Objects.hash(suitIndex, valueIndex);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Card other = (Card) obj;
		return suitIndex == other.suitIndex && valueIndex == other.valueIndex;
	}



}
