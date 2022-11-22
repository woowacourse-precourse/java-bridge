package bridge;

import java.util.ArrayList;
import java.util.List;

import bridge.util.GameConst;

public class BridgeMaker {

	private final BridgeNumberGenerator bridgeNumberGenerator;

	public BridgeMaker(BridgeNumberGenerator bridgeNumberGenerator) {
		this.bridgeNumberGenerator = bridgeNumberGenerator;
	}

	public List<String> makeBridge(int size) {
		List<String> bridge = new ArrayList<>();
		for (int i = 0; i < size; i++) {
			addBridgeAnswer(bridge);
		}
		return bridge;
	}

	private void addBridgeAnswer(List<String> bridge) {
		if (bridgeNumberGenerator.generate() == 1) {
			bridge.add(GameConst.MOVING_UP);
			return;
		}
		bridge.add(GameConst.MOVING_DOWN);
	}
}
