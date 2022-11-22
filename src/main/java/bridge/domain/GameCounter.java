package bridge.domain;

public class GameCounter {
	private int count = 0;

	public void addCount() {
		this.count++;
	}

	public int getCount() {
		return this.count;
	}
}
