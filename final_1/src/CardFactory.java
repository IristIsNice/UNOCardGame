import java.util.ArrayList;
import java.util.Collections;

public class CardFactory {
	private ArrayList<Card> pile = new ArrayList<Card>();
	private ArrayList<Card> deck = new ArrayList<Card>();
	private Player[] gamer;
	private int seq;
	private int cur;
	private int player_num;
	
	CardFactory(int num){
		for(int i=0;i<=3;i++)
		{
			for(int j=0; j<=9; j++)
				deck.add(new NumCard(i,j));
			deck.add(new Skip(i));
			deck.add(new Reverse(i));
			deck.add(new DrawTwo(i));
		}
		deck.add(new Wild());
		deck.add(new Wild());
		deck.add(new WildDrawFour());
		deck.add(new WildDrawFour());
		//pile.add(deck.get(55));//yongwei
		Collections.shuffle(deck);	//shuffle deck
		pile.add(drawCard());
		seq=1;
		cur =0;
		player_num = num;
		gamer = new Player[player_num];
		for(int i=0;i<=(player_num-1);i++)
			gamer[i] = new Player(this);
	}
	public CardFactory getfac() {
		return this;
	}
	
	public int getcur() {
		return cur;
	}
	
	
	public ArrayList<Card> playerCard(){
		return gamer[cur].retAllCard();
	}
	
	public Card pile_top(){
		Card hold =null;
		hold = pile.get(pile.size()-1);
		return hold;
	}

	public boolean renew_deck(){
		if (pile.size()!=0 || deck.size()!=0)
			return false;
		Card temp;
		temp = pile.get(pile.size()-1);	//remain the top card
		pile.remove(pile.size()-1);
		deck.addAll(pile);
		pile.clear();
		Collections.shuffle(deck);
		pile.add(temp);
		return true;
	}
	
	public boolean in_pile(Card hold){

		if(pile_top() instanceof Wild || pile_top()  instanceof WildDrawFour)
			pile_top().power_back();
		if (pile.add(hold))
			return true;
		return false;
	}
	
	public boolean move_validity(Card compare){
		Card hold;
		hold = pile_top();
		if (hold.ref_col() == compare.ref_col() || hold.ref_sym() == compare.ref_sym())
			return true;
		if (compare.ref_col() == 4)
			return true;
		return false;
	}
	
	public Card drawCard(){//deck action
		Card hold = null;
		if (deck.size()==0)
			return hold;
		hold = deck.get(deck.size()-1);
		deck.remove(deck.size()-1);
		return hold;
	}
	
	public void draw_card(){//player action
		if (deck.size()<=0)
			renew_deck();
		gamer[cur].card_in(drawCard());
	}
	
	public void next_player(){
		cur+=seq;
		if (cur<0)		//loop
			cur = player_num-1;
		else if (cur >=player_num)
			cur =0;
	}
	
	public void change_seq(){
		if (seq == 1)
			seq = (-1);
		else if (seq == (-1))
			seq=1;
	}
	
	public ArrayList<Card> ret_playable_card(Card compare)
	{
		return gamer[cur].ret_playable_card(compare);
	}

	public void card_eff(int color, int chal) {//Scanner input){
		if(!(pile_top() instanceof NumCard))
			pile_top().play(color, chal, this);//,input);
	}
	
	public ArrayList<Card> allHand(){
		return gamer[cur].retAllCard();
	}
	
	public Card pre_card(){
		return pile.get(pile.size()-2);
	}
	
	public ArrayList<Boolean> return_available(){
		return gamer[cur].ret_bool(pile_top());
	}
	
	public int cur_player(){
		return cur;
	}
	
	public void player_deal_card(int number)
	{
		in_pile(gamer[cur].card_out(number+1));
	}
	
	public boolean cur_playable(){
		return gamer[cur].available_move(pile_top());
	}
	
	public boolean player_win(){
		return gamer[cur].player_win();
	}
}


