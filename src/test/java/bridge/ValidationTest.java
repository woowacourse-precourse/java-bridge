package bridge;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import bridge.Validation.Validation;

public class ValidationTest{

	@DisplayName("올바르지 않은 BridgeSize입력 예외처리 테스트")
	@ParameterizedTest
	@ValueSource(strings = {"22", "ㅁ"})
	void isBridgeSizeException_메서드_테스트(String input) {

		Assertions.assertAll(
			() -> validateNumberOnly_메서드_테스트(input),
			() -> validateLength_메서드_테스트(input),
			() -> validateRange_메서드_테스트(input)
		);
	}

	@DisplayName("input이 숫자만으로 이루어져있는지 테스트")
	private void validateRange_메서드_테스트(String input) {
		Assertions.assertThrows(IllegalArgumentException.class,
			() -> Validation.validateRange(input));
	}

	@DisplayName("input이 숫자만으로 이루어져있는지 테스트")
	void validateNumberOnly_메서드_테스트(String input) {
		Assertions.assertThrows(IllegalArgumentException.class,
			() -> Validation.validateNumberOnly(input));
	}

	@DisplayName("input이 올바른 길이인지 테스트")
	void validateLength_메서드_테스트(String input) {
		Assertions.assertThrows(IllegalArgumentException.class,
			() -> Validation.validateLength(input, 1));
	}


	@DisplayName("R 혹은 Q이외의 입력이 들어오면 예외처리")
	@Test
	void validateROrQ_메서드_테스트() {
		String input = "T";
		Assertions.assertThrows(IllegalArgumentException.class,
			() -> Validation.validateROrQ(input));
	}
}
