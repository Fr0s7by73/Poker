package com.advance.poker.controller;

import java.util.ArrayList;
import java.util.List;

import com.advance.poker.controller.utils.CardShuffler;
import com.advance.poker.controller.utils.DeckBuilder;
import com.advance.poker.model.Card;

public abstract class CardGame {
	protected List<Card> deck;
	protected List<Card> hand;

	protected CardGame() {
		this.deck = buildDeck();
	}

	public void shuffleDeck() {
		CardShuffler.shuffleCards(deck);
	}
	
	private List<Card> buildDeck() {
		return DeckBuilder.buildDeck();
	}

	/**
	 * Returns a string explaining the highest ranked hand it has. 
	 * <p>
	 * You should
	 * override this method in the subclass depending on how the ranking works for
	 * that game
	 * 
	 * @return the description of the rank of the hand
	 * 
	 */
	public String evaluateHand() {
		return "";
	}	

	public List<Card> dealHand() {
		return new ArrayList<>();
	}

	//Getters for testing
	public List<Card> getDeck() {
		return deck;
	}

	public List<Card> getHand() {
		return hand;
	}
	
	
	
}
