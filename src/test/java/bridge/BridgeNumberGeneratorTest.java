package bridge;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class BridgeNumberGeneratorTest {

    BridgeNumberGenerator bridgeNumberGenerator;

    @BeforeEach
    void setUp() {
        bridgeNumberGenerator = new BridgeRandomNumberGenerator();
    }

    @DisplayName("생성된 값이 0 또는 1 인지 확인")
    @Test
    void generateValueTest() {
        int generate = bridgeNumberGenerator.generate();

        assertThat(generate).isBetween(0, 1);
    }
}