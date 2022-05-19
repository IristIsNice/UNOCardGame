public class Wild extends Card{
	public Wild() {
		super(4, 13);
	}
	
	public void power_back(){
		super.change_color(4, this);
	}
	
	public void play(int color, int chal, CardFactory factory){
		super.change_color(color, this);
		factory.next_player();
	}
	
	public void change(int number){
		super.change_color(4, this);
	}
	
}
