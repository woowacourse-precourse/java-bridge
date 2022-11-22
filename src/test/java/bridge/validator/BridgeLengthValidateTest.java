package bridge.validator;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class BridgeLengthValidateTest {
	@DisplayName("숫자만으로 이루어진 문자열이 아닌 경우 예외 발생")
	@ParameterizedTest
	@ValueSource(strings = {"a", "ㄱㄴㄷ", " ", "", "!@#", "1a2b", "+", "1.5", "-12", "1.0"})
	void notNumber(String input) {
		assertThatThrownBy(() -> {
			BridgeLengthValidate.validateNumber(input);
		}).isInstanceOf(IllegalArgumentException.class);
	}

	@DisplayName("유효범위가 아닌 숫자를 입력한 경우 예외 발생")
	@ParameterizedTest
	@ValueSource(strings = {"1", "2,", "21", "0", "-1", "100"})
	void outOfRange(String input) {
		assertThatThrownBy(() -> {
			BridgeLengthValidate.validateRange(input);
		}).isInstanceOf(IllegalArgumentException.class);
	}
}
