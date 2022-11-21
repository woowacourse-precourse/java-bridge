package bridge.domain.player;

import bridge.view.input.InputException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

public class MovementCommandTest {

	private static final String UPPER_SIDE_MOVEMENT = "U";
	private static final String DOWN_SIDE_MOVEMENT = "D";

	@DisplayName("이동할 칸 정상값 입력시 인스턴스 생성을 검증한다")
	@ParameterizedTest
	@ValueSource(strings = {UPPER_SIDE_MOVEMENT, DOWN_SIDE_MOVEMENT})
	void verify_Movement_CreateInstance(String value) {
		assertThat(new MovementCommand(value)).isInstanceOf(MovementCommand.class);
	}

	@DisplayName("이동할 칸 입력시 정상값을 제외한 다른 입력에 대한 예외 처리를 검증한다")
	@ParameterizedTest
	@ValueSource(strings = {"a", "@", "UP", "1", "u"})
	void verify_Movement_OnlyAsAssigned(String value) {
		assertThatThrownBy(() -> MovementCommand.valueOf(value))
				.isInstanceOf(IllegalArgumentException.class)
				.hasMessage(InputException.MOVEMENT_NOT_ASSIGNED_COMMAND);
	}
}
