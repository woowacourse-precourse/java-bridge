package bridge;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import bridge.validator.BridgeSize;

class BridgeSizeTest {
	@DisplayName("3 에서 20 사이 자연수를 입력하면 해당 숫자를 반환한다")
	@Test
	void case1() {
		for (int i = 3; i <= 20; i++) {
			String value = Integer.toString(i);
			assertEquals(new BridgeSize(value).getSize(), i);
		}
	}

	@DisplayName("정수 외의 것을 입력하면 에러 메시지를 출력한다")
	@Nested
	class FormatTest {
		@Test
		void case1() {
			Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
				BridgeSize bridgeSize = new BridgeSize("a");
			});
			assertEquals(Error.FORMAT.getMessage(), exception.getMessage());
		}

		@Test
		void case2() {
			Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
				BridgeSize bridgeSize = new BridgeSize("Z");
			});
			assertEquals(Error.FORMAT.getMessage(), exception.getMessage());
		}

		@Test
		void case3() {
			Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
				BridgeSize bridgeSize = new BridgeSize("");
			});
			assertEquals(Error.FORMAT.getMessage(), exception.getMessage());
		}

		@Test
		void case4() {
			Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
				BridgeSize bridgeSize = new BridgeSize(" ");
			});
			assertEquals(Error.FORMAT.getMessage(), exception.getMessage());
		}

		@Test
		void case5() {
			Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
				BridgeSize bridgeSize = new BridgeSize("1.1");
			});
			assertEquals(Error.FORMAT.getMessage(), exception.getMessage());
		}
	}

	@DisplayName("3 에서 20 사이의 자연수 외에 정수를 입력하면 에러 메시지를 출력한다")
	@Nested
	class RangeTest {
		@Test
		void case1() {
			Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
				BridgeSize bridgeSize = new BridgeSize("1");
			});
			assertEquals(Error.RANGE.getMessage(), exception.getMessage());
		}

		@Test
		void case2() {
			Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
				BridgeSize bridgeSize = new BridgeSize("2");
			});
			assertEquals(Error.RANGE.getMessage(), exception.getMessage());
		}

		@Test
		void case3() {
			Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
				BridgeSize bridgeSize = new BridgeSize("21");
			});
			assertEquals(Error.RANGE.getMessage(), exception.getMessage());
		}

		@Test
		void case4() {
			Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
				BridgeSize bridgeSize = new BridgeSize("10000");
			});
			assertEquals(Error.RANGE.getMessage(), exception.getMessage());
		}
		@Test
		void case5() {
			Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
				BridgeSize bridgeSize = new BridgeSize("0");
			});
			assertEquals(Error.RANGE.getMessage(), exception.getMessage());
		}

		@Test
		void case6() {
			Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
				BridgeSize bridgeSize = new BridgeSize("-1");
			});
			assertEquals(Error.RANGE.getMessage(), exception.getMessage());
		}
	}

}
