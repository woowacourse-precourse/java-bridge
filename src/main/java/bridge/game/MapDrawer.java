package bridge.game;

public enum MapDrawer {
	ABLE_CROSS("O"), UNABLE_CROSS("X"), BLANK(" "), INIT(""), VERTICAL_BAR(" | ");

	private String symbol;

	MapDrawer(String symbol) {
		this.symbol = symbol;
	}

	public String getSymbol() {
		return symbol;
	}
}
