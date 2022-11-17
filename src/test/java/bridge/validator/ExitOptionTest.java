package bridge.validator;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import bridge.Error;

class OptionTest {
	@DisplayName("R 혹은 Q를 입력하면 Boolean을 리턴한다.")
	@Test
	void case1() {
		assertTrue(Option.isReplay("R"));
		assertTrue(Option.isReplay("r"));
		assertFalse(Option.isReplay("Q"));
		assertFalse(Option.isReplay("q"));
	}

	@DisplayName("R 혹은 Q 외의 것을 입력하면 에러 메시지를 출력한다")
	@Nested
	class IsReplayTest {
		@Test
		void case1() {
			Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
				Option.isReplay("a");
			});
			Assertions.assertEquals(Error.COMMAND.getMessage(), exception.getMessage());
		}

		@Test
		void case2() {
			Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
				Option.isReplay("Z");
			});
			assertEquals(Error.COMMAND.getMessage(), exception.getMessage());
		}

		@Test
		void case3() {
			Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
				Option.isReplay("0");
			});
			assertEquals(Error.COMMAND.getMessage(), exception.getMessage());
		}

		@Test
		void case4() {
			Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
				Option.isReplay("-1");
			});
			assertEquals(Error.COMMAND.getMessage(), exception.getMessage());
		}

		@Test
		void case5() {
			Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
				Option.isReplay("100000");
			});
			assertEquals(Error.COMMAND.getMessage(), exception.getMessage());
		}

		@Test
		void case6() {
			Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
				Option.isReplay("");
			});
			assertEquals(Error.COMMAND.getMessage(), exception.getMessage());
		}

		@Test
		void case7() {
			Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
				Option.isReplay(" ");
			});
			assertEquals(Error.COMMAND.getMessage(), exception.getMessage());
		}

		@Test
		void case8() {
			Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
				Option.isReplay("U");
			});
			assertEquals(Error.COMMAND.getMessage(), exception.getMessage());
		}

		@Test
		void case9() {
			Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
				Option.isReplay("u");
			});
			assertEquals(Error.COMMAND.getMessage(), exception.getMessage());
		}

		@Test
		void case10() {
			Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
				Option.isReplay("D");
			});
			assertEquals(Error.COMMAND.getMessage(), exception.getMessage());
		}

		@Test
		void case11() {
			Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
				Option.isReplay("d");
			});
			assertEquals(Error.COMMAND.getMessage(), exception.getMessage());
		}
	}
}
