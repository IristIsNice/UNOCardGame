import java.util.ArrayList;
import java.util.Collections;

public class Player {
	public   ArrayList<Card> cards = new ArrayList<Card>();
	
	Player(CardFactory factory)	//draw 5 cards
	{
		for(int int_loop=0;int_loop<=4;int_loop++)
			cards.add(factory.drawCard());
		Collections.sort(cards);
	}
	
	public boolean card_in(Card input){	//receive card
		Card null_card = null;
		if (input ==null_card)
			return false;
		cards.add( input);
		Collections.sort(cards);
		return true;
	}
	
	public Card card_out(int selection){ // deal card
		//selection--;
		if(selection>cards.size()||selection <=0)
			return null;
		Card hold;
		hold = cards.get(selection-1);
		cards.remove(selection-1);
		return hold;
	}
	
	public ArrayList<Card> retAllCard(){
		Collections.sort(cards);
		return this.cards;
	}
	
	public boolean move_validity(int pos,Card compare){
		Card hold;
		if (pos>cards.size()||pos<0)
			return false;
		hold = cards.get(pos);
		if (hold.ref_col() == compare.ref_col() || hold.ref_sym() == compare.ref_sym())
			return true;
		if (hold.ref_col() == 4)
			return true;
		if(compare.ref_col() ==4)
			return true;
		return false;
	}
	
	public ArrayList<Card> ret_playable_card(Card compare)
	{
		ArrayList<Card> card = new ArrayList<Card>();
		Card hold;
		Collections.sort(cards);
		for(int i=0;i<=cards.size()-1;i++){
			hold = cards.get(i);
			if (move_validity(i,compare))
			{
				card.add(hold);
			}
		}
		return card;
	}
	
	public boolean available_move(Card card){
		for(int i=0;i<=cards.size()-1;i++){
			if(move_validity(i,card))
				return true;
		}
		return false;
	}
	
	public boolean player_win(){
		if (cards.size()==0){

			return true;
		}
		return false;
	}
	
	public ArrayList<Boolean> ret_bool(Card compare)
	{
		ArrayList<Boolean> bool = new ArrayList<Boolean>();
		for(int i=0;i<=cards.size()-1;i++){
			if (move_validity(i,compare))
				bool.add(true);
			else
				bool.add(false);
		}
		return bool;
	}
}

