package bridge.engine;

import bridge.model.Crossing;
import bridge.model.PassOrFail;
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

class BridgeGameTest {

    BridgeGame bridgeGame;

    @BeforeEach
    void setUp() {
        bridgeGame = new BridgeGame();
    }

    @Nested
    @TestInstance(Lifecycle.PER_CLASS)
    @DisplayName("move 메서드는")
    class DescribeMove {

        private Stream<Arguments> provideNullSource() {
            return Stream.of(
                    Arguments.of(null, null),
                    Arguments.of(null, new PassOrFail(true)),
                    Arguments.of(new Crossing(new ArrayList<>()), null)
            );
        }

        @ParameterizedTest
        @MethodSource("provideNullSource")
        @DisplayName("인자로 null을 받을 경우 IllegalArgumentException을 반환")
        void throwIllegalArgumentExceptionWhenReceiveNull(Crossing crossing, PassOrFail passOrFail) {
            //then
            Assertions.assertThatThrownBy(() -> bridgeGame.move(crossing, passOrFail))
                    .isInstanceOf(IllegalArgumentException.class);
        }
    }
}