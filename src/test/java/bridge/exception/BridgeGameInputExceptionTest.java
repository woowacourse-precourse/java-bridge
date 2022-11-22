package bridge.exception;


import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BridgeGameInputExceptionTest {
    private final BridgeGameInputException bridgeGameInputException = new BridgeGameInputException();

    @DisplayName("다리의 길이가 3~20사이가 아니라면 예외가 발생한다.")
    @Test
    public void validateWrongBridgeSizeRangeTest() {
        //given
        String size = "1";

        //when,then
        assertThatThrownBy(() -> bridgeGameInputException.validateBridgeSize(size))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("다리의 길이가 숫자가 아니라면 예외가 발생한다.")
    @Test
    public void validateWrongBridgeSizeTypeTest() {
        //given
        String size = "a";

        //when,then
        assertThatThrownBy(() -> bridgeGameInputException.validateBridgeSize(size))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("다리의 길이가 비어있다면 예외가 발생한다.")
    @Test
    public void validateWrongBridgeSizeBlankTest() {
        //given
        String size = " ";

        //when,then
        assertThatThrownBy(() -> bridgeGameInputException.validateBridgeSize(size))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("이동하는 입력값이 잘못되었으면 예외가 발생한다.")
    @Test
    public void validateWrongMoveInputTest() {
        //given
        String move = "a";

        //when,then
        assertThatThrownBy(() -> bridgeGameInputException.validateMovingChoice(move))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("게임 재시작 입력값이 잘못되었으면 예외가 발생한다.")
    @Test
    public void validateWrongGameCommandInputTest() {
        //given
        String gameCommand = "b";

        //when,then
        assertThatThrownBy(() -> bridgeGameInputException.validateGameCommand(gameCommand))
                .isInstanceOf(IllegalArgumentException.class);
    }
}