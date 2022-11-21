package bridge;

import java.util.List;

import bridgeConstant.Constant;
import dto.BridgeDto;
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

	public BridgeDto toBridgeDto() {
		return new BridgeDto(bridge);
	}

	public boolean isUpPositionAt(int index) {
		return bridge.get(index).equals(Constant.UPPER_POSITION);
	}


}
