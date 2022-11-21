package bridge;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class BridgeMakerTest {
    private BridgeMaker bridgeMaker;

    @BeforeEach
    void setUp() {
        bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
    }

    @DisplayName("다리를 만들고 길이를 비교한다.")
    @ValueSource(ints = { 2, 21, 0 })
    @ParameterizedTest
    void bridgeSizeCheck(Integer input) {
        assertThat(bridgeMaker.makeBridge(input).size()).isEqualTo(input);
    }
}