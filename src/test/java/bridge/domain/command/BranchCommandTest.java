package bridge.domain.command;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class BranchCommandTest {

	@ParameterizedTest
	@ValueSource(strings = {"U", "T", "E", "W", "D"})
	@DisplayName("재시작 입력값 예외 테스트")
	void wrongInputBranchCommandTest(String input) {
		assertThrows(IllegalArgumentException.class, () -> BranchCommand.findCommand(input));
	}

	@ParameterizedTest
	@ValueSource(strings = {"R", "Q"})
	@DisplayName("재시작 입력값 예외 테스트")
	void inputBranchCommandTest(String input) {
		assertDoesNotThrow(() -> BranchCommand.findCommand(input));

	}

	@Test
	@DisplayName("재시작 입력값이 제대로 결과를 반영하는지 테스트")
	void inputBranchCommandResultTest() {
		String restartInput = "R";
		String quitInput = "Q";

		assertTrue(BranchCommand.isRestartGame(restartInput));
		assertFalse(BranchCommand.isRestartGame(quitInput));
	}
}
