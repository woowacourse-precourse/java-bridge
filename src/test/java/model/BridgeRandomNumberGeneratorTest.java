package model.constant;

import static org.assertj.core.api.Assertions.assertThat;

import bridge.BridgeNumberGenerator;
import bridge.BridgeRandomNumberGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

public class BridgeRandomNumberGeneratorTest {

    BridgeNumberGenerator numberGenerator = new BridgeRandomNumberGenerator();

    @Nested
    @DisplayName("generate 메서드는")
    class describe_generate {

        @Test
        @DisplayName("0또는 1의 값을 반환한다.")
        void returnZeroOrOne() {
            for (int i = 0; i < 1000; i++) {
                assertThat(numberGenerator.generate()).isGreaterThanOrEqualTo(0).isLessThanOrEqualTo(1);
            }
        }
    }
}
