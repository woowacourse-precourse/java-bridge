package bridge.validator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.provider.ValueSource;

import bridge.exception.ErrorMessage;
import bridge.validator.BridgeBoardValidator;
import camp.nextstep.edu.missionutils.test.Assertions;

public class BridgeBoardValidatorTest {

	@DisplayName("validate는")
	@Nested
	class Validate {

		@DisplayName("입력받은 문자열이 U나 D이면 그 문자열을 반환한다")
		@Test
		void validInput() {
			String board = "U";
			String result = BridgeBoardValidator.validate(board);

			assertThat(result).isEqualTo(board);
		}

		@DisplayName("입력받은 문자열이 U나 D이가 아니면 예외를 던진다")
		@Test
		void invalidInput() {
			String board = "r";
			assertThatThrownBy(() -> BridgeBoardValidator.validate(board))
				.isInstanceOf(IllegalArgumentException.class)
				.hasMessageContaining(ErrorMessage.BRIDGE_BOARD_ERROR.getMessage());
		}
	}

}
