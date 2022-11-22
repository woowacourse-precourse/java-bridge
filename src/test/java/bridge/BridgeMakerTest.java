package bridge;

import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;

class BridgeMakerTest {

	private final BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());

	@Test
	@DisplayName("생성된 다리는 U 또는 D")
	void makeBridgeTest() {
		List<String> bridge = bridgeMaker.makeBridge(10);
		for (int stage = 0; stage < 10; stage++) {
			String bridgeStatus = bridge.get(stage);
			Assertions.assertThat(bridgeStatus).isIn("U", "D");
		}
	}

}
