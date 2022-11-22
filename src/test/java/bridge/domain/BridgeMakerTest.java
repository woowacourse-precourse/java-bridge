package bridge.domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import bridge.domain.Bridge;
import bridge.domain.BridgeLength;
import bridge.domain.BridgeMaker;
import bridge.domain.BridgeMove;
import bridge.domain.BridgeRandomNumberGenerator;
import java.util.stream.Stream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class BridgeMakerTest {
    private static BridgeMaker bridgeMaker;

    @BeforeEach
    void setUp() {
        bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
    }

    @Test
    @DisplayName("생성자 인수에 Null이 입력되면 예외 발생")
    void constructorTest() {
        assertThatThrownBy(() -> new BridgeMaker(null))
                .isInstanceOf(NullPointerException.class)
                .hasMessageContaining("BridgeNumberGenerator는 Null이 될 수 없습니다.");
    }

    @ParameterizedTest(name = "입력한 다리의 길이만큼 다리를 생성한다")
    @MethodSource
    void makeBridge(BridgeLength bridgeLength) {
        Bridge bridge = bridgeMaker.makeBridge(bridgeLength);
        assertThat(bridge.getBridgeLength()).isEqualTo(bridgeLength.getLength());
        for (int round = 1; round <= bridge.getBridgeLength().getLength(); round++) {
            assertThat(bridge.getMove(round)).isInstanceOf(BridgeMove.class);
        }
    }

    private static Stream<Arguments> makeBridge() {
        return Stream.of(
                Arguments.of(new BridgeLength(3)),
                Arguments.of(new BridgeLength(4)),
                Arguments.of(new BridgeLength(5)),
                Arguments.of(new BridgeLength(20))
        );
    }


}