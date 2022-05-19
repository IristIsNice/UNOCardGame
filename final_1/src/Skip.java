public class Skip extends Card{
	public Skip(int col) {
		super(col, 10);
	}
	
	public void play(int color, int chal, CardFactory factory){
		factory.next_player();
		factory.next_player();
	}
}
