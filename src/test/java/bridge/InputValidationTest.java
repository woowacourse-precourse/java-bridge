package bridge;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class InputValidationTest {

    @DisplayName("입력 값이 없거나 공백이면 예외가 발생한다.")
    @ValueSource(strings = {"", " ", "       "})
    @ParameterizedTest
    void inputBlank(String input) {
        assertThatThrownBy(
            () -> new InputValidation().checkBlank(input)).isInstanceOf(
            IllegalArgumentException.class);
    }

    @DisplayName("입력 값이 정수로 변환 불가하면 예외가 발생한다.")
    @ValueSource(strings = {"abc", "123a", "@##", " . ", "12345678900", "-10987654321"})
    @ParameterizedTest
    void inputNotNumeric(String input) {
        assertThatThrownBy(
            () -> new InputValidation().checkNumeric(input)).isInstanceOf(
            IllegalArgumentException.class);
    }

    @DisplayName("다리 크기값이 3보다 작거나 20보다 크다면 예외가 발생한다.")
    @ValueSource(strings = {"2", "21", "0", "-3", "1234567890", "-1234567890"})
    @ParameterizedTest
    void inputInvalidBridgeSize(int input) {
        assertThatThrownBy(
            () -> new InputValidation().checkBridgeSize(input)).isInstanceOf(
            IllegalArgumentException.class);
    }

    @DisplayName("사용자가 이동할 칸이 U 또는 D가 아니면 예외가 발생한다.")
    @ValueSource(strings = {"", " ", ".", "0", "a", "u", "d", "UD"})
    @ParameterizedTest
    void inputInvalidMoving(String input) {
        assertThatThrownBy(
            () -> new InputValidation().checkMoving(input)).isInstanceOf(
            IllegalArgumentException.class);
    }

    @DisplayName("사용자의 재시작 여부가 R 또는 Q가 아니면 예외가 발생한다.")
    @ValueSource(strings = {"", " ", ";", "1", "b", "r", "Q", "RQ"})
    @ParameterizedTest
    void inputInvalidGameCommand(String input) {
        assertThatThrownBy(
            () -> new InputValidation().checkMoving(input)).isInstanceOf(
            IllegalArgumentException.class);
    }

}