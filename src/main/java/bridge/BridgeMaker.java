package bridge;

import static bridge.controller.Constant.*;

import java.util.ArrayList;
import java.util.List;

public class BridgeMaker {

	private final BridgeNumberGenerator bridgeNumberGenerator;

	public BridgeMaker(BridgeNumberGenerator bridgeNumberGenerator) {
		this.bridgeNumberGenerator = bridgeNumberGenerator;
	}

	public List<String> makeBridge(int size) {
		List<String> bridge = new ArrayList<>();
		for (int i = 0; i < size; i++) {
			int randomNumber = bridgeNumberGenerator.generate();
			fillBridge(bridge, randomNumber);
		}
		return bridge;
	}

	private void fillBridge(List<String> bridge, int randomNumber) {
		if (randomNumber == 1) {
			bridge.add(UPSIDE);
		}
		if (randomNumber == 0) {
			bridge.add(DOWNSIDE);
		}
	}
}
