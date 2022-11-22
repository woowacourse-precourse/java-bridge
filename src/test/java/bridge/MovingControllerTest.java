package bridge;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import bridge.controller.MovingController;

public class MovingControllerTest {

	@DisplayName("move_입력을 잘못했을 경우")
	@Test
	void createWrongCharacter() {
		String moving = "F";

		assertThatThrownBy(() -> new MovingController().checkMoving(moving))
				.isInstanceOf(IllegalArgumentException.class);
	}

	@DisplayName("move_소문자를 입력했을 경우")
	@Test
	void createLowerCharacter() {
		String moving = "u";

		assertThatThrownBy(() -> new MovingController().checkMoving(moving))
				.isInstanceOf(IllegalArgumentException.class);
	}

	@DisplayName("move_숫자를 입력했을 경우")
	@Test
	void createNumber() {
		String moving = String.valueOf(85);

		assertThatThrownBy(() -> new MovingController().checkMoving(moving))
				.isInstanceOf(IllegalArgumentException.class);
	}

	@DisplayName("공백일 경우")
	@Test
	void createSpace() {
		String moving = "";
		
		assertThatThrownBy(() -> new MovingController().checkMoving(moving))
				.isInstanceOf(IllegalArgumentException.class);
	}
}
