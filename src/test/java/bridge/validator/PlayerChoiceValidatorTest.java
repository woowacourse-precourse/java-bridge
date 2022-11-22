package bridge.validator;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

public class PlayerChoiceValidatorTest {

    @DisplayName("방향 입력 실패")
    @ParameterizedTest
    @CsvSource({
        "N,U,D",
        "E,U,D",
        "S,U,D",
        "W,U,D",
    })
    void directionOptionFailTest(String choice, String option, String otherOption) {
        assertThrows(IllegalArgumentException.class, () ->
            PlayerChoiceValidator.validate(
                choice, option, otherOption
            ));
    }

    @DisplayName("방향 입력 성공")
    @ParameterizedTest
    @CsvSource({
        "U,U,D",
        "D,U,D",
    })
    void directionOptionSuccessTest(String choice, String option, String otherOption) {
        assertDoesNotThrow(() ->
            PlayerChoiceValidator.validate(choice, option, otherOption));
    }

    @DisplayName("재시작 여부 입력 실패")
    @ParameterizedTest
    @CsvSource({
        "N,R,Q",
        "E,R,Q",
        "S,R,Q",
        "W,R,Q",
    })
    void retryOptionFailTest(String choice, String option, String otherOption) {
        assertThrows(IllegalArgumentException.class, () ->
            PlayerChoiceValidator.validate(choice, option, otherOption));
    }

    @DisplayName("재시작 여부 입력 성공")
    @ParameterizedTest
    @CsvSource({
        "R,R,Q",
        "Q,R,Q",
    })
    void retryOptionSuccessTest(String choice, String option, String otherOption) {
        assertDoesNotThrow(() ->
            PlayerChoiceValidator.validate(choice, option, otherOption));
    }
}
