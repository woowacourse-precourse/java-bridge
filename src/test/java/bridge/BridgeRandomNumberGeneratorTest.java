package bridge;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BridgeRandomNumberGeneratorTest {

    private static final int RANDOM_LOWER_INCLUSIVE = 0;
    private static final int RANDOM_UPPER_INCLUSIVE = 1;

    @Test
    @DisplayName("0 또는 1을 반환하는지 테스트")
    void generateTest() {
        BridgeRandomNumberGenerator bridgeRandomNumberGenerator = new BridgeRandomNumberGenerator();
        int result = bridgeRandomNumberGenerator.generate();
        assertTrue(result == RANDOM_LOWER_INCLUSIVE || result == RANDOM_UPPER_INCLUSIVE);
    }
}
