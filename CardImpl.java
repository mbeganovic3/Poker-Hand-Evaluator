package a2;

public class CardImpl implements Card {
	
	int rank;
	Card.Suit suite;
	
	public CardImpl(int rank, Card.Suit suite) {
		this.rank = rank;
			if(this.rank < 2) {
				throw new RuntimeException("Card rank out of range (smaller than 2).");
			}else if(this.rank > 14) {
				throw new RuntimeException("Card rank out of range (larger than 14).");
			}
		
		this.suite = suite;
	}

	
	public int getRank() {
			return this.rank;
		} 
	
	public String getRankAsString() {
		if(this.rank == 2) {
			return "Two";
		}else if(this.rank == 3) {
			return "Three";
		}else if(this.rank == 4) {
			return "Four";
		}else if(this.rank == 5) {
			return "Five";
		}else if(this.rank == 6) {
			return "Six";
		}else if(this.rank == 7) {
			return "Seven";
		}else if(this.rank == 8) {
			return "Eight";
		}else if(this.rank == 9) {
			return "Nine";
		}else if(this.rank == 10) {
			return "Ten";
		}else if(this.rank == 11) {
			return "Jack";
		}else if(this.rank == 12) {
			return "Queen";
		}else if(this.rank == 13) {
			return "King";
		}else if(this.rank == 14) {
			return "Ace";
		}else {
			return null;
		}
	}

	public Suit getSuit() {
		return this.suite;
	}
	
	public String toString() {
		return getRankAsString() + "of " + Card.suitToString(suite);
	}

	public boolean equals(Card other) {
		if (this.rank == other.getRank() && this.suite == other.getSuit()) {
			return true;
		} else {
			return false;
		}
	}

}
