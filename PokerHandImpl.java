package a2;

import a2.Card;

public class PokerHandImpl implements PokerHand{
	
	Card[] cards;
	private int handRank = 0;
	private int handRankStraight = 0;
	private int handRankFlush = 0;
	private int handValue = 1;
	
	public PokerHandImpl(Card[] cards) {
	
				if(cards == null || cards.length != 5) {
					throw new RuntimeException("Not enough cards");
				}
			
				for (int counter = 0; counter < cards.length; counter++) {
					if(cards[counter] == null) {
						throw new RuntimeException("Theres a blank card");
					}else if(cards[counter].getSuit() == null) {
						throw new RuntimeException("One of the values of the card is blank");
					}
				}
				
			this.cards = cards.clone();
			
				for (int i = 0; i < this.cards.length; i++) {
					  for (int j = i + 1; j < this.cards.length; j++) {
					    if (this.cards[i].getRank() > this.cards[j].getRank()) {
					      Card tmp = this.cards[i];
					      this.cards[i] = this.cards[j];
					      this.cards[j] = tmp;
					    }
					  }
					}	
				
			handRank = this.cards[4].getRank();
	}	
	
	public Card[] getCards() {
		return cards.clone();
	}

	public boolean contains(Card c) {
		for(int i = 0; i < this.cards.length; i++) {
			if(this.cards[i].equals(c)) {
				return  true;
			}
		}
		return false;
	}

	public boolean isOnePair() {
		if(this.cards[0].getRank() == this.cards[1].getRank() && isTwoPair() == false && isThreeOfAKind() == false 
				&& isFourOfAKind() == false && isFullHouse() == false) {
			handRank = this.cards[0].getRank();
			handValue = 2;
			return true;
		}else if (this.cards[1].getRank() == this.cards[2].getRank() && isTwoPair() == false && isThreeOfAKind() == false 
				&& isFourOfAKind() == false && isFullHouse() == false) {
			handRank = this.cards[1].getRank();
			handValue = 2;
			return true;
		}else if (this.cards[2].getRank() == this.cards[3].getRank() && isTwoPair() == false && isThreeOfAKind() == false 
				&& isFourOfAKind() == false && isFullHouse() == false) {
			handRank = this.cards[2].getRank();
			handValue = 2;
			return true;
		}else if (this.cards[3].getRank() == this.cards[4].getRank() && isTwoPair() == false && isThreeOfAKind() == false 
				&& isFourOfAKind() == false && isFullHouse() == false) {
			handRank = this.cards[0].getRank();
			handValue = 2;
			return true;
		}else {
		return false;
		}
	}

	public boolean isTwoPair() {
		if(this.cards[0].getRank() == this.cards[1].getRank() && this.cards[1].getRank() != this.cards[2].getRank() 
				&& this.cards[2].getRank() == this.cards[3].getRank() &&
				this.cards[3].getRank() != this.cards[4].getRank()) {
			if(this.cards[0].getRank() > this.cards[2].getRank()) {
				handRank = this.cards[0].getRank();
				handValue = 3;
			}else if(this.cards[0].getRank() < this.cards[2].getRank()) {
				handRank = this.cards[2].getRank();
				handValue = 3;
			}else if(this.cards[0].getRank() == this.cards[2].getRank()) {
				handRank = this.cards[0].getRank();
				handValue = 3;
			}
			return true;
		}else if(this.cards[0].getRank() == this.cards[1].getRank() && this.cards[3].getRank() == this.cards[4].getRank() 
				&& this.cards[1].getRank() != this.cards[2].getRank() &&
				this.cards[3].getRank() != this.cards[2].getRank()) {
			if(this.cards[0].getRank() > this.cards[3].getRank()) {
				handRank = this.cards[0].getRank();
				handValue = 3;
			}else if(this.cards[0].getRank() < this.cards[3].getRank()) {
				handRank = this.cards[3].getRank();
				handValue = 3;
			}else if(this.cards[0].getRank() == this.cards[3].getRank()) {
				handRank = this.cards[0].getRank();
				handValue = 3;
			}
			return true;
		}else if(this.cards[1].getRank() == this.cards[2].getRank() && this.cards[0].getRank() != this.cards[1].getRank() &&
				this.cards[2].getRank() != this.cards[3].getRank()
				&& this.cards[3].getRank() == this.cards[4].getRank()) {
			if(this.cards[1].getRank() > this.cards[3].getRank()) {
				handRank = this.cards[1].getRank();
				handValue = 3;
			}else if(this.cards[1].getRank() < this.cards[3].getRank()) {
				handRank = this.cards[3].getRank();
				handValue = 3;
			}else if(this.cards[1].getRank() == this.cards[3].getRank()) {
				handRank = this.cards[1].getRank();
				handValue = 3;
			}
			return true;
		}
		return false;
	}	

