package bridge;

public enum BridgeSymbol {
	UP("U", 1),
	DOWN("D", 0),
	MOVABLE("O", -1),
	UNMOVABLE("X", -1),
	RETRY("R", -1),
	QUIT("Q", -1),
	SUCCESS("성공", -1),
	FAIL("실패", -1);

	private final String symbol;
	private final int value;

	private BridgeSymbol(String symbol, int value) {
		this.symbol = symbol;
		this.value = value;
	}

	public String getSymbol() {
		return this.symbol;
	}

	public int getValue() {
		return this.value;
	}

}
