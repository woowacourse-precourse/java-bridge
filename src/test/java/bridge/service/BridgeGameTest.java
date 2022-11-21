package bridge.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import bridge.constant.AfterMovingStatusConstant;
import bridge.domain.Bridge;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class BridgeGameTest {

    private final BridgeGame bridgeGame = BridgeGame.getBridgeGame();
    @DisplayName("Bridge length 오류를 잡아내는지 확인")
    @ValueSource(strings = {"999", "0", "-123", "2", "안녕", "hello"})
    @ParameterizedTest
    void invalidBridgeLengthInput(String input) {
        assertThatThrownBy(() -> bridgeGame.createBridge(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("Bridge length 통과하는지 확인")
    @ValueSource(strings = {"3", "4", "20", "19"})
    @ParameterizedTest
    void validBridgeLengthInput(String input) {
        assertDoesNotThrow(() -> bridgeGame.createBridge(input));
    }

    @DisplayName("Bridge moving 입력이 올바르지 않으면 오류를 잡아내는지 확인")
    @ValueSource(strings = {"A", "1", "가", "C"})
    @ParameterizedTest
    void InvalidBridgeMovingInput(String input) {
        Bridge resultBridge = new Bridge(List.of("U", "D", "D"));
        Bridge compareBridge = new Bridge();
        assertThatThrownBy(() -> bridgeGame.move(resultBridge, compareBridge, input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("Bridge moving 입력이 올바르면 반환값이 올바른지 확인")
    @ValueSource(strings = {"U"})
    @ParameterizedTest
    void validBridgeMovingInput(String input) {
        Bridge resultBridge = new Bridge(List.of("U", "D", "D"));
        Bridge compareBridge = new Bridge();
        assertThat(bridgeGame.move(resultBridge, compareBridge, input)).isEqualTo(AfterMovingStatusConstant.NEXT_TURN);
    }

    @DisplayName("Bridge moving 입력이 올바르면 반환값이 올바른지 확인")
    @ValueSource(strings = {"D"})
    @ParameterizedTest
    void validBridgeMovingInput1(String input) {
        Bridge resultBridge = new Bridge(List.of("U", "D", "D"));
        Bridge compareBridge = new Bridge();
        assertThat(bridgeGame.move(resultBridge, compareBridge, input)).isEqualTo(AfterMovingStatusConstant.FAIL);
    }

    @DisplayName("Bridge moving 입력이 올바르면 반환값이 올바른지 확인")
    @ValueSource(strings = {"D"})
    @ParameterizedTest
    void validBridgeMovingInput2(String input) {
        Bridge resultBridge = new Bridge(List.of("U", "D", "D"));
        Bridge compareBridge = new Bridge();
        bridgeGame.move(resultBridge, compareBridge, "U");
        bridgeGame.move(resultBridge, compareBridge, "D");
        assertThat(bridgeGame.move(resultBridge, compareBridge, input)).isEqualTo(AfterMovingStatusConstant.SUCCESS);
    }

    @DisplayName("Bridge moving 후 출력")
    @ValueSource(strings = {"UDU"})
    @ParameterizedTest
    void validBridgeMovingString(String input) {
        Bridge resultBridge = new Bridge(List.of("U", "D", "D"));
        Bridge compareBridge = new Bridge();
        for (int i = 0; i < input.length(); i++) {
            bridgeGame.move(resultBridge, compareBridge, String.valueOf(input.charAt(i)));
        }
        String bridge = compareBridge.toString(resultBridge);
        Assertions.assertThat(bridge).isEqualTo("[ O |   | X ]\n[   | O |   ]\n");
    }
}