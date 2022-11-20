package bridge.model.constant;

public enum Size {
	MIN(3),
	MAX(20),
	;

	private final int number;

	Size(int number) {
		this.number = number;
	}

	public int getNumber() {
		return number;
	}
}
