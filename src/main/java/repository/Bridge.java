package repository;

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

	public boolean isCorrectMoving(int index, String moving) {
		return bridge.get(index).equals(moving);
	}

	public int getBridgeSize() {
		return bridge.size();
	}

	public List<String> getBridge() {
		return bridge;
	}
}
