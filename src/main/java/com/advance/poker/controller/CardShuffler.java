package com.advance.poker.controller;

import java.util.Collections;
import java.util.List;

import com.advance.poker.model.Card;

public class CardShuffler {
	public static void shuffleCards(List<Card> deck) {		
		Collections.shuffle(deck);
		try {
			Thread.sleep(750l);
		} catch (InterruptedException e) {
			// TODO: log with logback
			e.printStackTrace();
		}
	}
}
