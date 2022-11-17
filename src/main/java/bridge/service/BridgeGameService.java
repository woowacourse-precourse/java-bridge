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
		validSize(size);
		return bridgeMaker.makeBridge(size);
	}

	private void validSize(int size) {
		if (size < 3 || size > 20) {
			throw new IllegalArgumentException("[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다.");
		}
	}
}
