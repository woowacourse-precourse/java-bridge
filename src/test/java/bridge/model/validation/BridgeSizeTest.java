package bridge.model.validation;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import bridge.model.constant.Error;
import bridge.model.constant.Size;

class BridgeSizeTest {
	@DisplayName("3 에서 20 사이 자연수를 입력하면 해당 숫자를 반환한다")
	@Test
	void inRangeTest() {
		for (int size = Size.MIN.getNumber(); size <= Size.MAX.getNumber(); size++) {
			assertEquals(new BridgeSize(size).getSize(), size);
		}
	}

	@DisplayName("3 에서 20 사이의 자연수 외에 정수를 입력하면 에러 메시지를 출력한다")
	@ParameterizedTest
	@ValueSource(ints = {-1, 0, 1, 2, 21, 10000})
	void notInRangeTest(int size) {
		Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
			BridgeSize bridgeSize = new BridgeSize(size);
		});
		assertEquals(Error.RANGE.getMessage(), exception.getMessage());
	}
}
