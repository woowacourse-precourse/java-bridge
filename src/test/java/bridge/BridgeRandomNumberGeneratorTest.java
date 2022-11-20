package bridge;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BridgeRandomNumberGeneratorTest {

    BridgeRandomNumberGenerator generator = new BridgeRandomNumberGenerator();

    @DisplayName("0, 1 으로 생성 되는지 확인")
    @Test
    void generate() {
        for (int i = 0; i < 10; i++) {
            int randomNumber = generator.generate();
            Assertions.assertThat(randomNumber == 0 || randomNumber == 1).isTrue();
        }
    }
}