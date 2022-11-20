package bridge.model.validation;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import bridge.model.constant.Error;

class ExitOptionTest {
	@DisplayName("R 혹은 Q를 입력하면 Boolean을 리턴한다.")
	@Nested
	class BooleanTest {
		@ParameterizedTest
		@ValueSource(strings = {"R", "r"})
		void trueCase(String value) {
			assertTrue(ExitOption.of(value).isReplay());
		}

		@ParameterizedTest
		@ValueSource(strings = {"Q", "q"})
		void falseCase(String value) {
			assertFalse(ExitOption.of(value).isReplay());
		}
	}

	@DisplayName("R 혹은 Q 외의 것을 입력하면 에러 메시지를 출력한다")
	@ParameterizedTest
	@ValueSource(strings = {"", " ", "a", "d", "u", "D", "U", "Z", "0", "-1", "100000"})
	void exceptionCase(String value) {
		Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
			ExitOption.of(value);
		});
		Assertions.assertEquals(Error.EXIT_OPTION.getMessage(), exception.getMessage());
	}

}
