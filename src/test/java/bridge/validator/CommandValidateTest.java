package bridge.validator;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class CommandValidateTest {
	@DisplayName("여러 개의 문자를 입력한 경우 예외 발생")
	@ParameterizedTest
	@ValueSource(strings = {"UD", "UU", "DD", "UDUD", "UDDU", "Uu", "uU", "Dd", "dD", "U "})
	void multipleCharacter(String input) {
		assertThatThrownBy(() -> {
			CommandValidate.validateCharacter(input);
		}).isInstanceOf(IllegalArgumentException.class);
	}

	@DisplayName("영어 외의 문자를 입력한 경우 예외 발생")
	@ParameterizedTest
	@ValueSource(strings = {"1", "ㄱ", "가", " ", "", "@", "+", "1.5", "-1", "[", "`"})
	void notEnglish(String input) {
		assertThatThrownBy(() -> {
			CommandValidate.validateEnglish(input);
		}).isInstanceOf(IllegalArgumentException.class);
	}

	@DisplayName("영어 소문자를 입력한 경우 예외 발생")
	@ParameterizedTest
	@ValueSource(strings = {"u", "d"})
	void lowerCase(String input) {
		assertThatThrownBy(() -> {
			CommandValidate.validateUpperCase(input);
		}).isInstanceOf(IllegalArgumentException.class);
	}

	@DisplayName("U와 D이외의 영어 대문자를 입력한 경우 예외 발생")
	@ParameterizedTest
	@ValueSource(strings = {"A", "B", "C", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S",
		"T", "V", "W", "X", "Y", "Z"})
	void notUD(String input) {
		assertThatThrownBy(() -> {
			CommandValidate.validateExactCharacterUD(input);
		}).isInstanceOf(IllegalArgumentException.class);
	}

	@DisplayName("R와 Q 이외의 문자를 입력한 경우 예외 발생")
	@ParameterizedTest
	@ValueSource(strings = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "S",
		"T", "U", "V", "W", "X", "Y", "Z"})
	void notRQ(String input) {
		assertThatThrownBy(() -> {
			CommandValidate.validateExactCharacterRQ(input);
		}).isInstanceOf(IllegalArgumentException.class);
	}
}
