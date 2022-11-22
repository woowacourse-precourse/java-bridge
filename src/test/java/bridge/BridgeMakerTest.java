package bridge;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

class BridgeMakerTest {
    private BridgeMaker bridgeMaker;

    @BeforeEach
    void setUp() {
        bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
    }

    @ParameterizedTest
    @MethodSource("generateValidBridgeSize")
    void makeBridge_정상범위_다리의길이(int bridgeSize) {
        List<String> bridge = bridgeMaker.makeBridge(bridgeSize);
        boolean actual = bridge.stream()
                .anyMatch(s -> (!s.equals("U")) && (!s.equals("D")));

        assertThat(actual).isFalse();
    }

    @ParameterizedTest
    @ValueSource(ints = {-1, 0, 2, 21, 30})
    void makeBridge_비정상범위_다리의길이(int bridgeSize) {
        assertThatThrownBy(() -> bridgeMaker.makeBridge(bridgeSize))
                .isInstanceOf(IllegalArgumentException.class);
    }

    private static Stream<Integer> generateValidBridgeSize() {
        List<Integer> bridgeSizes = new ArrayList<>();
        for (int bridgeSize = 3; bridgeSize <= 20; bridgeSize++) {
            bridgeSizes.add(bridgeSize);
        }

        return bridgeSizes.stream();
    }
}