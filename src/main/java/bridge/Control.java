package bridge;

public enum Control {
	UP(0, "U"),
	DOWN(1, "D"),
	RESTART(2, "R"),
	QUIT(3, "Q");

	private final int controlId;
	private final String controlOrder;

	Control(int controlId, String controlOrder) {
		this.controlId = controlId;
		this.controlOrder = controlOrder;
	}

	public String getControlOrder() {
		return controlOrder;
	}
}
