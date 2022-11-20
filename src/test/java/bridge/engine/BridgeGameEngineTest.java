package bridge.engine;

import bridge.BridgeMaker;
import bridge.BridgeNumberGenerator;
import bridge.BridgeRandomNumberGenerator;
import bridge.model.Bridge;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class BridgeGameEngineTest {

    private BridgeGameEngine gameEngine;

    @BeforeEach
    void setUp() {
        BridgeGame bridgeGame = new BridgeGame();
        BridgeNumberGenerator bridgeNumberGenerator = new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(bridgeNumberGenerator);

        gameEngine = new BridgeGameEngine(bridgeGame, bridgeMaker);
    }

    @Nested
    @DisplayName("makeBridge 메서드는")
    class DescribeMakeBridge {

        @ParameterizedTest
        @ValueSource(ints = {-1, 2, 21, 2147483647, -2147483648})
        @DisplayName("유저가 입력한 길이가 3 ~ 20 범위에 맞지 않을 경우 IllegalArgumentException을 반환")
        void throwIllegalArgumentExceptionReceiveOverRange(int inputSize) {
            //then
            Assertions.assertThatThrownBy(() -> gameEngine.makeBridge(inputSize))
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @ParameterizedTest
        @ValueSource(ints = {3, 10, 20})
        @DisplayName("유저가 입력한 길이가 3 ~ 20 범위에 맞을 경우 해당 길이의 Bridge 객체 반환")
        void returnBridgeReceiveValidRange(int inputSize) {
            //then
            Assertions.assertThat(gameEngine.makeBridge(inputSize)).isExactlyInstanceOf(Bridge.class);
        }
    }
}