package bridge.exception;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class InputExceptionHandlerTest {

	@ParameterizedTest
	@DisplayName("다리 길이를 3~20 사이에 숫자로 입력받는다. - 성공")
	@ValueSource(strings = {"3", "10", "20"})
	void checkBridgeSizeForm(String input) {
		assertThatCode(
			() -> InputExceptionHandler.checkBridgeSizeForm(input)
		).doesNotThrowAnyException();
	}

	@ParameterizedTest
	@DisplayName("다리 길이 입력이 3~20 사이에 숫자가 아니면 예외가 발생한다. - 실패")
	@ValueSource(strings = {"1", "1j", "21", "jj"})
	void checkBridgeSizeFormFailureWhenNotRangeOrNotNumeric(String input) {
		assertThatThrownBy(
			() -> InputExceptionHandler.checkBridgeSizeForm(input)
		).isInstanceOf(IllegalArgumentException.class);
	}

	@ParameterizedTest
	@DisplayName("이동 칸에 대한 입력은 U 또는 D으로 입력받는다. - 성공")
	@ValueSource(strings = {"U", "D"})
	void checkMovingCommand(String input) {
		assertThatCode(
			() -> InputExceptionHandler.checkMovingCommand(input)
		).doesNotThrowAnyException();
	}

	@ParameterizedTest
	@DisplayName("이동 칸에 대한 입력이 U 또는 D가 아닐 경우 예외처리 된다. - 실패")
	@ValueSource(strings = {"1", "Q", "UP", "UD"})
	void checkMovingCommandFailureWhenNotMovingCommand(String input) {
		assertThatThrownBy(
			() -> InputExceptionHandler.checkMovingCommand(input)
		).isInstanceOf(IllegalArgumentException.class);
	}

	@ParameterizedTest
	@DisplayName("재시도 입력은 Q 또는 R로 입력받는다. - 성공")
	@ValueSource(strings = {"Q", "R"})
	void checkRetryCommand(String input) {
		assertThatCode(
			() -> InputExceptionHandler.checkRetryCommand(input)
		).doesNotThrowAnyException();
	}

	@ParameterizedTest
	@DisplayName("재시도 입력이 Q 또는 R이 아닐 경우 예외 처리된다. - 실패")
	@ValueSource(strings = {"1", "D", "U", "QR"})
	void checkRetryCommandFailureWhenNotRetryCommand(String input) {
		assertThatThrownBy(
			() -> InputExceptionHandler.checkRetryCommand(input)
		).isInstanceOf(IllegalArgumentException.class);
	}
}
