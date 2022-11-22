package bridge.domain.command;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class MoveCommandTest {

	@ParameterizedTest
	@ValueSource(strings = {"A", "S", "K", "Q", "Z", "R", "O"})
	@DisplayName("이동 입력값 예외 테스트")
	void commandMoveInputTest(String input) {
		assertThrows(IllegalArgumentException.class, () -> MoveCommand.findCommand(input));
	}
}
