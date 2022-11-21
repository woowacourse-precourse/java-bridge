package bridge;

import java.util.List;

import util.Validator;

public class Bridge {
	private final List<String> bridge;

	public Bridge(List<String> bridge) {
		validateBridge(bridge);
		this.bridge = bridge;
	}

	private void validateBridge(List<String> bridge) {
		Validator.validateBridgeComponent(bridge);
		Validator.validateBridgeSizeRange(bridge.size());
	}

	public List<String> getBridge() {
		return bridge;
	}

}
