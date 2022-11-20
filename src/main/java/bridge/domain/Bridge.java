package bridge.domain;

import java.util.List;

public class Bridge {
	private final static String ERROR_MESSAGE_RANGE ="다리 길이는 3부터 20 사이의 숫자여야 합니다.";
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

	private void validateRange(int size) {
		if (size < 3 || 20 < size) {
			throw new IllegalArgumentException(ERROR_MESSAGE_RANGE);
		}
	}
}
