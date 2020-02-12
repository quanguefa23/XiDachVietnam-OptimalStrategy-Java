package pack;

import java.util.*;

public class CardDeck {
	ArrayList<Card> listCard;
	
	public CardDeck() {
		listCard = new ArrayList<>();
		for (int i = 0; i < 52; i++) {
			listCard.add(new Card(i / 4 + 1, i % 4));
		}
	}
	
	public void shuffle(int time) {
		for (int i = 0; i < time; i++) {
			Collections.shuffle(listCard);
		}
	}
	
	public Card popCard() {
		return listCard.remove(listCard.size() - 1);
	}
	
	public int getNumberOfCard() {
		return listCard.size();
	}
}
