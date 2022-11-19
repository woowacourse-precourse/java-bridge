package bridge;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import bridge.validation.Validation;

public class ValidationTest {

	@DisplayName("input의 범위 테스트")
	@Test
	void validateRange_메서드_테스트() {
		String input = "22";
		Assertions.assertThrows(IllegalArgumentException.class,
			() -> Validation.validateRange(input));
	}

	@DisplayName("input이 숫자만으로 이루어져있는지 테스트")
	@Test
	void validateNumberOnly_메서드_테스트() {
		String input = "a";
		Assertions.assertThrows(IllegalArgumentException.class,
			() -> Validation.validateNumberOnly(input));
	}

	@DisplayName("input이 올바른 길이인지 테스트")
	@Test
	void validateLength_메서드_테스트() {
		String input = "22";
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

	@DisplayName("U 혹은 D이외의 입력이 들어오면 예외처리")
	@Test
	void validateUOrD_메서드_테스트() {
		String input = "Z";
		Assertions.assertThrows(IllegalArgumentException.class,
			() -> Validation.validateUOrD(input));
	}
}
