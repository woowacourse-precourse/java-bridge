package bridge.domain;

import java.util.List;

public class Bridge {

	private final static String ERROR_MESSAGE_RANGE = "다리 길이는 3부터 20 사이의 숫자여야 합니다.";
	private final static int MIN_BRIDGE_SIZE = 3;
	private final static int MAX_BRIDGE_SIZE = 3;

	List<String> bridge;

	public Bridge(List<String> bridge) {
		this.bridge = bridge;
		validateRange(bridge.size());
	}

	public BridgeStatus isBridgeStatus(String input, int bridgeNumber) {
		return BridgeStatus.findByBridgeStatus(checkBridge(bridge.get(bridgeNumber), input));
	}

	private long checkBridge(String currentBridge, String input) {
		return currentBridge.chars().filter(bridge -> bridge == input.charAt(0)).count();
	}

	public boolean isEnd(int bridgeNumber) {
		return bridge.size() == bridgeNumber;
	}

	public int getSize() {
		return bridge.size();
	}

	private void validateRange(int size) {
		if (size < MIN_BRIDGE_SIZE || MAX_BRIDGE_SIZE < size) {
			throw new IllegalArgumentException(ERROR_MESSAGE_RANGE);
		}
	}
}
