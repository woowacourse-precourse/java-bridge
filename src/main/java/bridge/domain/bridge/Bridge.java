package bridge.domain.bridge;

import bridge.domain.bridgeMaker.BridgeMaker;
import bridge.domain.player.BridgeSizeCommand;

import java.util.List;

import static java.util.stream.Collectors.*;

public class Bridge {
	private final List<String> bridge;

	public Bridge(BridgeSizeCommand bridgeSizeCommand, BridgeMaker bridgeMaker) {
		this.bridge = bridgeMaker.makeBridge(bridgeSizeCommand.bridgeSize());
	}

	public List<String> getBridge() {
		return bridge;
	}

	public List<String> getBridgeToCross() {
		return bridge.stream().map(String::new).collect(toList());
	}
}
