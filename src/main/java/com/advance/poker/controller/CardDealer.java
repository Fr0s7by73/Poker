package com.advance.poker.controller;

import java.util.ArrayList;
import java.util.List;

import com.advance.poker.model.Card;

public class CardDealer {
	// Adding a private constructor to hide the implicit public one.
	private CardDealer() {}

	public static List<Card> dealHand(List<Card> deck) {
		List<Card> hand = new ArrayList<>();
		if (deck.size() >= 5) {
			for (int i = 0; i < 5; i++) {
				// Add top card to hand
				hand.add(deck.get(0));
				
				// Remove card from deck to make sure it can't be drawn again
				deck.remove(0);
			}
		}
		return hand;
	}
}
