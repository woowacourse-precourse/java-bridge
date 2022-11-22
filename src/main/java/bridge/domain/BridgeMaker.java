package bridge.domain;

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
			int number = bridgeNumberGenerator.generate();

			bridge.add(BridgeStatus.findMate(number));
		}
		return bridge;
	}
}
