package bridge;

enum BridgeState {
	DOWN(0, "D", "[ERROR] 다리 각 칸의 랜덤 값은 0 또는 1만 가능합니다."), UP(1, "U", "[ERROR] 다리 각 칸의 랜덤 값은 0 또는 1만 가능합니다.");

	private final int randomNumber;
	private final String bridgeState;
	private final String bridgeStateErrorMessage;

	BridgeState(int randomNumber, String bridgeState, String bridgeStateErrorMessage) {
		this.randomNumber = randomNumber;
		this.bridgeState = bridgeState;
		this.bridgeStateErrorMessage = bridgeStateErrorMessage;
	}

	public int getRandomNumber() {
		return randomNumber;
	}

	public String getBridgeState() {
		return bridgeState;
	}

	public String getBridgeStateErrorMessage() {
		return bridgeStateErrorMessage;
	}
}