package com.advance.poker.controller;

import java.util.ArrayList;
import java.util.List;

import com.advance.poker.controller.utils.PokerHandEvaluator;
import com.advance.poker.model.Card;

public class FiveCardDrawPoker extends CardGame {

	public FiveCardDrawPoker() {
		super();
	}
	
	public FiveCardDrawPoker(List<Card> hand) {
		this.hand = hand;		
	}

	@Override
	public List<Card> dealHand() {
		hand = new ArrayList<>();
		if (deck.size() >= 5) {
			while (hand.size() < 5) {
				// Add top card to hand
				hand.add(deck.get(0));

				// Remove card from deck to make sure it can't be drawn again
				deck.remove(0);
			}
		}
		return hand;
	}

	@Override
	public String evaluateHand() {
		if (PokerHandEvaluator.hasStraightFlush(hand)) {
			return "Straight Flush";
		} else if (PokerHandEvaluator.hasFourOfAKind(hand)) {
			return "Four of a Kind";
		} else if (PokerHandEvaluator.hasFullHouse(hand)) {
			return "Full House";
		} else if (PokerHandEvaluator.hasFlush(hand)) {
			return "Flush";
		} else if (PokerHandEvaluator.hasStraight(hand)) {
			return "Straight";
		} else if (PokerHandEvaluator.hasThreeOfAKind(hand)) {
			return "Three of a Kind";
		} else if (PokerHandEvaluator.hasTwoPair(hand)) {
			return "Two Pair";
		} else if (PokerHandEvaluator.hasPair(hand)) {
			return "Pair";
		}
		// Nothing found, what is the high card?
		Card highCard = PokerHandEvaluator.getHighCard(hand);
		return "High card with " + highCard.getDisplayValue();
	}
}
