package util;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class ValidatorTest {
	@DisplayName("한자리, 두자리 숫자인 다리 길이를 입력받는다.")
	@ValueSource(strings = {"20", "0", "3", "04"})
	@ParameterizedTest
	void validateSizeIsNumberNormal(String strings) {
		assertDoesNotThrow(() -> Validator.validateSizeIsNaturalNumber(strings));
	}

	@DisplayName("숫자가 아닌 다리 길이 입력에 대해 예외를 발생한다.")
	@ValueSource(strings = {"25.1", "abcde", "가나다라", "1ㅁ2a3", "", "-1"})
	@ParameterizedTest
	void validateSizeIsNumberAbnormal(String strings) {
		assertThatThrownBy(() -> Validator.validateSizeIsNaturalNumber(strings)).isInstanceOf(
			IllegalArgumentException.class);
	}

	@DisplayName("이동할 칸을 입력받는다.")
	@ValueSource(strings = {"U", "D"})
	@ParameterizedTest
	void validateCellPositionNormal(String strings) {
		assertDoesNotThrow(() -> Validator.validateMovingIsCellPosition(strings));
	}

	@DisplayName("U와 D가 아닌 이동할 칸 입력에 대한 예외를 발생한다.")
	@ValueSource(strings = {"25.1", "abcde", "가나다라", "1ㅁ2a3", "u", ""})
	@ParameterizedTest
	void validateCellPositionAbnormal(String strings) {
		assertThatThrownBy(() -> Validator.validateMovingIsCellPosition(strings)).isInstanceOf(
			IllegalArgumentException.class);
	}

	@DisplayName("재시작 여부를 입력 받는다.")
	@ValueSource(strings = {"R", "Q"})
	@ParameterizedTest
	void validateGameCommandNormal(String strings) {
		assertDoesNotThrow(() -> Validator.validateGameCommand(strings));
	}

	@DisplayName("R와 Q가 아닌 재시작 여부 입력에 대한 예외를 발생한다.")
	@ValueSource(strings = {"25.1", "abcde", "가나다라", "1ㅁ2a3", "u", ""})
	@ParameterizedTest
	void validateGameCommandAbnormal(String strings) {
		assertThatThrownBy(() -> Validator.validateGameCommand(strings)).isInstanceOf(IllegalArgumentException.class);
	}
}