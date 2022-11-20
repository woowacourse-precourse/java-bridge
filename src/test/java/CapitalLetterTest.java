import static bridge.util.Constants.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import bridge.util.CapitalLetter;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class CapitalLetterTest {
    @DisplayName("알파벳이 아닌 값이 들어가면 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"위", "d0wn", "올라up", "u!"})
    void nonAlphabeticInputException(String input) {
        assertThatThrownBy(() -> new CapitalLetter(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_TITLE + NON_ALPHABETIC_CHARACTER_FOUND);
    }

    @DisplayName("입력 받은 알파벳을 전부 대문자로 변환한다.")
    @ParameterizedTest
    @CsvSource(value = {"ab:AB", "cDe:CDE", "z:Z"}, delimiter = ':')
    void capitalizeTest(String input, String expected) {
        CapitalLetter letter = new CapitalLetter(input);
        assertThat(letter.capitalize()).isEqualTo(expected);
    }
}