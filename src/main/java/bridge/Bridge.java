package bridge;

import java.util.List;

import bridgeConstant.Constant;
import dto.BridgeResponseDto;
import util.Validator;

public class Bridge {
	private final List<String> bridge;
	private final int bridgeSize;

	public Bridge(List<String> bridge) {
		validateBridge(bridge);
		this.bridge = bridge;
		this.bridgeSize = bridge.size();
	}

	private void validateBridge(List<String> bridge) {
		Validator.validateBridgeComponent(bridge);
		Validator.validateBridgeSizeRange(bridge.size());
	}

	public List<String> getBridge() {
		return bridge;
	}

	public int getBridgeSize() {
		return bridgeSize;
	}
}
