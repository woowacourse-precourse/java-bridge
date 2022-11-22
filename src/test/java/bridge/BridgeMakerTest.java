package bridge;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class BridgeMakerTest {
    BridgeMaker bridgeMaker;

    @BeforeEach
    void generateBridgeMaker() {
        BridgeRandomNumberGenerator bridgeRandomNumberGenerator = new BridgeRandomNumberGenerator();
        bridgeMaker = new BridgeMaker(bridgeRandomNumberGenerator);
    }

    @DisplayName("size input과 다리길이 일치하는지 테스트")
    @ParameterizedTest(name = " input = {0}")
    @ValueSource(ints = {3, 4, 5, 6})
    void lengthCheckTest(int input) {
        List<String> bridge = bridgeMaker.makeBridge(input);

        assertThat(bridge.size()).isEqualTo(input);
    }

    @DisplayName("예외처리 테스트")
    @ParameterizedTest(name = "input = {0}")
    @ValueSource(ints = {-1, 0, 1, 2, 21})
    void checkRangeExceptionTest(int input) {
        assertThatThrownBy(() -> assertThat(bridgeMaker.makeBridge(input))
                .isInstanceOf(IllegalArgumentException.class));
    }
}
