package bridge;

import bridge.utils.Convertor;
import java.util.ArrayList;
import java.util.List;

public class BridgeMaker {
	private final BridgeNumberGenerator bridgeNumberGenerator;

	public BridgeMaker(BridgeNumberGenerator bridgeNumberGenerator) {
		this.bridgeNumberGenerator = bridgeNumberGenerator;
	}

	public List<String> makeBridge(int size) {
		List<String> bridge = new ArrayList<>(size);
		while (bridge.size() < size) {
			int number = bridgeNumberGenerator.generate();
			String direction = Convertor.convertMovingDirection(number);
			bridge.add(direction);
		}
		return bridge;
	}
}
