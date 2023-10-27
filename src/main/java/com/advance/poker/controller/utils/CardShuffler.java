package com.advance.poker.controller.utils;

import java.util.Collections;
import java.util.List;

import com.advance.poker.model.Card;

public class CardShuffler {
	private CardShuffler() {}

	/**
	 * This shuffles an List<Card> collection, useful when you want to randomize a
	 * deck
	 * 
	 * @param cards
	 */
	public static void shuffleCards(List<Card> cards) {
		Collections.shuffle(cards);
	}
}
