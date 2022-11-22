package bridge.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class PlayerBridgeTest {


	@ValueSource(strings = {" U", "d", "3", " "})
	@ParameterizedTest
	void 예외처리(String input) {
		PlayerBridge playerBridge = new PlayerBridge();

		assertThatThrownBy(() -> playerBridge.add(input))
				.isInstanceOf(IllegalArgumentException.class);
	}

	@Test
	void getLastValue_테스트() {
		String answer = "U";
		PlayerBridge playerBridge = new PlayerBridge();
		playerBridge.add("D");
		playerBridge.add("D");
		playerBridge.add(answer);

		assertEquals(answer, playerBridge.getLastValue());
	}
}