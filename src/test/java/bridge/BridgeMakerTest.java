package bridge;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BridgeMakerTest {
	BridgeMaker bridgeMaker;

	private static class BridgeOneNumberGenerator implements BridgeNumberGenerator {
		@Override
		public int generate() {
			return 1;
		}
	}

	@DisplayName("U만 포함된 지정된 길이의 다리를 반환해야 한다.")
	@Test
	void makeBridgeTest() {
		bridgeMaker = new BridgeMaker(new BridgeOneNumberGenerator());
		List<String> bridge = bridgeMaker.makeBridge(10);
		assertThat(bridge.size()).isEqualTo(10);
		assertThat(bridge).containsOnly("U");
	}
}
