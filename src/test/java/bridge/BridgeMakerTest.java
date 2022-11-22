package bridge;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;

class BridgeMakerTest {
	BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());

	@DisplayName("입력한 숫자만큼 다리길이가 생성된다")
	@ParameterizedTest
	@ValueSource(ints = {3, 4, 5, 6, 7, 8, 9, 10, 11})
	void makeBridge(int input) {
		List<String> bridge = bridgeMaker.makeBridge(input);
		assertThat(bridge.size()).isEqualTo(input);
	}

}