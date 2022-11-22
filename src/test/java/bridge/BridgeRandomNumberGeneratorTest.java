package bridge;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;

import static org.assertj.core.api.Assertions.assertThat;

class BridgeRandomNumberGeneratorTest {

    @DisplayName("0또는 1을 반환하는지 확인")
    @RepeatedTest(10)
    void testForGenerate() {
        BridgeNumberGenerator bridgeNumberGenerator = new BridgeRandomNumberGenerator();
        int result = bridgeNumberGenerator.generate();
        assertThat(result).isBetween(0, 1);
    }

}
