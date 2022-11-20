package bridge.domain;

import java.util.List;

public class Bridge {
	List<String> bridge;

	public Bridge(List<String> bridge) {
		this.bridge = bridge;
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
}
