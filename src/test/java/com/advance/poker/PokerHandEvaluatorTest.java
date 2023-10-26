package com.advance.poker;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.advance.poker.controller.PokerHandEvaluator;
import com.advance.poker.model.Card;

public class PokerHandEvaluatorTest {

	@Test
	public void identifyPair() {

		List<Card> hand = new ArrayList<>();
		hand.add(new Card(11, "Jack", "DIAMONDS", 2, ""));
		hand.add(new Card(5, "5", "HEARTS", 1, ""));
		hand.add(new Card(8, "8", "HEARTS", 1, ""));
		hand.add(new Card(2, "2", "HEARTS", 1, ""));
		hand.add(new Card(11, "Jack", "HEARTS", 1, ""));

		String handRank = PokerHandEvaluator.findHighestRankedPokerHand(hand);
		assertEquals("Pair", handRank);
	}

	@Test
	public void identifyTwoPair() {
		List<Card> hand = new ArrayList<>();
		hand.add(new Card(11, "Jack", "DIAMONDS", 2, ""));
		hand.add(new Card(5, "5", "HEARTS", 1, ""));
		hand.add(new Card(8, "8", "HEARTS", 1, ""));
		hand.add(new Card(5, "5", "DIAMONDS", 2, ""));
		hand.add(new Card(11, "Jack", "HEARTS", 1, ""));

		String handRank = PokerHandEvaluator.findHighestRankedPokerHand(hand);
		assertEquals("Two Pair", handRank);
	}

	@Test
	public void identifyThreeOfAKind() {
		List<Card> hand = new ArrayList<>();
		hand.add(new Card(11, "Jack", "DIAMONDS", 2, ""));
		hand.add(new Card(5, "5", "HEARTS", 1, ""));
		hand.add(new Card(11, "Jack", "CLUBS", 3, ""));
		hand.add(new Card(4, "4", "DIAMONDS", 2, ""));
		hand.add(new Card(11, "Jack", "HEARTS", 1, ""));

		String handRank = PokerHandEvaluator.findHighestRankedPokerHand(hand);
		assertEquals("Three of a Kind", handRank);
	}

	@Test
	public void identifyStraight() {
		List<Card> hand = new ArrayList<>();
		hand.add(new Card(10, "10", "CLUBS", 3, ""));
		hand.add(new Card(12, "Queen", "HEARTS", 1, ""));
		hand.add(new Card(8, "8", "DIAMONDS", 2, ""));
		hand.add(new Card(11, "Jack", "DIAMONDS", 2, ""));
		hand.add(new Card(9, "9", "HEARTS", 1, ""));

		String handRank = PokerHandEvaluator.findHighestRankedPokerHand(hand);
		assertEquals("Straight", handRank);
	}

	@Test
	public void identifyFlush() {
		List<Card> hand = new ArrayList<>();
		hand.add(new Card(4, "4", "HEARTS", 1, ""));
		hand.add(new Card(12, "Queen", "HEARTS", 1, ""));
		hand.add(new Card(8, "8", "HEARTS", 1, ""));
		hand.add(new Card(11, "Jack", "HEARTS", 1, ""));
		hand.add(new Card(9, "9", "HEARTS", 1, ""));

		String handRank = PokerHandEvaluator.findHighestRankedPokerHand(hand);
		assertEquals("Flush", handRank);
	}

	@Test
	public void identifyFullHouse() {
		List<Card> hand = new ArrayList<>();
		hand.add(new Card(4, "4", "HEARTS", 1, ""));
		hand.add(new Card(8, "8", "HEARTS", 1, ""));
		hand.add(new Card(4, "4", "DIAMONDS", 2, ""));
		hand.add(new Card(8, "8", "CLUBS", 3, ""));
		hand.add(new Card(4, "4", "CLUBS", 3, ""));

		String handRank = PokerHandEvaluator.findHighestRankedPokerHand(hand);
		assertEquals("Full House", handRank);
	}

	@Test
	public void identifyFourOfAKind() {
		List<Card> hand = new ArrayList<>();
		hand.add(new Card(4, "4", "HEARTS", 1, ""));
		hand.add(new Card(8, "8", "HEARTS", 1, ""));
		hand.add(new Card(4, "4", "DIAMONDS", 2, ""));
		hand.add(new Card(4, "4", "SPADES", 4, ""));
		hand.add(new Card(4, "4", "CLUBS", 3, ""));

		String handRank = PokerHandEvaluator.findHighestRankedPokerHand(hand);
		assertEquals("Four of a Kind", handRank);
	}

	@Test
	public void identifyStraightFlush() {
		List<Card> hand = new ArrayList<>();
		hand.add(new Card(8, "8", "HEARTS", 1, ""));
		hand.add(new Card(10, "10", "HEARTS", 1, ""));
		hand.add(new Card(9, "9", "HEARTS", 1, ""));
		hand.add(new Card(12, "Queen", "HEARTS", 1, ""));
		hand.add(new Card(11, "Jack", "HEARTS", 1, ""));

		String handRank = PokerHandEvaluator.findHighestRankedPokerHand(hand);
		assertEquals("Straight Flush", handRank);
	}

	@Test
	public void identifyHighCard() {
		List<Card> hand = new ArrayList<>();
		hand.add(new Card(5, "5", "HEARTS", 1, ""));
		hand.add(new Card(8, "8", "HEARTS", 1, ""));
		hand.add(new Card(11, "Jack", "DIAMONDS", 2, "Jd"));
		hand.add(new Card(2, "2", "HEARTS", 1, ""));
		hand.add(new Card(10, "10", "HEARTS", 1, ""));

		String handRank = PokerHandEvaluator.findHighestRankedPokerHand(hand);
		assertEquals("High card with Jd", handRank);
	}
}
