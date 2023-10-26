package com.advance.poker.controller;

import java.util.ArrayList;
import java.util.List;

import com.advance.poker.model.Card;

public class DeckBuilder {
	private enum SuitTypes {
		HEARTS, DIAMONDS, CLUBS, SPADES
	}


	public static List<Card> buildDeck() {
		List<Card> deck = new ArrayList<>();
		for (int i = 0; i < SuitTypes.values().length; i++) {
			SuitTypes currentSuit = SuitTypes.values()[i];
			int suitIndex = buildSuitIndex(currentSuit);
			deck.add(new Card(2, "2", currentSuit + "", suitIndex, buildDisplayName("2", currentSuit)));
			deck.add(new Card(3, "3", currentSuit + "", suitIndex, buildDisplayName("3", currentSuit)));
			deck.add(new Card(4, "4", currentSuit + "", suitIndex, buildDisplayName("4", currentSuit)));
			deck.add(new Card(5, "5", currentSuit + "", suitIndex, buildDisplayName("5", currentSuit)));
			deck.add(new Card(6, "6", currentSuit + "", suitIndex, buildDisplayName("6", currentSuit)));
			deck.add(new Card(7, "7", currentSuit + "", suitIndex, buildDisplayName("7", currentSuit)));
			deck.add(new Card(8, "8", currentSuit + "", suitIndex, buildDisplayName("8", currentSuit)));
			deck.add(new Card(9, "9", currentSuit + "", suitIndex, buildDisplayName("9", currentSuit)));
			deck.add(new Card(10, "10", currentSuit + "", suitIndex, buildDisplayName("10", currentSuit)));
			deck.add(new Card(11, "Jack", currentSuit + "", suitIndex, buildDisplayName("J", currentSuit)));
			deck.add(new Card(12, "Queen", currentSuit + "", suitIndex, buildDisplayName("Q", currentSuit)));
			deck.add(new Card(13, "King", currentSuit + "", suitIndex, buildDisplayName("K", currentSuit)));
			deck.add(new Card(14, "Ace", currentSuit + "", suitIndex, buildDisplayName("A", currentSuit)));
		}
		return deck;
	}

	private static int buildSuitIndex(SuitTypes currentSuit) {
		switch (currentSuit) {
		case HEARTS:
			return 1;
		case DIAMONDS:
			return 2;
		case CLUBS:
			return 3;
		case SPADES:
			return 4;
		}
		return 0;
	}

	private static String buildDisplayName(String cardValue, SuitTypes currentSuit) {
		switch (currentSuit) {
		case HEARTS:
			return cardValue + "(H)";
		case DIAMONDS:
			return cardValue + "(D)";
		case CLUBS:
			return cardValue + "(C)";
		case SPADES:
			return cardValue + "(S)";
		}
		return null;
	}
}