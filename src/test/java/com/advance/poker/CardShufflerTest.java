package com.advance.poker;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;

import com.advance.poker.controller.FiveCardDrawPoker;
import com.advance.poker.controller.PokerGame;
import com.advance.poker.model.Card;

public class CardShufflerTest {
	@Test
	public void testForDuplicates() {
		PokerGame cg = new FiveCardDrawPoker();

		cg.shuffleDeck();
		boolean duplicateCardFound = false;

		while (cg.getDeck().size() > 0) {
			Card card = cg.getDeck().get(0);
			cg.getDeck().remove(0);
			if (cg.getDeck().contains(card)) {
				duplicateCardFound = true;
				break;
			}
		}

		assertEquals(false, duplicateCardFound);
	}

	@Test
	public void sameCardsInTheDeck() {
		PokerGame cg = new FiveCardDrawPoker();
		List<Card> deckCopy = List.copyOf(cg.getDeck());

		cg.shuffleDeck();
		boolean cardNotFound = false;

		for (int i = 0; i < deckCopy.size(); i++) {
			if (!cg.getDeck().contains(deckCopy.get(i))) {
				cardNotFound = true;
				break;
			}
		}

		assertEquals(false, cardNotFound);
	}

	@Test
	public void isSizeOfDeckStillSame() {
		PokerGame cg = new FiveCardDrawPoker();
		List<Card> deckCopy = List.copyOf(cg.getDeck());

		cg.shuffleDeck();

		assertEquals(deckCopy.size(), cg.getDeck().size());
	}

	@Test
	public void isCardsInDifferentOrder() {
		PokerGame cg = new FiveCardDrawPoker();
		List<Card> deckCopy = List.copyOf(cg.getDeck());

		cg.shuffleDeck();
		boolean differenceInOrderFound = false;

		for (int i = 0; i < cg.getDeck().size(); i++) {
			if (cg.getDeck().get(i) != deckCopy.get(i)) {
				differenceInOrderFound = true;
				break;
			}
		}

		assertEquals(true, differenceInOrderFound);
	}
}
