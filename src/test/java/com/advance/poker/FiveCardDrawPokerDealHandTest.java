package com.advance.poker;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.advance.poker.controller.PokerGame;
import com.advance.poker.controller.FiveCardDrawPoker;

public class FiveCardDrawPokerDealHandTest {
	@Test
	public void dealhand() {
		/*Build a five card deck, deal cards from that deck.
		 * if the hand is 5 cards, and the deck is empty, then the 
		 * deal worked
		 */
		PokerGame cg = new FiveCardDrawPoker();
		while (cg.getDeck().size() > 5) {
			cg.getDeck().remove(0);
		}
		
		cg.dealHand();
		
		assertTrue(cg.getDeck().size() == 0 && cg.getHand().size() == 5);
	}
}
