package bridge;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class BridgeRandomNumberGeneratorTest {

    private static final int NUMBER_OF_ITERATIONS = 1000;
    private BridgeRandomNumberGenerator bridgeRandomNumberGenerator;

    @BeforeEach
    void setUp() {
        bridgeRandomNumberGenerator = new BridgeRandomNumberGenerator();
    }

    @Test
    void 랜덤_검증() {
        int actual = 0;
        while (actual < NUMBER_OF_ITERATIONS) {
            int number = bridgeRandomNumberGenerator.generate();
            if (!(number == 0 || number == 1)) {
                break;
            }
            actual++;
        }
        assertThat(actual).isEqualTo(NUMBER_OF_ITERATIONS);
    }
}