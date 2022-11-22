package bridge;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class GameCommandTest {

	@DisplayName("유효하지 않은 재시작 여부 입력시 예외를 발생한다.")
	//given
	@ValueSource(strings = {"2", "U", "D", "0", "", " "})
	@ParameterizedTest
	void gameCommandTestAbnormal(String strings) {
		//when, then
		assertThatThrownBy(() -> {
			GameCommand gameCommand = new GameCommand(strings);
		}).isInstanceOf(IllegalArgumentException.class);
	}

	@DisplayName("재시작 여부를 검증한다.")
	//given
	@ValueSource(strings = {"R", "Q"})
	@ParameterizedTest
	void gameCommandTestNormal(String strings) {
		//when, then
		assertDoesNotThrow(() -> {
			GameCommand gameCommand = new GameCommand(strings);
		});
	}
}