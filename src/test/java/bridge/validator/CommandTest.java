package bridge.validator;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import bridge.Error;

class CommandTest {
	@DisplayName("R 혹은 Q를 입력하면 Boolean을 리턴한다.")
	@Test
	void case1() {
		assertTrue(Command.isReplay("R"));
		assertTrue(Command.isReplay("r"));
		assertFalse(Command.isReplay("Q"));
		assertFalse(Command.isReplay("q"));
	}

	@DisplayName("R 혹은 Q 외의 것을 입력하면 에러 메시지를 출력한다")
	@Nested
	class IsReplayTest {
		@Test
		void case1() {
			Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
				Command.isReplay("a");
			});
			Assertions.assertEquals(Error.COMMAND.getMessage(), exception.getMessage());
		}

		@Test
		void case2() {
			Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
				Command.isReplay("Z");
			});
			assertEquals(Error.COMMAND.getMessage(), exception.getMessage());
		}

		@Test
		void case3() {
			Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
				Command.isReplay("0");
			});
			assertEquals(Error.COMMAND.getMessage(), exception.getMessage());
		}

		@Test
		void case4() {
			Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
				Command.isReplay("-1");
			});
			assertEquals(Error.COMMAND.getMessage(), exception.getMessage());
		}

		@Test
		void case5() {
			Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
				Command.isReplay("100000");
			});
			assertEquals(Error.COMMAND.getMessage(), exception.getMessage());
		}

		@Test
		void case6() {
			Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
				Command.isReplay("");
			});
			assertEquals(Error.COMMAND.getMessage(), exception.getMessage());
		}

		@Test
		void case7() {
			Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
				Command.isReplay(" ");
			});
			assertEquals(Error.COMMAND.getMessage(), exception.getMessage());
		}

		@Test
		void case8() {
			Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
				Command.isReplay("U");
			});
			assertEquals(Error.COMMAND.getMessage(), exception.getMessage());
		}

		@Test
		void case9() {
			Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
				Command.isReplay("u");
			});
			assertEquals(Error.COMMAND.getMessage(), exception.getMessage());
		}

		@Test
		void case10() {
			Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
				Command.isReplay("D");
			});
			assertEquals(Error.COMMAND.getMessage(), exception.getMessage());
		}

		@Test
		void case11() {
			Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
				Command.isReplay("d");
			});
			assertEquals(Error.COMMAND.getMessage(), exception.getMessage());
		}
	}
}
