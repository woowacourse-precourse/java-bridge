package bridge.model;

import org.junit.jupiter.api.Test;

import bridge.BridgeMaker;
import bridge.BridgeNumberGenerator;
import bridge.BridgeRandomNumberGenerator;

public class BridgeMakerTest {
	@Test
	void 다리_만들기_테스트() {
		BridgeNumberGenerator bg = new BridgeRandomNumberGenerator();
		BridgeMaker bridgeMaker = new BridgeMaker(bg);
		System.out.println(bridgeMaker.makeBridge(5));
	}
}
