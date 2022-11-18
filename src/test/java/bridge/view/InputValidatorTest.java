package bridge.view;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class InputValidatorTest {

	InputValidator inputValidator = new InputValidator();
	private static final String ERROR_MESSAGE = "[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다.";

	@DisplayName("다리의 길이가 3부터 20사이의 숫자가 아니라면 예외가 발생한다.")
	@ParameterizedTest
	@ValueSource(strings = {"가나다", "a", "-1", "0", "1", "2", "21", "22", "99"})
	void validateBridgeLengthTest(String string) {
		Assertions.assertThrows(IllegalArgumentException.class,
			() -> inputValidator.validateBridgeLength(string));
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
