package bridge.model;

public class Player {
	private int position;

	public Player() {
		this.position = 0;
	}

	public boolean checkEnd(int endPosition) {
		return position == endPosition;
	}
}
