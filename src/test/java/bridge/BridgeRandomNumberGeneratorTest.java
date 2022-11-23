package bridge;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

class BridgeRandomNumberGeneratorTest {

    @Test
    @DisplayName("랜덤으로 0또는 1을 반환한다.")
    void generate() {
        // given
        BridgeNumberGenerator numberGenerator = new BridgeRandomNumberGenerator();
        int generate = numberGenerator.generate();

        // expected
        assertTrue(generate == 0 || generate == 1);
    }
}