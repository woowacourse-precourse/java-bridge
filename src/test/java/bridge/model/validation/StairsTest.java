package bridge.model.validation;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import bridge.model.constant.Error;

class StairsTest {
	@DisplayName("U 혹은 D를 입력하면 Location Enum 반환한다")
	@Nested
	class CommandTest {
		@ParameterizedTest
		@CsvSource({"U, UP", "u, UP", "D, DOWN", "d, DOWN"})
		void normalCase(String value, Stairs stairs) {
			assertEquals(Stairs.of(value), stairs);
		}

		@ParameterizedTest
		@ValueSource(strings = {"", " ", "a", "q", "r", "Q", "R", "Z", "0", "-1", "100000"})
		void exceptionCase(String value) {
			Throwable exception = assertThrows(IllegalArgumentException.class, () -> Stairs.of(value));
			Assertions.assertEquals(Error.STAIRS_COMMAND.getMessage(), exception.getMessage());
		}
	}

	@DisplayName("1 혹은 0을 입력하면 Location Enum 반환한다")
	@Nested
	class NumberTest {
		@ParameterizedTest
		@CsvSource({"1, UP", "0, DOWN"})
		void normalCase(int value, Stairs stairs) {
			assertEquals(Stairs.of(value), stairs);
		}

		@ParameterizedTest
		@ValueSource(ints = {-100, -2, -1, 2, 21, 100, 10000})
		void exceptionCase(int value) {
			Throwable exception = assertThrows(IllegalArgumentException.class, () -> Stairs.of(value));
			Assertions.assertEquals(Error.STAIRS_NUMBER.getMessage(), exception.getMessage());
		}
	}

	@DisplayName("Stairs command 입력된 문자열이 같은지 여부를 리턴한다")
	@Nested
	class IsEqualTest {
		@ParameterizedTest
		@CsvSource({"U, UP", "u, UP", "D, DOWN", "d, DOWN"})
		void trueCase(String value, Stairs stairs) {
			assertTrue(stairs.isEquals(value));
		}

		@ParameterizedTest
		@CsvSource({"U, DOWN", "u, DOWN", "D, UP", "d, UP"})
		void falseCase1(String value, Stairs stairs) {
			assertFalse(stairs.isEquals(value));
		}

		@ParameterizedTest
		@CsvSource({"1, DOWN", "0, DOWN", "a, UP", "Z, UP"})
		void falseCase2(String value, Stairs stairs) {
			assertFalse(stairs.isEquals(value));
		}
	}

	@DisplayName("getNumber 테스트")
	@Nested
	class GetNumberTest {
		@ParameterizedTest
		@CsvSource({"1, 1", "0, 0"})
		void numberCase(int expected, int actual) {
			assertEquals(Stairs.of(expected).getNumber(), actual);
		}

		@ParameterizedTest
		@CsvSource({"U, 1", "u, 1", "D, 0", "d, 0"})
		void commandCase(String expected, int actual) {
			assertEquals(Stairs.of(expected).getNumber(), actual);
		}
	}

	@DisplayName("getCommand 테스트")
	@Nested
	class GetCommandTest {
		@ParameterizedTest
		@CsvSource({"1, U", "0, D"})
		void numberCase(int expected, String actual) {
			assertEquals(Stairs.of(expected).getCommand(), actual);

		}

		@ParameterizedTest
		@CsvSource({"U, U", "u, U", "D, D", "d, D"})
		void commandCase(String expected, String actual) {
			assertEquals(Stairs.of(expected).getCommand(), actual);
		}
	}

}
