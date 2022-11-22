package bridge;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class BridgeRandomNumberGeneratorTest {

    private static final int RANDOM_LOWER_INCLUSIVE = 0;
    private static final int RANDOM_UPPER_INCLUSIVE = 1;

    @DisplayName("0과 1중 랜덤한 숫자를 생성한다.")
    @Test
    void generateRandomNumber() {
        BridgeNumberGenerator bridgeNumberGenerator = new BridgeRandomNumberGenerator();

        int randomNumber = bridgeNumberGenerator.generate();

        assertThat(randomNumber).isBetween(RANDOM_LOWER_INCLUSIVE, RANDOM_UPPER_INCLUSIVE);
    }
}
