package bridge.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import bridge.domain.command.GameCommand;

class GameCommandTest {

	@ParameterizedTest
	@ValueSource(strings = {"A", "S", "K", "Q", "Z", "R", "O"})
	@DisplayName("이동 입력값 예외 테스트")
	void commandMoveInputTest(String input) {
		assertThrows(IllegalArgumentException.class, () -> GameCommand.findMoveCommand(input));
	}

	@ParameterizedTest
	@ValueSource(strings = {"U", "T", "E", "W", "D"})
	@DisplayName("재시작 입력값 예외 테스트")
	void commandInputRetryTest(String input) {
		assertThrows(IllegalArgumentException.class, () -> GameCommand.isContinueGame(input));
	}
}
