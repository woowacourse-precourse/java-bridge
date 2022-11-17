package bridge.service;

import java.util.List;

import bridge.domain.BridgeMaker;
import bridge.domain.BridgeRandomNumberGenerator;

public class BridgeGameService {
	private final BridgeMaker bridgeMaker;

	public BridgeGameService() {
		this.bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
	}

	public List<String> initBridge(int size) {
		return bridgeMaker.makeBridge(size);
	}
}
