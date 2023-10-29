package com.advance.poker.view;

import java.util.List;

import com.advance.poker.controller.FiveCardDrawPoker;
import com.advance.poker.controller.PokerGame;
import com.advance.poker.model.Card;

public class PokerMain {

	public static void main(String[] args) {
		PokerGame game = new FiveCardDrawPoker();

		// Let's shuffle the deck, printing the shuffle 3 times to give the user the
		// perception that we shuffled a couple of times:
		game.shuffleDeck();
		for (int i = 0; i < 3; i++) {
			System.out.print("Shuffling ... ");
			sleep(750);
		}

		// Draw cards
		List<Card> hand = game.dealHand();

		// Display hand
		System.out.print(System.lineSeparator() + "Your hand: ");
		for (Card card : hand) {
			System.out.print(card.getDisplayValue() + " ");
		}

		// Evaluate hand
		String highestRankedHand = game.evaluateHand();
		// Display highest ranked poker hand
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
