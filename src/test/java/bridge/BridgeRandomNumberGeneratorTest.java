package bridge;


import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;

class BridgeRandomNumberGeneratorTest {
    private BridgeNumberGenerator bridgeRandomNumberGenerator;

    @BeforeEach
    void setUp() {
        this.bridgeRandomNumberGenerator = new BridgeRandomNumberGenerator();
    }

    @RepeatedTest(value = 10, name = "0또는 1을 생성한다.")
    void generateRandomNumber() {
        assertThat(bridgeRandomNumberGenerator.generate()).isBetween(0, 1);
    }
}
