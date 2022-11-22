package bridge.validator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import bridge.exception.ErrorMessage;
import bridge.validator.BridgeSizeValidator;

public class BridgeSizeValidatorTest {

	@DisplayName("validate는")
	@Nested
	class Validate {

		@DisplayName("입력받은 문자열이 3~20 사이의 숫자 문자열이면 그 문자열을 반환한다")
		@Test
		void validInput() {
			String size = "5";
			String result = BridgeSizeValidator.validate(size);

			assertThat(result).isEqualTo(size);
		}

		@DisplayName("입력받은 문자열이 숫자 문자열이 아니면 예외를 던진다")
		@Test
		void innumerableInput() {
			String size = "s";
			assertThatThrownBy(() -> BridgeSizeValidator.validate(size))
				.isInstanceOf(IllegalArgumentException.class)
				.hasMessageContaining(ErrorMessage.NOT_NUMBER_ERROR.getMessage());
		}

		@DisplayName("입력받은 문자열이 숫자 문자열이 아니면 예외를 던진다")
		@Test
		void outRangeInput() {
			String size = "2";
			assertThatThrownBy(() -> BridgeSizeValidator.validate(size))
				.isInstanceOf(IllegalArgumentException.class)
				.hasMessageContaining(ErrorMessage.BRIDGE_SIZE_RANGE_ERROR.getMessage());
		}
	}
}
