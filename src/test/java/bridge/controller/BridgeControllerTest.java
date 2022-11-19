package bridge.controller;

import bridge.view.InputView;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class BridgeControllerTest {

    @DisplayName("다리의 길이를 숫자로 입력받지 않는 경우 예외처리.")
    @Test
    void inputBridgeLengthByNotNumeric() {
        BridgeController bridgeController = new BridgeController();
        assertThatThrownBy(() -> bridgeController.validateNumeric("h"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}