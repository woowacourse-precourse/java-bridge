package bridge.domain.bridgeMaker;

import bridge.domain.bridge.BridgeChannel;

import java.util.ArrayList;
import java.util.List;

public class BridgeMaker {

	private final BridgeNumberGenerator bridgeNumberGenerator;

	public BridgeMaker(BridgeNumberGenerator bridgeNumberGenerator) {
		this.bridgeNumberGenerator = bridgeNumberGenerator;
	}

	public List<String> makeBridge(int size) {
		List<String> bridge = new ArrayList<>();

		for (int bridgeSpace = 0; bridgeSpace < size; bridgeSpace++) {
			BridgeChannel bridgeChannel = BridgeChannel.of(channelShape());
			bridge.add(bridgeChannel.Shape());
		}

		return bridge;
	}

	private int channelShape() {
		return bridgeNumberGenerator.generate();
	}
}



