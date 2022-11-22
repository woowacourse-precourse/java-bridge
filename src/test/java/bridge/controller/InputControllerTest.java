package bridge.controller;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class InputControllerTest {

    private final InputController inputController = new InputController();

    @DisplayName("다리 길이 입력 숫자 변환 테스트")
    @Test
    void getBridgeSizeTest() {
        String bridgeSize = "3";
        int actual = inputController.getBridgeSize(bridgeSize);
        assertThat(actual).isEqualTo(Integer.parseInt(bridgeSize));
    }
}
