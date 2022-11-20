package bridge;

import java.util.ArrayList;
import java.util.List;

public class BridgeMaker {

	private final BridgeNumberGenerator bridgeNumberGenerator;

	public BridgeMaker(BridgeNumberGenerator bridgeNumberGenerator) {
		this.bridgeNumberGenerator = bridgeNumberGenerator;
	}

	public List<String> makeBridge(int size) {
		List<String> bridge = new ArrayList<>();
		while (bridge.size() < size) {
			bridge.add(selectUpDown());
		}
		return bridge;
	}

	public String selectUpDown() {
		if (bridgeNumberGenerator.generate() == 1) {
			return "U";
		}
		return "D";
	}
}
