package bridge.validation;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class ValidationTest {

    private static final String ERROR_MESSAGE = "[ERROR]";

    @DisplayName("다리의 길이 입력값이 숫자 이외의 값이 들어오면 에러가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"1a34, ㄱ1ㄴㄷ, !1aㄴ, .12@3, '', ' '"})
    void createBridgeLengthNumOtherThanNum(String bridgeLength) {
        assertThatThrownBy(() -> Validation.checkBridgeSizeInput(bridgeLength))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining(ERROR_MESSAGE);
    }

    @DisplayName("다리의 길이 입력값이 0으로 시작하면 에러가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"01, 001, 000, 0000, 000017"})
    void createBridgeLengthStartZero(String bridgeLength) {
        assertThatThrownBy(() -> Validation.checkBridgeSizeInput(bridgeLength))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining(ERROR_MESSAGE);
    }

    @DisplayName("다리의 길이가 3이상 20이하가 아니면 에러가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"21", "2", "0", "-1"})
    void createBridgeLengthOutOfRange3To20(String bridgeLenght) {
        assertThatThrownBy(() -> Validation.checkBridgeSizeInput(bridgeLenght))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining(ERROR_MESSAGE);
    }

    @DisplayName("다리 이동 입력값이 U 혹은 D가 아니면 에러가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"a", "1", "!", "ㄱ", "U1", "u", "d"})
    void createMoveCommandOtherThanUOrD(String moveCommand) {
        assertThatThrownBy(() -> Validation.checkMoveCommand(moveCommand))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining(ERROR_MESSAGE);
    }

    @DisplayName("게임 종료 후 입력값이 R 혹은 Q가 아니면 에러가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"a", "1", "@", "ㄱ", "R1", "r", "q"})
    void createGameCommandOtherThanQOrR(String gameCommand) {
        assertThatThrownBy(() -> Validation.checkGameCommand(gameCommand))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining(ERROR_MESSAGE);
    }
}