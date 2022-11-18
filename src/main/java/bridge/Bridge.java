package bridge;

import java.util.List;

import static java.util.stream.Collectors.*;

public class Bridge  {
	private final List<String> bridge;

	public Bridge(BridgeSize bridgeSize, BridgeMaker bridgeMaker) {
		this.bridge = bridgeMaker.makeBridge(bridgeSize.toNumber());
	}

	public List<String> getBridge() {
		return bridge;
	}

	public List<String> getBridgeToCross() {
		return bridge.stream().map(String::new).collect(toList());
	}
}
