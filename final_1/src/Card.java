public abstract class Card implements Comparable<Card> {
	private int color;	//color
	private int symbol;	//symbol
	
	public Card(int col, int sym){
		color = col;
		symbol = sym;
	}
	
	public Card(){
		color = 999;
		symbol =999;
	}
	
	public int compare(){	//compare
		return color*100+symbol;
	}
	
	public String string_card(){
		String[] dis_col = {"red","yellow","green","blue","any"};
		String[] dis_sym = {"0","1","2","3","4","5","6","7","8","9"
				     		,"Skip","Reverse","DrawTwo","Wild","WildDrawFour"};
		return (dis_col[color] + " " +dis_sym[symbol]);
	}

	public int compareTo(Card card) {	// implements Comparable
		if (this.compare() == card.compare())
			return 0;
		else if (this.compare() > card.compare())
			return 1;
		else if (this.compare() < card.compare())
			return -1;
		return -1;
	}
	
	public int ref_sym(){	//accessor
		return symbol;
	}
	
	public int ref_col(){	//accessor
		return color;
	}

	public void power_back() {	//for wild and draw four cards only
	}
	
	public void play(int color, int chal, CardFactory factory){//for wild and draw four cards only
	}
	
	public void change_color(int change,Card hold){//for wild and draw four cards only
		if(hold instanceof Wild || hold instanceof WildDrawFour)
			color = change;
	}
}
