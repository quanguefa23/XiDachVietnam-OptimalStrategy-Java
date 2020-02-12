package pack;

public class MainActivity {
	public static void main(String[] args) {
		int coin = 0;
		for (int i = 0; i < 1000000; i++) {
			coin += playGame();
		}
		System.out.println("Coin: " + coin);
	}
	
	public static int playGame() {
		MainPlayer mainPlayer = new MainPlayer();
		Player normalPlayer = new Player();
		CardDeck cardDeck = new CardDeck();
		
		//shuffle card deck 5 times
		cardDeck.shuffle(5);
		
		//send 2 cards to each player
		for (int i = 0; i < 2; i++) {
			normalPlayer.addCard(cardDeck.popCard());
			mainPlayer.addCard(cardDeck.popCard());
		}
		
		//turn of each player
		int t = normalPlayer.play(cardDeck);
		mainPlayer.play(cardDeck, t);
		
		//result
		if (mainPlayer.getPoint() == normalPlayer.getPoint()) {
			return 0;
		}
		else if (mainPlayer.getPoint() > normalPlayer.getPoint()) {
			return 1;
		}
		else {
			return -1;
		}
	}
}
