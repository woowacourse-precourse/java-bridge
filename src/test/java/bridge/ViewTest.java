package bridge;

import bridge.view.InputNumValidator;
import bridge.view.InputStringValidator;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class ViewTest {

	@DisplayName("숫자 입력 정상 케이스 테스트")
	@ValueSource(strings = {"1", "2", "10"})
	@ParameterizedTest
	void InputNumValidatorTest(String input) {
		Assertions.assertThatCode(() -> new InputNumValidator(input))
				.doesNotThrowAnyException();
	}

	@DisplayName("숫자 입력 예외 케이스 테스트")
	@ValueSource(strings = {" ", "", "what", "1 2"})
	@ParameterizedTest
	void InputNumValidatorExceptionTest(String input) {
		Assertions.assertThatThrownBy(() -> new InputNumValidator(input))
				.isInstanceOf(IllegalArgumentException.class);
	}

	@DisplayName("문자 입력 정상 케이스 테스트")
	@ValueSource(strings = {"D", "U", "R", "Q"})
	@ParameterizedTest
	void InputStringValidatorTest(String input) {
		Assertions.assertThatCode(() -> new InputStringValidator(input))
				.doesNotThrowAnyException();
	}

	@DisplayName("문자 예외 케이스 테스트")
	@ValueSource(strings = {" ", "", "1", "$", "a,b"})
	@ParameterizedTest
	void InputStringValidatorExceptionTest(String input) {
		Assertions.assertThatThrownBy(() -> new InputStringValidator(input))
				.isInstanceOf(IllegalArgumentException.class);
	}



}
