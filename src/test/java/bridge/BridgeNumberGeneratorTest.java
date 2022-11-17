package bridge;

import static org.assertj.core.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class BridgeNumberGeneratorTest {

    BridgeNumberGenerator generator;

    @BeforeEach
    void setUp() {
        generator = new BridgeRandomNumberGenerator();
    }

    @DisplayName("랜덤 넘버는 0 또는 1")
    @Test
    void generate() {
        assertThat(generator.generate())
            .isGreaterThanOrEqualTo(0)
            .isLessThanOrEqualTo(1);
    }

}
