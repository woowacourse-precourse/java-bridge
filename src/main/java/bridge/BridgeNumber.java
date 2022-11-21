package bridge;

public enum BridgeNumber {
	UP("U", 1),
	DOWN("D", 0);

	private final String mark;
	private final int number;

	BridgeNumber(String mark, int number) {
		this.mark = mark;
		this.number = number;
	}

	public static String getMark(int number) {
		for (BridgeNumber bridgeNumber : BridgeNumber.values()) {
			if (bridgeNumber.number == number) {
				return bridgeNumber.mark;
			}
		}
		return "";
	}
}
