package com.advance.poker.view;

import java.util.List;

import com.advance.poker.controller.CardDealer;
import com.advance.poker.controller.CardShuffler;
import com.advance.poker.controller.DeckBuilder;
import com.advance.poker.controller.PokerHandEvaluator;
import com.advance.poker.model.Card;

/**
 * Hello world!
 *
 */
public class PokerMain {
	
	public static void main(String[] args) {
		List<Card> deck = DeckBuilder.buildDeck();
		
		// Let's shuffle three times:
		for (int i = 0; i < 3; i++) {
			System.out.print("Shuffling ... ");
			CardShuffler.shuffleCards(deck);
		}
		
		// Draw cards
		List<Card> hand = CardDealer.dealHand(deck);
		
		// Display hand
		System.out.print(System.lineSeparator() + "Your hand: ");
		for (Card card : hand) {
			System.out.print(card.getDisplayValue() + " ");
		}
		
		// Display highest ranked poker hand
		String highestRankedHand = PokerHandEvaluator.findHighestRankedPokerHand(hand);
		System.out.println(System.lineSeparator() + "You have: " + highestRankedHand);
	}
}