	public boolean isThreeOfAKind() {
		for(int i = 0; i < 3; i++) {  
			if(this.cards[i].getRank() == this.cards[i + 1].getRank() && this.cards[i].getRank() == this.cards[i + 2].getRank()
					&& this.cards[i + 2].getRank() != this.cards[i + 3].getRank()) {
				if(i == 0) {
					if(this.cards[i].getRank() != this.cards[i + 3].getRank()
							&& this.cards[i + 3].getRank() != this.cards[i + 4].getRank()) {
						handRank = this.cards[i].getRank();
						handValue = 4;
						return true;
					}else if(this.cards[i].getRank() != this.cards[i + 3].getRank()
							&& this.cards[i + 3].getRank() == this.cards[i + 4].getRank()) {
						return false;	
				}else if(i == 1) {
					if(this.cards[i].getRank() != this.cards[i + 3].getRank()) {
						handRank = this.cards[i].getRank();
						handValue = 4;
						return true; 
					}
				}else {
					handRank = this.cards[i].getRank();
					handValue = 4;
					return true;
				}
			}
		}
		}
		return false;
	}

	public boolean isStraight() {
		if(this.cards[0].getRank() == this.cards[1].getRank() - 1 && this.cards[1].getRank() == this.cards[2].getRank() - 1
				&& this.cards[2].getRank() == this.cards[3].getRank() - 1 &&
				this.cards[3].getRank() == this.cards[4].getRank() - 1) {
			handRankStraight = this.cards[4].getRank();
			handValue = 5;
			return true;
		}else if(isWheel() == true) {
			handRank = 5;
			handRankStraight = 5;
			handValue = 5;
			return true;
		}
		return false;
	}
	
	public boolean isWheel() {
		if(this.cards[4].getRank() == 14) {
			if(this.cards[0].getRank() == 2 && this.cards[1].getRank() == 3 && this.cards[2].getRank() == 4 
					&& this.cards[3].getRank() == 5) {
				return true;
			}
		}
		return false;
	}

	public boolean isFlush() {
		if(this.cards[0].getSuit() == this.cards[1].getSuit() && this.cards[1].getSuit() == this.cards[2].getSuit() && 
				this.cards[2].getSuit() == this.cards[3].getSuit() && this.cards[3].getSuit() == this.cards[4].getSuit()){
				if(isWheel() == true) {
					handRankFlush = 5;
					return true; 
				}else {
				handRankFlush = this.cards[4].getRank();
				handValue = 6;
				return true;
				}
			}
		return false;
	}

	public boolean isFullHouse() {
		if(this.cards[0].getRank() == this.cards[1].getRank() && this.cards[1].getRank() == this.cards[2].getRank()) {
			if(this.cards[2].getRank() != this.cards[3].getRank() && this.cards[3].getRank() == this.cards[4].getRank()) {
				handRank = this.cards[2].getRank();
				handValue = 7;
				return true;
			}
		}else if(this.cards[0].getRank() == this.cards[1].getRank()) {
			if(this.cards[1].getRank() != this.cards[2].getRank() && 
					this.cards[2].getRank() == this.cards[3].getRank() && this.cards[3].getRank() == this.cards[4].getRank()) {
				handRank = this.cards[4].getRank();
				handValue = 7;
				return true;
			}
		}
		return false;
	}

	public boolean isFourOfAKind() {
		for(int i = 0; i < 2; i++) {
			if(this.cards[i].getRank() == this.cards[i + 1].getRank() &&
					this.cards[i + 1].getRank() == this.cards[i + 2].getRank() && 
					this.cards[i + 2].getRank() == this.cards[i + 3].getRank()) {
				handRank = this.cards[i].getRank();
				handValue = 8;
				return true;
			}
		}
		return false; 
	}

	public boolean isStraightFlush() {
		if(isStraight() == true && isFlush() == true) {
			handValue = 9;
			if(handRankStraight < handRankFlush) {
				handRank = handRankFlush;
				return true;
			}else if(handRankStraight > handRankFlush) {
				handRank = handRankStraight;
				return true;
			}else {
				handRank = handRankStraight;
				return true;
			}
	}
		return false;
	}

	public int getHandTypeValue() {
		isOnePair();
		isTwoPair();
		isThreeOfAKind();
		isStraight();
		isFlush();
		isFullHouse();
		isFourOfAKind();
		isStraightFlush();
		return handValue;
	}


	public int getHandRank() {
		isOnePair();
		isTwoPair();
		isThreeOfAKind();
		isStraight();
		isFlush();
		isFullHouse();
		isFourOfAKind();
		isStraightFlush();
		return handRank;
	}

	public int compareTo(PokerHand other) {
		if(getHandTypeValue() < other.getHandTypeValue()) {
			return -1;
		}else if(getHandTypeValue() > other.getHandTypeValue()) {
			return 1;
		}else if(getHandTypeValue() == other.getHandTypeValue()) {
			if(handRank < other.getHandRank()) {
				return -1;
			}else if(handRank > other.getHandRank()) {
				return 1;
			}
		}
		return 0;
	}

}
