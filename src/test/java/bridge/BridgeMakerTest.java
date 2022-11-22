package bridge;

import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BridgeMakerTest {

	private BridgeMaker bridgeMaker;
	private BridgeNumberGenerator bridgeNumberGenerator;

	@BeforeEach
	void setUp() {
		bridgeNumberGenerator = new BridgeRandomNumberGenerator();
		bridgeMaker = new BridgeMaker(bridgeNumberGenerator);
	}

	@DisplayName("bridgeMaker.makeBridge(size) 로 만들어진 다리에 저장된 값이 U 또는 D 인지 확인하는 테스트")
	@Test
	void makeBridge() {
		//given
		Integer size = 4;

		//when
		List<String> bridge = bridgeMaker.makeBridge(size);

		//then
		bridge.stream().forEach(i -> Assertions.assertThat(i).containsAnyOf("U", "D"));
	}
}
