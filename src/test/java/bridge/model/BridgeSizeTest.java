package bridge.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import bridge.Error;

class BridgeSizeTest {
	@DisplayName("3 에서 20 사이 자연수를 입력하면 해당 숫자를 반환한다")
	@Test
	void case1() {
		for (int i = 3; i <= 20; i++) {
			assertEquals(new BridgeSize(i).getSize(), i);
		}
	}

	@DisplayName("3 에서 20 사이의 자연수 외에 정수를 입력하면 에러 메시지를 출력한다")
	@Nested
	class RangeTest {
		@Test
		void case1() {
			Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
				BridgeSize bridgeSize = new BridgeSize(1);
			});
			assertEquals(Error.RANGE.getMessage(), exception.getMessage());
		}

		@Test
		void case2() {
			Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
				BridgeSize bridgeSize = new BridgeSize(2);
			});
			assertEquals(Error.RANGE.getMessage(), exception.getMessage());
		}

		@Test
		void case3() {
			Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
				BridgeSize bridgeSize = new BridgeSize(21);
			});
			assertEquals(Error.RANGE.getMessage(), exception.getMessage());
		}

		@Test
		void case4() {
			Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
				BridgeSize bridgeSize = new BridgeSize(10000);
			});
			assertEquals(Error.RANGE.getMessage(), exception.getMessage());
		}

		@Test
		void case5() {
			Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
				BridgeSize bridgeSize = new BridgeSize(0);
			});
			assertEquals(Error.RANGE.getMessage(), exception.getMessage());
		}

		@Test
		void case6() {
			Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
				BridgeSize bridgeSize = new BridgeSize(-1);
			});
			assertEquals(Error.RANGE.getMessage(), exception.getMessage());
		}
	}

}
