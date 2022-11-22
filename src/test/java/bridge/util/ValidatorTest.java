package bridge.util;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class ValidatorTest {

    Validator validator = new Validator();

    @DisplayName("다리 사이즈 유효성 검사 - 예외 테스트")
    @ValueSource(ints = {0, 1, -1, 21, 199})
    @ParameterizedTest
    void validateBridgeSizeTest(Integer input) {
        assertThatThrownBy(() -> validator.validateBridgeSize(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("방향 유효성 검사 - 예외 테스트")
    @ValueSource(strings = {"A", " ", "", "Z", "3", "*", "R", "Q"})
    @ParameterizedTest
    void validateDirectionTest(String input) {
        assertThatThrownBy(() -> validator.validateDirection(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("명령어 유효성 검사 - 예외 테스트")
    @ValueSource(strings = {"A", " ", "", "Z", "3", "*", "U", "D"})
    @ParameterizedTest
    void validateCommandTest(String input) {
        assertThatThrownBy(() -> validator.validateCommand(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("다리 사이즈 유효성 검사 - 유효하면 true값 도출")
    @ValueSource(ints = {3, 4, 7, 9, 19, 20})
    @ParameterizedTest
    void isValidRangeTrueTest(int input) {
        Assertions.assertThat(validator.isValidRange(input)).isEqualTo(true);
    }

    @DisplayName("다리 사이즈 유효성 검사 - 유효하지 않으면 false값 도출")
    @ValueSource(ints = {0, 1, -1, 21, 199})
    @ParameterizedTest
    void isValidRangeFalseTest(int input) {
        Assertions.assertThat(validator.isValidRange(input)).isEqualTo(false);
    }

    @DisplayName("방향 유효성 검사 - 유효하면 true값 도출")
    @ValueSource(strings = {"U", "D"})
    @ParameterizedTest
    void isValidMovingTrueTest(String input) {
        Assertions.assertThat(validator.isValidMoving(input)).isEqualTo(true);
    }

    @DisplayName("방향 유효성 검사 - 유효하지 않으면 false값 도출")
    @ValueSource(strings = {"A", " ", "", "Z", "3", "*", "R", "Q"})
    @ParameterizedTest
    void isValidMovingFalseTest(String input) {
        Assertions.assertThat(validator.isValidMoving(input)).isEqualTo(false);
    }

    @DisplayName("명령어 유효성 검사 - 유효하면 true값 도출")
    @ValueSource(strings = {"R", "Q"})
    @ParameterizedTest
    void isValidCommandTrueTest(String input) {
        Assertions.assertThat(validator.isValidCommand(input)).isEqualTo(true);
    }

    @DisplayName("명령어 유효성 검사 - 유효하지 않으면 false값 도출")
    @ValueSource(strings = {"A", " ", "", "Z", "3", "*", "U", "D"})
    @ParameterizedTest
    void isValidCommandFalseTest(String input) {
        Assertions.assertThat(validator.isValidCommand(input)).isEqualTo(false);
    }
}