package bridge;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import bridge.controller.RunController;

public class RunControllerTest {

	@DisplayName("게임이 성공했는지 확인")
	@Test
	void createSuccessGame() {
		String message = "[ O |   ]\n[   | X ]";
		boolean result = false;

		assertThat(new RunController().isClearGame(message)).isEqualTo(result);
	}

	@DisplayName("게임이 실패했는지 확인")
	@Test
	void createFailGame() {
		String message = "[ O |   ]\n[   | O ]";
		boolean result = true;

		assertThat(new RunController().isClearGame(message)).isEqualTo(result);
	}

	@DisplayName("move_입력을 잘못했을 경우")
	@Test
	void createWrongCharacter() {
		String moving = "F";

		assertThatThrownBy(() -> new RunController().checkMoving(moving))
				.isInstanceOf(IllegalArgumentException.class);
	}

	@DisplayName("move_소문자를 입력했을 경우")
	@Test
	void createLowerCharacter() {
		String moving = "u";

		assertThatThrownBy(() -> new RunController().checkMoving(moving))
				.isInstanceOf(IllegalArgumentException.class);
	}

	@DisplayName("move_숫자를 입력했을 경우")
	@Test
	void createNumber() {
		String moving = String.valueOf(85);

		assertThatThrownBy(() -> new RunController().checkMoving(moving))
				.isInstanceOf(IllegalArgumentException.class);
	}

	@DisplayName("공백일 경우")
	@Test
	void createSpace() {
		String moving = "";
		
		assertThatThrownBy(() -> new RunController().checkMoving(moving))
				.isInstanceOf(IllegalArgumentException.class);
	}
}
