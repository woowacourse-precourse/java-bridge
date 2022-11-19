package bridge.repository;

import java.util.ArrayList;
import java.util.List;

import bridge.BridgeNumberGenerator;

public class BridgeMaker {

	private final BridgeNumberGenerator bridgeNumberGenerator;

	public BridgeMaker(BridgeNumberGenerator bridgeNumberGenerator) {
		this.bridgeNumberGenerator = bridgeNumberGenerator;
	}

	public List<String> makeBridge(int size) {
		List<String> bridge = new ArrayList<>();
		for (int i = 0; i < size; i++) {
			bridge.add(putBridgeNumberToString(bridgeNumberGenerator.generate()));
		}
		return bridge;
	}

	private String putBridgeNumberToString(int generate) {
		if (generate == 1) {
			return "U";
		}
		return "D";
	}

}
