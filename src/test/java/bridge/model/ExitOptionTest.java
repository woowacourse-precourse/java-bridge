package bridge.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import bridge.Error;

class ExitOptionTest {
	@DisplayName("R 혹은 Q를 입력하면 Boolean을 리턴한다.")
	@Test
	void case1() {
		assertTrue(ExitOption.of("R").isReplay());
		assertTrue(ExitOption.of("r").isReplay());
		assertFalse(ExitOption.of("Q").isReplay());
		assertFalse(ExitOption.of("q").isReplay());
	}

	@DisplayName("R 혹은 Q 외의 것을 입력하면 에러 메시지를 출력한다")
	@Nested
	class IsReplayTest {
		@Test
		void case1() {
			Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
				ExitOption.of("a");
			});
			Assertions.assertEquals(Error.EXIT_OPTION.getMessage(), exception.getMessage());
		}

		@Test
		void case2() {
			Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
				ExitOption.of("Z");
			});
			assertEquals(Error.EXIT_OPTION.getMessage(), exception.getMessage());
		}

		@Test
		void case3() {
			Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
				ExitOption.of("0");
			});
			assertEquals(Error.EXIT_OPTION.getMessage(), exception.getMessage());
		}

		@Test
		void case4() {
			Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
				ExitOption.of("-1");
			});
			assertEquals(Error.EXIT_OPTION.getMessage(), exception.getMessage());
		}

		@Test
		void case5() {
			Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
				ExitOption.of("100000");
			});
			assertEquals(Error.EXIT_OPTION.getMessage(), exception.getMessage());
		}

		@Test
		void case6() {
			Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
				ExitOption.of("");
			});
			assertEquals(Error.EXIT_OPTION.getMessage(), exception.getMessage());
		}

		@Test
		void case7() {
			Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
				ExitOption.of(" ");
			});
			assertEquals(Error.EXIT_OPTION.getMessage(), exception.getMessage());
		}

		@Test
		void case8() {
			Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
				ExitOption.of("U");
			});
			assertEquals(Error.EXIT_OPTION.getMessage(), exception.getMessage());
		}

		@Test
		void case9() {
			Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
				ExitOption.of("u");
			});
			assertEquals(Error.EXIT_OPTION.getMessage(), exception.getMessage());
		}

		@Test
		void case10() {
			Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
				ExitOption.of("D");
			});
			assertEquals(Error.EXIT_OPTION.getMessage(), exception.getMessage());
		}

		@Test
		void case11() {
			Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
				ExitOption.of("d");
			});
			assertEquals(Error.EXIT_OPTION.getMessage(), exception.getMessage());
		}
	}
}
