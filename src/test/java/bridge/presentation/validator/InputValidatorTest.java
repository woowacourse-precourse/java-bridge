package bridge.presentation.validator;

import static org.assertj.core.api.Assertions.*;

import exception.ExceptionMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class InputValidatorTest {

    @DisplayName("다리 길이 입력 값이 숫자가 아닐 경우 예외 발생")
    @Test
    void 다리길이_문자_입력_예외() {
        String bridgeSize = "a";

        assertThatCode(() -> InputValidator.validateBridgeSize(bridgeSize))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessage.NOT_ONE_DIGIT);
    }

    @DisplayName("다리길이가 3 이상 20 이하 범위에 해당하지 않을 경우 예외 발생")
    @Test
    void 다리길이_범위_예외() {
        String bridgeSize = "21";

        assertThatCode(() -> InputValidator.validateBridgeSize(bridgeSize))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessage.ESCAPE_3_TO_20);
    }

    @DisplayName("이동 위치 입력값이 'U' 혹은 'D'가 아닐 경우 예외 발생")
    @Test
    void 이동_위치_입력_예외() {
        String moving = "A";

        assertThatCode(() -> InputValidator.validateMoving(moving))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessage.INPUT_ODD_MOVING);

    }

    @DisplayName("게임 재시도/종료 입력값이 'R' 혹은 'Q'가 아닐 경우 예외 발생")
    @Test
    void 게임_재시도_및_종료_입력_예외() {
        String gameCommand = "A";

        assertThatCode(() -> InputValidator.validateGameCommand(gameCommand))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessage.INPUT_ODD_GAME_COMMAND);
    }

}