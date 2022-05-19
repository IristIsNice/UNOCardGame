public class WildDrawFour extends Card{

	public WildDrawFour() {
		super(4, 14);
	}
	
	public void power_back(){		
		super.change_color(4, this);
	}
	
	public void play(int color, int chal, CardFactory factory){
		super.change_color(color, this);
		challenge(chal,factory);
	}
	
	private boolean challenge(int challenge, CardFactory factory){
		boolean hold = false;
		if(challenge ==1){
			if(factory.cur_playable()){
				hold = true;
			}
			else{
				factory.next_player();
				hold = false;
			}
			for(int i=0;i<=5;i++){
				System.out.println("Test");
				factory.draw_card();
				factory.next_player();
			}
			return hold;
		}
		else if(challenge ==2)
		{
			factory.next_player();
			System.out.println(factory.cur_player()+1);
			for(int i=0;i<=3;i++)
				factory.draw_card();
		}
		return false;
	}
	
	public void change(int number){
		super.change_color(4, this);
	}
}