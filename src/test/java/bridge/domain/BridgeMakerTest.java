package bridge.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;

public class BridgeMakerTest {
	@DisplayName("Enum을 활용한 다리 생성 테스트")
	@Test
	void makeBridge() {
		//given
		BridgeRandomNumberGenerator bridgeRandomNumberGenerator = new BridgeRandomNumberGenerator();
		BridgeMaker bridgeMaker = new BridgeMaker(bridgeRandomNumberGenerator);
		int bridgeSize = 5;

		//when
		List<String> bridge = bridgeMaker.makeBridge(bridgeSize);

		// then
		assertThat(bridge).containsOnly("D", "U");
	}
}
