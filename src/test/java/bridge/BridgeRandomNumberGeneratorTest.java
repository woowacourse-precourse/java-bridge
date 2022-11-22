package bridge;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BridgeRandomNumberGeneratorTest {

    @DisplayName("0 또는 1을 랜덤하게 생성하는지 검증한다.")
    @Test
    void generateNumbers() {
        BridgeRandomNumberGenerator randomNumberGenerator = new BridgeRandomNumberGenerator();

        int result = randomNumberGenerator.generate();

        assertThat(result).isGreaterThanOrEqualTo(0).isLessThanOrEqualTo(1);
    }

}