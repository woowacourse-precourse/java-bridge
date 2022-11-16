package bridge.domain.strategy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

public class BridgeNumberGeneratorTest {
    public static final BridgeNumberGenerator BRIDGE_NUMBER_GENERATOR_ONE = () -> 1;
    public static final BridgeNumberGenerator BRIDGE_NUMBER_GENERATOR_ZERO = () -> 0;
    
    @Test
    @DisplayName("숫자 생성")
    void generate() {
        assertAll(
                () -> assertThat(BRIDGE_NUMBER_GENERATOR_ONE.generate()).isEqualTo(1),
                () -> assertThat(BRIDGE_NUMBER_GENERATOR_ZERO.generate()).isZero()
        );
    }
}