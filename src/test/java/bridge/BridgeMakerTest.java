package bridge;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BridgeMakerTest {

	@Test
	@DisplayName("길이 3의 다리 만들기")
	void makeBridgeTest() {
		BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
		List<String> bridge = bridgeMaker.makeBridge(3);

		Assertions.assertThat(bridge.size()).isEqualTo(3);
	}

	@Test
	@DisplayName("다리의 요소에 U, D 이외의 것이 있는지 확인")
	void getBridgeBlockTest() {
		BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
		List<String> bridge = bridgeMaker.makeBridge(20);

		Assertions.assertThat(bridge).containsOnly("U", "D");
	}

}
