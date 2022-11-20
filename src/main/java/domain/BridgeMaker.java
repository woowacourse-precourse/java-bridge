package domain;

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
			int bridgeNumber = bridgeNumberGenerator.generate();
			bridge.add(upOrDownCheck(bridgeNumber));
		}
		return bridge;
	}

	private String upOrDownCheck(int number) {
		String upOrDown = "U";

		if (number == 0) {
			upOrDown = "D";
		}

		return upOrDown;
	}
}
