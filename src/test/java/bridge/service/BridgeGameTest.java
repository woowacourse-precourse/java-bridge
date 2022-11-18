package bridge.service;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

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
}