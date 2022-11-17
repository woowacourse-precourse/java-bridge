package bridge;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

public class GameCommandTest {

	private static final String COMMAND_RETRY = "R";
	private static final String COMMAND_QUIT = "Q";

	@DisplayName("재시도 및 종료 선택 정상값 입력시 인스턴스 생성을 검증한다")
	@ParameterizedTest
	@ValueSource(strings = {COMMAND_RETRY, COMMAND_QUIT})
	void verify_GameCommand_CreateInstance(String value) {
		assertThat(new GameCommand(value)).isInstanceOf(GameCommand.class);
	}

	@DisplayName("재시도 및 종료 선택시 정상값을 제외한 다른 입력에 대한 예외 처리를 검증한다")
	@ParameterizedTest
	@ValueSource(strings = {"U", "0", "RETRY", "r"})
	void verify_GameCommand_OnlyAsAssigned(String value) {
		assertThatThrownBy(() -> GameCommand.valueOf(value))
				.isInstanceOf(IllegalArgumentException.class)
				.hasMessage(InputException.GAME_COMMAND_NOT_ASSIGNED_COMMAND);
	}
}
