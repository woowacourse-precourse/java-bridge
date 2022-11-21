package bridge.validator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import bridge.exception.ErrorMessage;
import bridge.validator.GameCommandValidator;

public class GameCommandValidatorTest {

	@DisplayName("validate는")
	@Nested
	class Validate {

		@DisplayName("입력받은 문자열이 R이나 Q이면 그 문자열을 반환한다")
		@Test
		void validInput() {
			String command = "R";
			String result = GameCommandValidator.validate(command);

			assertThat(result).isEqualTo(command);
		}

		@DisplayName("입력받은 문자열이 R이나 Q가 아니면 예외를 던진다")
		@Test
		void invalidInput() {
			String command = "s";
			assertThatThrownBy(() -> GameCommandValidator.validate(command))
				.isInstanceOf(IllegalArgumentException.class)
				.hasMessageContaining(ErrorMessage.GAME_COMMAND_ERROR.getMessage());
		}

	}
}
