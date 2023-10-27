package com.advance.poker.view;

import java.util.List;

import com.advance.poker.controller.CardGame;
import com.advance.poker.controller.FiveCardDrawPoker;
import com.advance.poker.model.Card;

public class PokerMain {

	public static void main(String[] args) {
		CardGame game = new FiveCardDrawPoker();
		
		// Let's shuffle three times:
		for (int i = 0; i < 3; i++) {
			System.out.print("Shuffling ... ");
			game.shuffleDeck();
			sleep(750);
		}

		// Draw cards
		List<Card> hand = game.dealHand();

		// Display hand
		System.out.print(System.lineSeparator() + "Your hand: ");
		for (Card card : hand) {
			System.out.print(card.getDisplayValue() + " ");
		}

		// Display highest ranked poker hand
		String highestRankedHand = game.evaluateHand();
		System.out.println(System.lineSeparator() + "You have: " + highestRankedHand);
	}

	private static void sleep(long milliseconds) {
		try {
			Thread.sleep(milliseconds);
		} catch (InterruptedException e) { 
			e.printStackTrace();
			Thread.currentThread().interrupt();
		}
	}
}
