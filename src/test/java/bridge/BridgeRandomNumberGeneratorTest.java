package bridge;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BridgeRandomNumberGeneratorTest {
    @DisplayName("0,1 둘중 하나가 나와야함. 100번 테스트")
    @Test
    public void generateTest() {
        for (int i = 0; i < 100; i++) {
            int value = new BridgeRandomNumberGenerator().generate();
            boolean expect = 0 <= value && value <= 1;
            boolean result = true;
            assertThat(expect).isEqualTo(result);
        }
    }
}