package bridge.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;

class BridgeRandomNumberGeneratorTest {

    @DisplayName("임의의 숫자를 생성한다.")
    @Test
    void generate() {
        assertRandomNumberInRangeTest(() -> {
            BridgeRandomNumberGenerator randomNumberGenerator = new BridgeRandomNumberGenerator();

            assertThat(randomNumberGenerator.generate()).isEqualTo(1);
        }, 1 );
    }
}