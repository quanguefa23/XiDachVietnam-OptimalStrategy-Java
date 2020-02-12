package pack;

import java.util.ArrayList;

public class Player {
	ArrayList<Card> listCard;
	int point; //-1: what, 22: 5 link, 23: A10, 24: AA 
	
	public Player() {
		listCard = new ArrayList<>();
		point = 0;
	}
	
	public void addCard(Card card) {
		listCard.add(card);
		
		//recalculate the point
		point = 0;
		if (getNumberOfCard() == 2) { //2 cards -> can be AA or A10
			if (listCard.get(0).isA() && listCard.get(1).isA()) {
				point = 24;
				return;
			}
			
			if (listCard.get(0).isTen() && listCard.get(1).isA()) {
				point = 23;
				return;
			}
			
			if (listCard.get(0).isA() && listCard.get(1).isTen()) {
				point = 23;
				return;
			}
		}
		
		//normal case
		for (Card c : listCard) {
			int p = c.getRank() >= 10 ? 10 : c.getRank();
			point += p;
		}
		
		//A: special card, need more configurations
		if (hasA()) {
			point--;
			
			if (point >= 12) {
				point++;
			}
			else if (point == 11) {
				point += 10;
			}
			else {
				point += 11;
			}
		}
		
		//5 cards
		if (point <= 21 && getNumberOfCard() == 5) {
			point = 22;
			return;
		}
			
		//
		if (point > 21)
			point = -1;
	}
	
	public int getPoint() {
		return point;
	}
	
	public int play(CardDeck cardDeck) {
		while (listCard.size() < 5 && point <= 21 && point >= 0) {
			//calculate the break point
			int breakPoint = 0;
			
			if (hasA()) {
				breakPoint = 18;
			}
			else {
				if (getNumberOfCard() == 2) {
					breakPoint = 16;
				}
				else {
					breakPoint = 17;
				}
			}
			
			//stop-addCard condition
			if (point >= breakPoint) {
				 break;
			}
			
			addCard(cardDeck.popCard());
		}
		
		return getNumberOfCard();
	}
	
	public boolean hasA() {
		for (Card card : listCard) {
			if (card.isA())
				return true;
		}
		return false;
	}

	public void printAllCard() {
		for (Card card : listCard) {
			System.out.print(card.toString() + " | ");
		}
		System.out.println(point);
	}
	
	public int getNumberOfCard() {
		return listCard.size();
	}
	
	
}
