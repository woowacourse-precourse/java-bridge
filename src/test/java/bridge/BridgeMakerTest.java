package bridge;

import static org.assertj.core.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BridgeMakerTest {
	@DisplayName("입력받은 숫자만큼 다리의 길이 생성")
	@Test
	void makeBridge() {
		// given
		int inputBridgeCount = 5;
		BridgeRandomNumberGenerator randomNumberGenerator = new BridgeRandomNumberGenerator();

		// when
		BridgeMaker bridgeMaker = new BridgeMaker(randomNumberGenerator);
		List<String> bridge = bridgeMaker.makeBridge(inputBridgeCount);

		// then
		assertThat(bridge.size()).isEqualTo(inputBridgeCount);
	}
}
