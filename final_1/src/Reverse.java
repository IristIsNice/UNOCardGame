public class Reverse extends Card {
	public Reverse(int col) {
		super(col, 11);
	}
	
	public void play(int color, int chal, CardFactory factory){
		factory.change_seq();
		factory.next_player();
	}
}

