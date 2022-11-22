package bridge.view;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class InputValidatorTest {

	InputValidator inputValidator = new InputValidator();

	@DisplayName("다리의 길이가 3부터 20사이의 숫자가 아니라면 예외가 발생한다.")
	@ParameterizedTest
	@ValueSource(strings = {"가나다", "a", "-1", "0", "1", "2", "21", "22", "99"})
	void validateBridgeSizeTest(String string) {
		Assertions.assertThrows(IllegalArgumentException.class,
			() -> inputValidator.validateBridgeSize(string));
	}

	@DisplayName("이동할 칸의 입력이 U또는 D가 아니라면 예외가 발생한다.")
	@ParameterizedTest
	@ValueSource(strings = {"가나다", "1", "a", "u", "d", "UD"})
	void validateMovementTest(String string) {
		Assertions.assertThrows(IllegalArgumentException.class,
			() -> inputValidator.validateMovement(string));
	}

	@DisplayName("재시도 입력이 R또는 Q가 아니라면 예외가 발생한다.")
	@ParameterizedTest
	@ValueSource(strings = {"가나다", "1", "a", "r", "q", "rq"})
	void validateRetryTest(String string) {
		Assertions.assertThrows(IllegalArgumentException.class,
			() -> inputValidator.validateRetry(string));
	}
}
