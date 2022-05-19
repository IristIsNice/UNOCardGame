public class DrawTwo extends Card{
	public DrawTwo(int col) {
		super(col, 12);
	}
	
	public void play(int color, int chal, CardFactory factory) {
		factory.next_player();
		factory.draw_card();
		factory.draw_card();
		factory.next_player();
	}
	
}
