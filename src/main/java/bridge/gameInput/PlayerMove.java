package bridge.gameInput;

public enum PlayerMove {
	UP("U"), DOWN("D");

	private String direction;

	PlayerMove(String direction) {
		this.direction = direction;
	}

	public String getDirection() {
		return direction;
	}
}
