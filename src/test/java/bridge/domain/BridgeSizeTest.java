package bridge.domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

class BridgeSizeTest {

	@ValueSource(strings = {"3", "10", "20"})
	@ParameterizedTest
	void 정상_작동(String values) {
		assertThat(new BridgeSize(values));
	}

	@ValueSource(strings = {" ", "a", " b", "-30", "1", "2", "21", "100"})
	@ParameterizedTest
	void 예외처리(String values) {
		assertThatThrownBy(() -> new BridgeSize(values))
				.isInstanceOf(IllegalArgumentException.class);
	}
}