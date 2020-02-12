package pack;

public class MainPlayer extends Player {
	public void play(CardDeck cardDeck, int turn) {
		while (listCard.size() < 5 && point <= 21 && point >= 0) {
			//calculate the break point
			int breakPoint = 0;
			if (hasA()) {
				breakPoint = turn > 2 ? 17 : 18;
			}
			else {
				switch(turn) {
					case 2: {
						breakPoint = 17;
						break;
					}
					case 3: {
						breakPoint = 16;
						break;
					}
					case 4: case 5: {
						breakPoint = 15;
						break;
					}
				}
			}
			
			
			//stop-addCard condition
			if (point >= breakPoint) {
				 break;
			}
			
			addCard(cardDeck.popCard());
		}
	}
}