package bridge.engine;

import bridge.BridgeMaker;
import bridge.BridgeNumberGenerator;
import bridge.BridgeRandomNumberGenerator;
import bridge.model.Bridge;
import bridge.model.Crossing;
import bridge.model.UpOrDown;
import java.util.ArrayList;
import java.util.stream.Stream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
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

    @Nested
    @TestInstance(Lifecycle.PER_CLASS)
    @DisplayName("cross 메서드는")
    class DescribeCross {

        private Stream<Arguments> provideNullSource() {
            return Stream.of(
                    Arguments.of(null, new Bridge(new ArrayList<>()), new UpOrDown("U")),
                    Arguments.of(new Crossing(new ArrayList<>()), null, new UpOrDown("U")),
                    Arguments.of(new Crossing(new ArrayList<>()), new Bridge(new ArrayList<>()), null)
            );
        }

        @ParameterizedTest
        @MethodSource("provideNullSource")
        @DisplayName("인자 중 하나라도 null이라면 IllegalArgumentException을 반환")
        void throwIllegalArgumentExceptionWhenReceiveNull(Crossing crossing, Bridge bridge, UpOrDown upOrDown) {
            //then
            Assertions.assertThatThrownBy(() -> gameEngine.cross(crossing, bridge, upOrDown))
                    .isInstanceOf(IllegalArgumentException.class);
        }
    }
}