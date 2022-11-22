package bridge;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class BridgeRandomNumberGeneratorTest {

    @DisplayName("랜덤 숫자가 0~1 인지 반복 테스트")
    @RepeatedTest(100)
    void generate() {
        BridgeNumberGenerator bridgeNumberGenerator = new BridgeRandomNumberGenerator();
        int number = bridgeNumberGenerator.generate();
        assertThat(number).isBetween(0,1);
    }
}