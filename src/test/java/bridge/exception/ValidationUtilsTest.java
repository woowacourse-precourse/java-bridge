package bridge.exception;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class ValidationUtilsTest {


    @DisplayName("다리의 길이를 숫자로 입력 받지 않는 경우 예외처리.")
    @ParameterizedTest
    @CsvSource({"h", "A", "영"})
    void inputBridgeLengthByNotNumeric(String input) {
        assertThatThrownBy(() -> ValidationUtils.numeric(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("다리의 길이가 맞지 않는 범위 라면 예외 처리.")
    @ParameterizedTest
    @CsvSource({"-1", "2", "21", "20000"})
    void inputBridgeLengthByOverSize(int size) {
        assertThatThrownBy(() -> ValidationUtils.size(size))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("이동할 때 공백이 입력 되는 경우 예외처리.")
    @Test
    void inputMoveLetterByBlank() {
        assertThatThrownBy(() -> ValidationUtils.letter(""))
                .isInstanceOf(IllegalArgumentException.class);
    }
    
    @DisplayName("이동할 때 다른 문자가 입력 되는 경우 예외처리.")
    @ParameterizedTest
    @CsvSource({"t", "-1", "u", "I"})
    void inputMoveLetterByAnotherLetter(String input) {
        assertThatThrownBy(() -> ValidationUtils.letter(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("게임이 실패 하고 다른 문자가 입력 되는 경우 예외처리.")
    @ParameterizedTest
    @CsvSource({"-1", "r", "다"})
    void inputEndLetterByAnotherLetter(String input) {
        assertThatThrownBy(() -> ValidationUtils.endLetter(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

}