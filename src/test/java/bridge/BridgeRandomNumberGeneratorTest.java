package bridge;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class BridgeRandomNumberGeneratorTest {
    @DisplayName("0 또는 1 만 생성된다.")
    @Test
    public void createBridgeRandomNumber() {
        BridgeRandomNumberGenerator bridgeRandomNumberGenerator = new BridgeRandomNumberGenerator();
        assertThat(bridgeRandomNumberGenerator.generate()).isIn(0, 1);
    }
}