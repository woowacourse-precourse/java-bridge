package bridge.domain.command;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class BranchCommandTest {

	@ParameterizedTest
	@ValueSource(strings = {"U", "T", "E", "W", "D"})
	@DisplayName("재시작 입력값 예외 테스트")
	void commandInputRetryTest(String input) {
		assertThrows(IllegalArgumentException.class, () -> BranchCommand.findCommand(input));
	}
}
