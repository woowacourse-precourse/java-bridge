package bridge;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import bridge.Validation.Validation;

public class ValidationTest{

	@DisplayName("올바르지 않은 BridgeSize입력 예외처리 테스트")
	@ParameterizedTest
	@ValueSource(strings = {"22", "ㅁ"})
	void isBridgeSizeException_메서드_테스트(String input) {

		Assertions.assertAll(
			() -> validateNumberOnly_메서드_테스트(),
			() -> validateNumberLength_메서드_테스트()
		);
	}

	@DisplayName("input이 숫자만으로 이루어져있는지 테스트")
	void validateNumberOnly_메서드_테스트() {
		String input = "a";
		Assertions.assertThrows(IllegalArgumentException.class,
			() -> Validation.validateNumberOnly(input));
	}

	@DisplayName("input이 올바른 길이인지 테스트")
	void validateNumberLength_메서드_테스트() {
		String input = "22";
		Assertions.assertThrows(IllegalArgumentException.class,
			() -> Validation.validateNumberLength(input, 1));
	}
}
