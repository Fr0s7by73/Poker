package com.advance.poker;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.Test;

import com.advance.poker.model.Card;

public class CardTester {
	@Test
	public void sortHand() {
		List<Card> hand = new ArrayList<>();
		hand.add(new Card(8, "8", "HEARTS", 1, ""));
		hand.add(new Card(4, "4", "DIAMONDS", 2, ""));
		hand.add(new Card(4, "4", "HEARTS", 1, ""));
		hand.add(new Card(11, "Jack", "HEARTS", 1, ""));
		hand.add(new Card(2, "2", "CLUBS", 3, ""));

		Collections.sort(hand);
		assertTrue(hand.get(0).getValueIndex() == 2 && hand.get(1).getValueIndex() == 4
				&& hand.get(2).getValueIndex() == 4 && hand.get(3).getValueIndex() == 8
				&& hand.get(4).getValueIndex() == 11);

	}

}
