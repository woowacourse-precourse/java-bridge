package bridge;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import bridge.Validation.Validation;

public class ValidationTest {

	@DisplayName("input이 숫자만으로 이루어져있는지 테스트")
	@Test
	void validateNumberOnly_메서드_테스트() {
		String input = "a";
		Assertions.assertThrows(IllegalArgumentException.class,
			() -> Validation.validateNumberOnly(input));
	}
}
