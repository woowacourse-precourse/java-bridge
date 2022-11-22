package bridge;

import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BridgeMakerTest {

	@Test
	void BridgeMaker_정상작동() {
		BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
		int size = 3;
		List<String> bridge = bridgeMaker.makeBridge(size);
		int count = 0;
		for (String status : bridge) {
			if (status.equals("U") || status.equals("D")) {
				count++;
			}
		}
		assertEquals(count, size);
	}
}