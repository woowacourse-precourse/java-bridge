package bridge.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

class BridgeGameTest {
    final BridgeGame bridgeGame = new BridgeGame();

    @DisplayName("다리 길이가 3 ~ 20 사이면 정상적으로 생성이 된다.")
    @ValueSource(ints = {3, 5, 10, 15, 20})
    @ParameterizedTest(name = "{index}. 다리 길이: {0}")
    public void createBridgeSuccessTest(int bridgeSize) {
        assertThatNoException().isThrownBy(() -> bridgeGame.createBridge(bridgeSize));
    }

    @DisplayName("다리 길이가 3 ~ 20 사이가 아닌 경우 예외가 다리 생성에 실패한다.")
    @ValueSource(ints = {0, 1, 2, 21, 25})
    @ParameterizedTest(name = "{index}. 다리 길이: {0}")
    public void createBridgeFailTest(int bridgeSize) {
        assertThatThrownBy(() -> bridgeGame.createBridge(bridgeSize))
                .isInstanceOf(IllegalArgumentException.class);
    }
}