package com.advance.poker.controller;

import java.util.List;

import com.advance.poker.controller.utils.CardShuffler;
import com.advance.poker.controller.utils.DeckBuilder;
import com.advance.poker.model.Card;

public abstract class PokerGame {
	protected List<Card> deck;
	protected List<Card> hand;

	protected PokerGame() {
		this.deck = buildDeck();
	}

	/**
	 * Returns a string explaining the highest ranked hand it has.
	 * <p>
	 * 
	 * @return the description of the rank of the hand
	 * 
	 */
	public abstract String evaluateHand();

	/**
	 * Returns a dealt hand of card from the deck
	 * 
	 * @return List of Card
	 * 
	 */
	public abstract List<Card> dealHand();

	public void shuffleDeck() {
		CardShuffler.shuffleCards(deck);
	}

	/**
	 * Returns a full deck of cards, the standard 52 card deck with the 4 suits.
	 * 
	 * @return List of Card
	 */
	private List<Card> buildDeck() {
		return DeckBuilder.buildDeck();
	}

	// Getters for testing
	public List<Card> getDeck() {
		return deck;
	}

	public List<Card> getHand() {
		return hand;
	}

}
