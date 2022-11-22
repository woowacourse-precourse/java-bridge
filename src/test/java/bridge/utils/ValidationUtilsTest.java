package bridge.utils;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatNoException;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("사용자의 입력을 검증한다.")
class ValidationUtilsTest {

    @Nested
    @DisplayName("입력되는 다리 크기의 값을 검증한다.")
    class inputBridgeSizeTest {

        @DisplayName("아무것도 입력이 안되면 오류가 발생된다.")
        @ParameterizedTest
        @ValueSource(strings = {" ", ""})
        void throwExceptionWhenInputNoting(String input) {
            assertThatThrownBy(() -> ValidationUtils.validateBridgeSize(input))
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @DisplayName("3이상 20이하의 숫자가 아니면 오류가 발생한다.")
        @ParameterizedTest
        @ValueSource(strings = {"-1", "0", "2", "21", "100"})
        void throwExceptionWhenInputWrongNumber(String input) {
            assertThatThrownBy(() -> ValidationUtils.validateBridgeSize(input))
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @DisplayName("숫자가 아닌 입력이 주어지면 오류가 발생된다.")
        @ParameterizedTest
        @ValueSource(strings = {"-1a", "z0", "b2", "2o1", "1p0t0"})
        void throwExceptionWhenInputCharacter(String input) {
            assertThatThrownBy(() -> ValidationUtils.validateBridgeSize(input))
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @DisplayName("3 ~ 20사이의 숫자가 입력되면 통과된다.")
        @ParameterizedTest
        @ValueSource(strings = {"3", "4", "5", "10", "18", "19", "20"})
        void passWhenInputThreeToTwenty(String input) {
            assertThatNoException().isThrownBy(() -> ValidationUtils.validateBridgeSize(input));
        }
    }

    @Nested
    @DisplayName("입력되는 이동 명령의 값을 검증한다.")
    class inputMoveCommandTest {

        @DisplayName("아무것도 입력이 안되면 오류가 발생된다.")
        @ParameterizedTest
        @ValueSource(strings = {" ", ""})
        void throwExceptionWhenInputNoting(String command) {
            assertThatThrownBy(() -> ValidationUtils.validateMove(command))
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @DisplayName("U나 D이외의 값이 입력이 되면 오류가 발생한다.")
        @ParameterizedTest
        @ValueSource(strings = {"A", "B", "S", "R", "Q", "C", "z", "u", "d", "0", "*"})
        void throwExceptionWhenInputNotRightCommand(String command) {
            assertThatThrownBy(() -> ValidationUtils.validateMove(command))
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @DisplayName("U나 D를 입력하면 검증이 통과된다.")
        @ParameterizedTest
        @ValueSource(strings = {"U", "D"})
        void passWhenInputUOrD(String command) {
            assertThatNoException().isThrownBy(() -> ValidationUtils.validateMove(command));
        }
    }

    @Nested
    @DisplayName("입력되는 게임 명령을 검증한다.")
    class inputGameCommandTest {

        @DisplayName("아무것도 입력이 안되면 오류가 발생된다.")
        @ParameterizedTest
        @ValueSource(strings = {" ", ""})
        void throwExceptionWhenInputNoting(String command) {
            assertThatThrownBy(() -> ValidationUtils.validateGameCommand(command))
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @DisplayName("R이나 Q이외의 값이 입력이 되면 오류가 발생한다.")
        @ParameterizedTest
        @ValueSource(strings = {"A", "B", "D", "S", "C", "U", "z", "u", "d", "0", "*"})
        void throwExceptionWhenInputNotRightCommand(String command) {
            assertThatThrownBy(() -> ValidationUtils.validateGameCommand(command))
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @DisplayName("R나 Q를 입력하면 검증이 통과된다.")
        @ParameterizedTest
        @ValueSource(strings = {"R", "Q"})
        void passWhenInputUOrD(String command) {
            assertThatNoException().isThrownBy(() -> ValidationUtils.validateGameCommand(command));
        }
    }
}