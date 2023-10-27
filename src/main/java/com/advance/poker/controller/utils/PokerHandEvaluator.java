package com.advance.poker.controller.utils;

import java.util.Collections;
import java.util.List;

import com.advance.poker.model.Card;

/*
 * I got the code from here:
 * https://github.com/dpdev69/Coding-Samples/blob/master/CMSC131-Project6/
 * PokerHandEvaluator.java
 * 
 * I had to make some minor adjustments to cater for my structure, I created my
 * own unit tests to make sure the code works
 * 
 * hasTwoPair and hasStraight had bugs, so I rewrote those two methods.
 * 
 * I also added the findHighestRankedPokerHand and getHighCard methods.
 * 
 */
public class PokerHandEvaluator {

	private PokerHandEvaluator() {}

	// Static method that shows when the hand has a straight flush.
	public static boolean hasStraightFlush(List<Card> cards) {
		return hasStraight(cards) && hasFlush(cards);
	}

	// Static method that shows when the hand has four of a kind.
	public static boolean hasFourOfAKind(List<Card> cards) {
		for (int idx = 0; idx < cards.size() - 1; idx++) {
			for (int card1 = idx + 1; card1 < cards.size(); card1++) {
				for (int card2 = card1 + 1; card2 < cards.size(); card2++) {
					for (int card3 = card2 + 1; card3 < cards.size(); card3++) {
						if (cards.get(card1).getValueIndex() == cards.get(idx).getValueIndex()
								&& cards.get(card2).getValueIndex() == cards.get(card1).getValueIndex()
								&& cards.get(card1).getValueIndex() == cards.get(card3).getValueIndex()) {
							return true;
						}
					}
				}
			}
		}

		return false;
	}

	// Static method that shows when the hand has a Full House.
	public static boolean hasFullHouse(List<Card> cards) {
		return (hasThreeOfAKind(cards) && hasTwoPair(cards));
	}

	// Static method that shows when the hand has a flush.
	public static boolean hasFlush(List<Card> cards) {
		int counter = 0;
		int cardSuit = cards.get(0).getSuitIndex();
		for (int idx = 1; idx < cards.size(); idx++) {
			if (cardSuit == cards.get(idx).getSuitIndex()) {
				counter++;
			}

			if (counter == 4) {
				return true;
			}
		}

		return false;
	}

	// Static method that shows when a hand has a straight set.
	public static boolean hasStraight(List<Card> cards) {
		Collections.sort(cards);
		for (int i = 0; i < cards.size() - 1; i++) {
			if (cards.get(i).getValueIndex() + 1 != cards.get(i + 1).getValueIndex()) {
				return false;
			}
		}
		return true;
	}

	// Static method that shows when the hand has three of a kind.
	public static boolean hasThreeOfAKind(List<Card> cards) {
		for (int idx = 0; idx < cards.size() - 1; idx++) {
			for (int card1 = idx + 1; card1 < cards.size(); card1++) {
				for (int card2 = card1 + 1; card2 < cards.size(); card2++) {
					if (cards.get(card1).getValueIndex() == cards.get(idx).getValueIndex()
							&& cards.get(card2).getValueIndex() == cards.get(card1).getValueIndex()) {
						return true;
					}
				}
			}
		}

		return false;
	}

	// Static method that shows when a hand has two pairs.
	public static boolean hasTwoPair(List<Card> cards) {
		Collections.sort(cards);
		int pairFoundForValueIndex = -1;
		int countPairs = 0;
		for (int i = 0; i < cards.size(); i++) {
			// This makes sure that three or four of a kind is not seen as two pairs, important for the Full House test to work
			if (cards.get(i).getValueIndex() == pairFoundForValueIndex) {
				continue;
			}

			for (int j = i; j < cards.size() - 1; j++) {
				if (cards.get(i).getValueIndex() == cards.get(j + 1).getValueIndex()) {
					countPairs++;
					pairFoundForValueIndex = cards.get(i).getValueIndex();
					break;
				}
			}
		}
		return countPairs == 2;
	}

	// Static method that shows when a hand has a pair.
	public static boolean hasPair(List<Card> cards) {
		for (int idx = 0; idx < cards.size() - 1; idx++) {
			for (int card = idx + 1; card < cards.size(); card++) {
				if (cards.get(card).getValueIndex() == cards.get(idx).getValueIndex()) {
					return true;
				}
			}
		}

		return false;
	}

	// Static method to get the highest card.
	public static Card getHighCard(List<Card> cards) {
		Collections.sort(cards);
		return (cards.get(cards.size() - 1));
	}

}
