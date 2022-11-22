package bridge;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BridgeRandomNumberGeneratorTest {

    private final BridgeRandomNumberGenerator bridgeRandomNumberGenerator =
            new BridgeRandomNumberGenerator();

    @Test
    @DisplayName("0 ,1 둘 중 랜덤 출력")
    void generateTest() {
        for (int i = 0; i < 100; i++) {
            int randomNumber = bridgeRandomNumberGenerator.generate();
            assertThat(randomNumber == 0 || randomNumber == 1)
                    .isEqualTo(true);
        }
    }
}