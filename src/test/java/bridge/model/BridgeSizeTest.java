package bridge.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import bridge.Error;

class BridgeSizeTest {
	@DisplayName("3 에서 20 사이 자연수를 입력하면 해당 숫자를 반환한다")
	@Test
	void inRangeTest() {
		for (int i = 3; i <= 20; i++) {
			assertEquals(new BridgeSize(i).getSize(), i);
		}
	}

	@DisplayName("3 에서 20 사이의 자연수 외에 정수를 입력하면 에러 메시지를 출력한다")
	@ValueSource(ints = {-1, 0, 1, 2, 21, 10000})
	@ParameterizedTest
	void notInRangeTest(int value) {
		Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
			BridgeSize bridgeSize = new BridgeSize(value);
		});
		assertEquals(Error.RANGE.getMessage(), exception.getMessage());
	}
}
