package com.advance.poker;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.HashMap;

import org.junit.Test;

import com.advance.poker.controller.CardGame;
import com.advance.poker.controller.FiveCardDrawPoker;
import com.advance.poker.model.Card;

public class DeckBuilderTest {
	@Test
	public void isDeck52Cards() {
		CardGame cg = new FiveCardDrawPoker();

		assertEquals(52, cg.getDeck().size());
	}

	@Test
	public void testForDuplicates() {
		CardGame cg = new FiveCardDrawPoker();

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
	public void areAllPropertiesGenerated() {
		CardGame cg = new FiveCardDrawPoker();

		// suitIndex -> cardValueIndex -> Card
		HashMap<Integer, HashMap<Integer, Card>> deckMap = new HashMap<>();

		boolean indexProblemFound = false;

		for (Card card : cg.getDeck()) {
			if (deckMap.get(card.getSuitIndex()) == null) {
				deckMap.put(card.getSuitIndex(), new HashMap<>());
			}
			if (deckMap.get(card.getSuitIndex()).get(card.getValueIndex()) == null) {
				deckMap.get(card.getSuitIndex()).put(card.getValueIndex(), card);
			} else {// More than one card with same combination of indexes found
				indexProblemFound = true;
			}
		}

		// Confirms that there isn't two cards with the same index, and that there are 4
		// suits, each suite containing 13 cards
		assertTrue(!indexProblemFound 
				&& deckMap.size() == 4 
				&& deckMap.get(1).size() == 13
				&& deckMap.get(2).size() == 13 
				&& deckMap.get(3).size() == 13 
				&& deckMap.get(4).size() == 13);
	}
}
