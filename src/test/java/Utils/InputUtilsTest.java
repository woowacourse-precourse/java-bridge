package Utils;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

class InputUtilsTest {

    @Nested
    @DisplayName("isDigit 메소드 테스트")
    class TestIsDigit {
        @Test
        @DisplayName("정수를 입력받을 경우 true 리턴")
        void isDigit_playerInputDigitType_returnTrue() {
            String input = "3";
            boolean result = InputUtils.isDigit(input);
            assertThat(result).isTrue();
        }


        @DisplayName("정수 이외의 값을 입력받을 경우 false 리턴")
        @ValueSource(strings = {"숫자", "??", "1000j", "abcd"})
        @ParameterizedTest
        void isDigit_playerInputOtherType_returnFalse(String input) {
            boolean result = InputUtils.isDigit(input);
            assertThat(result).isFalse();
        }
    }

    @Nested
    @DisplayName("isValidRangeDigit")
    class TestIsValidRangeDigit {

        @DisplayName("3~20 사이의 수를 입력받은 경우 true 리턴")
        @ValueSource(strings = {"3", "10", "20"})
        @ParameterizedTest
        void isValidRangeDigit_playerInputIsValidRange_returnTrue(String input) {
            boolean result = InputUtils.isValidRangeDigit(input);
            assertThat(result).isTrue();
        }

        @DisplayName("3~20 사이의 수가 아닌 경우 false 리턴")
        @ValueSource(strings = {"-3", "100", "21"})
        @ParameterizedTest
        void isValidRangeDigit_playerInputIsNotValidRange_returnTrue(String input) {
            boolean result = InputUtils.isValidRangeDigit(input);
            assertThat(result).isFalse();
        }
    }

    @Nested
    @DisplayName("isValidBridgePosition 메소드 테스트")
    class TestIsValidBridgePosition {

        @DisplayName("U, D를 입력하였을 경우 true 리턴")
        @ValueSource(strings = {"U", "D"})
        @ParameterizedTest
        void isValidBridgePosition_playerInputIsUOrD_returnTrue(String input) {
            boolean result = InputUtils.isValidBridgePosition(input);
            assertThat(result).isTrue();
        }

        @DisplayName("U, D 이외의 문자를 입력하였을 경우 false 리턴")
        @ValueSource(strings = {"UP", "DOWN", "85", "???"})
        @ParameterizedTest
        void isValidBridgePosition_playerInputIsNotUOrD_returnFalse(String input) {
            boolean result = InputUtils.isValidBridgePosition(input);
            assertThat(result).isFalse();
        }
    }

    @Nested
    @DisplayName("isValidGameRestartInput 메소드 테스트")
    class TestIsValidGameRestartInput {
        @DisplayName("게임 재시작 시 R, Q를 입력하였을 경우 true 리턴")
        @ValueSource(strings = {"R", "Q"})
        @ParameterizedTest
        void isValidGameRestartInput_playerInputIsROrQ_returnTrue(String input) {
            boolean result = InputUtils.isValidGameRestartInput(input);
            assertThat(result).isTrue();
        }

        @DisplayName("R, Q 이외의 값을 입력하였을 경우 false 리턴")
        @ValueSource(strings = {"Restart", "Quit", "q", "1"})
        @ParameterizedTest
        void isValidGameRestartInput_playerInputIsNotROrQ_returnFalse(String input) {
            boolean result = InputUtils.isValidGameRestartInput(input);
            assertThat(result).isFalse();
        }
    }
}