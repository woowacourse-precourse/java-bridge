package bridge;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class BridgeMakerTest {

    private static BridgeRandomNumberGenerator BRIDGE_RANDOM_NUMBER_GENERATOR;
    private static BridgeMaker BRIDGE_MAKER;

    @BeforeEach
    void setUp() {
        BRIDGE_RANDOM_NUMBER_GENERATOR = new BridgeRandomNumberGenerator();
        BRIDGE_MAKER = new BridgeMaker(BRIDGE_RANDOM_NUMBER_GENERATOR);
    }

    @DisplayName("makeBridge 함수 테스트")
    @ParameterizedTest
    @ValueSource(ints = {4, 5, 6, 7, 8, 9, 20})
    void makeBridge_test(int inputSize) {
        List<String> result = BRIDGE_MAKER.makeBridge(inputSize);
        assertThat(result).hasSize(inputSize)
                .doesNotContain("0")
                .doesNotContain("1");
    }

}