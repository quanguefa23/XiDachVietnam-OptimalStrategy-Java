package pack;

public class Card {
	int rank; //1 - 13: A, 2, 3,..., 10, J, Q, K
	int suit; //0 - 3: spade, club, diamond, heart
	
	public Card(int rank, int suit) {
		this.rank = rank;
		this.suit = suit;
	}
	
	public String toString() {
		String rankString;
		switch(rank) {
			case 1: {
				rankString = "A";
				break;
			}
			case 11: {
				rankString = "J";
				break;
			}
			case 12: {
				rankString = "Q";
				break;
			}
			case 13: {
				rankString = "K";
				break;
			}
			default: 
				rankString = Integer.toString(rank);
		}
		
		String[] suitArray = {"spade", "club", "diamond", "heart"};
		String suitString = suitArray[suit];
		
		return rankString + "-" + suitString;
	}
	
	public boolean isA() {
		return rank == 1;
	}
	
	public boolean isTen() {
		return rank >= 10;
	}
	
	public int getRank() {
		return rank;
	}
}
