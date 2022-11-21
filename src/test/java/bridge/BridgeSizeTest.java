package bridge;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class BridgeSizeTest {
	@DisplayName("유효하지 않은 다리 길이일 때 예외를 발생한다.")
	//given
	@ValueSource(ints = {2, 21, 0, -3, 124})
	@ParameterizedTest
	void bridgeSizeTestAbnormal(int number) {
		//when, then
		assertThatThrownBy(() -> {
			BridgeSize bridgeSize = new BridgeSize(number);
		}).isInstanceOf(IllegalArgumentException.class);
	}

	@DisplayName("다리 길이를 검증한다.")
	//given
	@ValueSource(ints = {3, 5, 20})
	@ParameterizedTest
	void bridgeSizeTestNormal(int number) {
		//when, then
		assertDoesNotThrow(() -> {
			BridgeSize bridgeSize = new BridgeSize(number);
		});
	}
}