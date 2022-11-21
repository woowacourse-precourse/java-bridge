package bridge;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class InputBridgeGameValidatorTest {

    @DisplayName("숫자가 아닐 경우")
    @Test
    void isDigitBridgeSize() {
        String bridgeSize = "a";
        InputBridgeGameValidator inputBridgeGameValidator = new InputBridgeGameValidator();

        assertThatThrownBy(
            () -> new InputBridgeGameValidator().validateBridgeSize(bridgeSize)).isInstanceOf(
            IllegalArgumentException.class);
    }

    @DisplayName("다리 크기에 빈 문자열을 입력할 경우 예외 처리")
    @Test
    void isEmptyBridgeSize() {
        String bridgeSize = "";
        InputBridgeGameValidator inputBridgeGameValidator = new InputBridgeGameValidator();

        assertThatThrownBy(
            () -> new InputBridgeGameValidator().validateBridgeSize(bridgeSize)).isInstanceOf(
            IllegalArgumentException.class);
    }

    @DisplayName("다리 크기가 3 이상 20 이하의 숫자가 아닐 경우 예외 처리")
    @Test
    void checkRangeBridgeSize() {
        String bridgeSize = "2";
        InputBridgeGameValidator inputBridgeGameValidator = new InputBridgeGameValidator();

        assertThatThrownBy(
            () -> new InputBridgeGameValidator().validateBridgeSize(bridgeSize)).isInstanceOf(
            IllegalArgumentException.class);
    }

    @DisplayName("움직임 명령어에 빈 문자열을 입력할 경우 예외 처리")
    @Test
    void isEmptyMoveCommand() {
        String bridgeSize = "";
        InputBridgeGameValidator inputBridgeGameValidator = new InputBridgeGameValidator();

        assertThatThrownBy(
            () -> new InputBridgeGameValidator().isMoveCommand(bridgeSize)).isInstanceOf(
            IllegalArgumentException.class);
    }

    @DisplayName("움직임 명령어가 U or D가 아닐 경우 예외 처리")
    @Test
    void isMoveCommand() {
        String bridgeSize = "T";
        InputBridgeGameValidator inputBridgeGameValidator = new InputBridgeGameValidator();

        assertThatThrownBy(
            () -> new InputBridgeGameValidator().isMoveCommand(bridgeSize)).isInstanceOf(
            IllegalArgumentException.class);
    }

    @DisplayName("게임 재시작 여부 명령어에 빈 문자열을 입력할 경우 예외 처리")
    @Test
    void isEmptyGameCommand() {
        String bridgeSize = "";
        InputBridgeGameValidator inputBridgeGameValidator = new InputBridgeGameValidator();

        assertThatThrownBy(
            () -> new InputBridgeGameValidator().isGameCommand(bridgeSize)).isInstanceOf(
            IllegalArgumentException.class);
    }

    @DisplayName("게임 재시작 여부 명령어가 R or Q가 아닐 경우 예외 처리")
    @Test
    void isGameCommand() {
        String bridgeSize = "T";
        InputBridgeGameValidator inputBridgeGameValidator = new InputBridgeGameValidator();

        assertThatThrownBy(
            () -> new InputBridgeGameValidator().isGameCommand(bridgeSize)).isInstanceOf(
            IllegalArgumentException.class);
    }
}