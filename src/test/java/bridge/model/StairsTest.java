package bridge.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import bridge.Error;

class LocationTest {
	@DisplayName("U 혹은 D를 입력하면 Location Enum을 반환한다")
	@Test
	void case1() {
		assertEquals(Location.of("U"), Location.UP);
		assertEquals(Location.of("u"), Location.UP);
		assertEquals(Location.of("D"), Location.DOWN);
		assertEquals(Location.of("d"), Location.DOWN);
	}

	@DisplayName("1 혹은 0을 입력하면 Location Enum을 반환한다")
	@Test
	void case2() {
		assertEquals(Location.of(1), Location.UP);
		assertEquals(Location.of(0), Location.DOWN);
	}

	@DisplayName("getter 메서드 테스트")
	@Test
	void GetterTest() {
		assertEquals(Location.of(1).getCommand(), "U");
		assertEquals(Location.of(0).getCommand(), "D");
		assertEquals(Location.of("U").getCommand(), "U");
		assertEquals(Location.of("D").getCommand(), "D");
		assertEquals(Location.of("u").getCommand(), "U");
		assertEquals(Location.of("d").getCommand(), "D");
		assertEquals(Location.of(1).getNumber(), 1);
		assertEquals(Location.of(0).getNumber(), 0);
		assertEquals(Location.of("U").getNumber(), 1);
		assertEquals(Location.of("D").getNumber(), 0);
		assertEquals(Location.of("u").getNumber(), 1);
		assertEquals(Location.of("d").getNumber(), 0);
	}

	@DisplayName("getAnotherNumberTest")
	@Test
	void GetAnotherNumberTest() {
		assertEquals(Location.of(1).getAnotherNumber(), 0);
		assertEquals(Location.of(0).getAnotherNumber(), 1);
		assertEquals(Location.of("U").getAnotherNumber(), 0);
		assertEquals(Location.of("D").getAnotherNumber(), 1);
		assertEquals(Location.of("u").getAnotherNumber(), 0);
		assertEquals(Location.of("d").getAnotherNumber(), 1);
	}

	@DisplayName("U 혹은 D 외의 문자를을 입력하면 에러 메시지를 출력한다")
	@Nested
	class CommandTest {
		@Test
		void case1() {
			Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
				Location.of("a");
			});
			Assertions.assertEquals(Error.LOCATION_COMMAND.getMessage(), exception.getMessage());
		}

		@Test
		void case2() {
			Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
				Location.of("Z");
			});
			assertEquals(Error.LOCATION_COMMAND.getMessage(), exception.getMessage());
		}

		@Test
		void case3() {
			Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
				Location.of("R");
			});
			assertEquals(Error.LOCATION_COMMAND.getMessage(), exception.getMessage());
		}

		@Test
		void case4() {
			Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
				Location.of("r");
			});
			assertEquals(Error.LOCATION_COMMAND.getMessage(), exception.getMessage());
		}

		@Test
		void case5() {
			Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
				Location.of("Q");
			});
			assertEquals(Error.LOCATION_COMMAND.getMessage(), exception.getMessage());
		}

		@Test
		void case6() {
			Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
				Location.of("q");
			});
			assertEquals(Error.LOCATION_COMMAND.getMessage(), exception.getMessage());
		}

		@Test
		void case7() {
			Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
				Location.of("");
			});
			assertEquals(Error.LOCATION_COMMAND.getMessage(), exception.getMessage());
		}

		@Test
		void case8() {
			Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
				Location.of(" ");
			});
			assertEquals(Error.LOCATION_COMMAND.getMessage(), exception.getMessage());
		}

		@Test
		void case9() {
			Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
				Location.of("0");
			});
			assertEquals(Error.LOCATION_COMMAND.getMessage(), exception.getMessage());
		}

		@Test
		void case10() {
			Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
				Location.of("1");
			});
			assertEquals(Error.LOCATION_COMMAND.getMessage(), exception.getMessage());
		}
	}

	@DisplayName("0 혹은 1 외의 숫자를을 입력하면 에러 메시지를 출력한다")
	@Nested
	class NumberTest {
		@Test
		void case1() {
			Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
				Location.of(-1);
			});
			Assertions.assertEquals(Error.LOCATION_NUMBER.getMessage(), exception.getMessage());
		}

		@Test
		void case2() {
			Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
				Location.of(2);
			});
			assertEquals(Error.LOCATION_NUMBER.getMessage(), exception.getMessage());
		}

		@Test
		void case3() {
			Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
				Location.of(100);
			});
			assertEquals(Error.LOCATION_NUMBER.getMessage(), exception.getMessage());
		}

		@Test
		void case4() {
			Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
				Location.of(-2);
			});
			assertEquals(Error.LOCATION_NUMBER.getMessage(), exception.getMessage());
		}

		@Test
		void case5() {
			Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
				Location.of(-100);
			});
			assertEquals(Error.LOCATION_NUMBER.getMessage(), exception.getMessage());
		}
	}

}
