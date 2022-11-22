package bridge;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class GameCommandTest {
	@ParameterizedTest
	@DisplayName("입력값이 Q,R 이외의 값일 경우 예외가 발생한다.")
	@ValueSource(strings = {" ", "q", "r", "1"})
	void createMoveCodeByUnvalidateInput(String input) {
		assertThatThrownBy(() -> GameCommand.getGameCommandByGameCommandCode(input))
				.isInstanceOf(IllegalArgumentException.class);
	}
}