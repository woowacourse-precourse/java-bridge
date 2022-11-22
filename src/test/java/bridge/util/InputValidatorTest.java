package bridge.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class InputValidatorTest {

    private final InputValidator inputValidator = new InputValidator();

    @DisplayName("입력받은 다리의 길이가 숫자가 아닌 문자열인 경우 예외가 발생한다.")
    @Test
    void validateBridgeSizeByString() {
        String bridgeSize = "three";
        assertThatThrownBy(() -> inputValidator.validateBridgeSize(bridgeSize))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("입력받은 다리의 길이가 3 이상 20 이하의 숫자가 아닌 경우 예외가 발생한다.")
    @Test
    void validateBridgeSizeByOutOfRangeNumber() {
        int bridgeSize = 21;
        assertThatThrownBy(() -> inputValidator.validateBridgeSizeRange(bridgeSize))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("입력받은 이동할 칸이 U(위 칸)와 D(아래 칸) 중 하나의 문자가 아닌 경우 예외가 발생한다.")
    @Test
    void validateMovingUOrD() {
        String moving = "R";
        assertThatThrownBy(() -> inputValidator.validateMoving(moving))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("입력받은 재시작/종료 여부가 R(재시작)과 Q(종료) 중 하나의 문자가 아닌 경우 예외가 발생한다.")
    @Test
    void validateGameCommandROrQ() {
        String gameCommand = "U";
        assertThatThrownBy(() -> inputValidator.validateGameCommand(gameCommand))
                .isInstanceOf(IllegalArgumentException.class);
    }

}