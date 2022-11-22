package bridge.enums;

public enum Inputs {
	MOVE_UP("U"),
	MOVE_DOWN("D"),
	RETRY("R"),
	QUIT("Q");

	private String message;

	Inputs(String message) {
		this.message = message;
	}

	public String getMessage() {
		return this.message;
	}
}
