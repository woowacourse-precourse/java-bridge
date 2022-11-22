package bridge.filter;

import static bridge.message.MessageConstants.*;
import static bridge.restrict.RestrictConstants.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class UserInputFilterTest {

	private final UserInputFilter filter = new UserInputFilter();

	@Test
	@DisplayName("min, max 사이의 값 변환")
	void bindingBridgeSizeTest() {
		int minBridgeSize = filter.bindingBridgeSize("3");
		int maxBridgeSize = filter.bindingBridgeSize("20");
		Assertions.assertThat(minBridgeSize).isEqualTo(MIN_NUMBER);
		Assertions.assertThat(maxBridgeSize).isEqualTo(MAX_NUMBER);
	}

	@ParameterizedTest
	@DisplayName("min, max 사이의 값이 아닌 경우 예외 발생")
	@ValueSource(strings = {"", "2", "21", "10a", "aa"})
	void bindingBridgeSizeExceptionTest(String userInput) {
		Assertions.assertThatThrownBy(() -> filter.bindingBridgeSize(userInput))
			.isInstanceOf(IllegalArgumentException.class);
	}

	@Test
	@DisplayName("이동 커맨드 검사")
	void checkMoveCommandTest() {
		filter.bindingMoveCommand("U");
		filter.bindingMoveCommand("D");
	}

	@ParameterizedTest
	@DisplayName("이동 커맨드가 아닌 경우 예외 발생")
	@ValueSource(strings = {"", "1", "A", "Q", "R", "AA"})
	void checkMoveCommandExceptionTest(String userInput) {
		Assertions.assertThatThrownBy(() -> filter.bindingMoveCommand(userInput))
			.isInstanceOf(IllegalArgumentException.class);
	}

	@Test
	@DisplayName("재시작 및 종료 커맨드 검사")
	void bindingRestartOrExitCommandTest() {
		String restart = filter.bindingRestartOrExitCommand("R");
		String exit = filter.bindingRestartOrExitCommand("Q");
		Assertions.assertThat(restart).isEqualTo(RESTART_COMMAND_MESSAGE);
		Assertions.assertThat(exit).isEqualTo(EXIT_COMMAND_MESSAGE);
	}

	@ParameterizedTest
	@DisplayName("재시작 및 종료 커맨드가 아닌 경우 예외 발생")
	@ValueSource(strings = {"", "1", "A", "U", "D", "AA"})
	void bindingRestartOrExitCommandExceptionTest(String userInput) {
		Assertions.assertThatThrownBy(() -> filter.bindingRestartOrExitCommand(userInput))
			.isInstanceOf(IllegalArgumentException.class);
	}
}
