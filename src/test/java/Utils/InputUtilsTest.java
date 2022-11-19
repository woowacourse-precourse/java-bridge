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
        @DisplayName("정수를 입력받을 경우")
        void case1() {
            String input = "3";
            assertThat(InputUtils.isDigit(input)).isTrue();
        }


        @DisplayName("정수 이외의 값을 입력받을 경우")
        @ValueSource(strings = {"숫자", "??", "1000j", "abcd"})
        @ParameterizedTest
        void case2(String input) {
            assertThat(InputUtils.isDigit(input)).isFalse();
        }
    }

    @Nested
    @DisplayName("isValidRangeDigit")
    class TestIsValidRangeDigit {

        @DisplayName("3~20 사이의 수를 입력받은 경우")
        @ValueSource(strings = {"3", "10", "20"})
        @ParameterizedTest
        void case1(String input) {
            assertThat(InputUtils.isValidRangeDigit(input)).isTrue();
        }

        @DisplayName("3~20 사이의 수가 아닌 경우")
        @ValueSource(strings = {"-3", "100", "21"})
        @ParameterizedTest
        void case2(String input) {
            assertThat(InputUtils.isValidRangeDigit(input)).isFalse();
        }
    }

    @Nested
    @DisplayName("isValidBridgePosition 메소드 테스트")
    class TestIsValidBridgePosition {

        @DisplayName("U, D를 입력하였을 경우")
        @ValueSource(strings = {"U", "D"})
        @ParameterizedTest
        void case1(String input) {
            assertThat(InputUtils.isValidBridgePosition(input)).isTrue();
        }

        @DisplayName("U, D 이외의 문자를 입력하였을 경우")
        @ValueSource(strings = {"UP", "DOWN", "85", "???"})
        @ParameterizedTest
        void case2(String input) {
            assertThat(InputUtils.isValidBridgePosition(input)).isFalse();
        }
    }

    @Nested
    @DisplayName("isValidGameRestartInput 메소드 테스트")
    class TestIsValidGameRestartInput {
        @DisplayName("게임 재시작 시 R, Q를 입력하였을 경우")
        @ValueSource(strings = {"R", "Q"})
        @ParameterizedTest
        void case1(String input) {
            assertThat(InputUtils.isValidGameRestartInput(input)).isTrue();
        }

        @DisplayName("R, Q 이외의 값을 입력하였을 경우")
        @ValueSource(strings = {"Restart", "Quit", "q", "1"})
        @ParameterizedTest
        void case2(String input) {
            assertThat(InputUtils.isValidGameRestartInput(input)).isFalse();
        }
    }
}