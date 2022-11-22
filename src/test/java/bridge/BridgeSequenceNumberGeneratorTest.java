package bridge;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class BridgeSequenceNumberGeneratorTest {

    @DisplayName("정해진값을순차적으로 반환, 범위가 넘어가면 0만 반환")
    @Test
    void generate() {
        BridgeNumberGenerator bridgeNumberGenerator = new BridgeSequenceNumberGenerator(
                List.of(0, 1, 1)
        );
        assertThat(bridgeNumberGenerator.generate()).isEqualTo(0);
        assertThat(bridgeNumberGenerator.generate()).isEqualTo(1);
        assertThat(bridgeNumberGenerator.generate()).isEqualTo(1);
        assertThat(bridgeNumberGenerator.generate()).isEqualTo(0);
        assertThat(bridgeNumberGenerator.generate()).isEqualTo(0);
    }
}