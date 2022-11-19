package bridge.exception;


import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BridgeGameInputExceptionTest {
     private final BridgeGameInputException bridgeGameInputException = new BridgeGameInputException();

    @DisplayName("다리의 길이가 3~20인지 아니라면 예외가 발생한다.")
    @Test
    public void validateWrongBridgeSize() {
        //given
        int size = 1;

        //when,then
        assertThatThrownBy(() ->bridgeGameInputException.validateBridgeSize(size))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("이동하는 입력값이 잘못되었으면다예외가 발생한.")
    @Test
    public void validateWrongMoveInput() {
        //given
        String move = "a";

        //when,then
        assertThatThrownBy(() ->bridgeGameInputException.validateMovingChoice(move))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("게임 재시작 입력값이 잘못되었으면다예외가 발생한.")
    @Test
    public void validateWrongGameCommandInput() {
        //given
        String gameCommand = "b";

        //when,then
        assertThatThrownBy(() ->bridgeGameInputException.validateGameCommand(gameCommand))
                .isInstanceOf(IllegalArgumentException.class);
    }
}