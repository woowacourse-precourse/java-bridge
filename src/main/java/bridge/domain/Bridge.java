package bridge.domain;

import java.util.List;

public class Bridge {
	List<String> bridge;

	public Bridge(List<String> bridge) {
		this.bridge = bridge;
	}

	public BridgeStatus isBridge(String input, int bridgeNumber) {
		return BridgeStatus.findByBridgeStatus(checkBridge(bridge.get(bridgeNumber), input));
	}

	public long checkBridge(String currentBridge, String input) {
		return currentBridge.chars().filter(bridge -> bridge == input.charAt(0)).count();
	}

	public boolean isEnd(int bridgeNumber) {
		return bridge.size() == bridgeNumber;
	}
}
