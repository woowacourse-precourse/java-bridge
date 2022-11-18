package util;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class ValidatorTest {
	@DisplayName("숫자가 아닌 다리 길이 입력에 대해 예외를 발생한다.")
	@ValueSource(strings = {"25.1", "abcde", "가나다라", "1ㅁ2a3"})
	@ParameterizedTest
	void validateSizeIsNumber(String strings) {
		assertThatThrownBy(() -> Validator.validateSizeIsNumber(strings)).isInstanceOf(IllegalArgumentException.class);
	}
}