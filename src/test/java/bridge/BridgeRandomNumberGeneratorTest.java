package bridge;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class BridgeRandomNumberGeneratorTest {

    BridgeNumberGenerator bridgeNumberGenerator;

    @BeforeEach
    void init() {
        bridgeNumberGenerator = new BridgeRandomNumberGenerator();
    }

    @Nested
    @DisplayName("0또는 1을 생성하는 기능")
    class isFinished {

        @Test
        @DisplayName("생성된 값이 0또는 1이어야 됨")
        void rightCase2() {
            List<Integer> generatedNumber = new ArrayList<>();
            for (int i = 0; i < 100; i++) {
                generatedNumber.add(bridgeNumberGenerator.generate());
            }
            assertThat(generatedNumber.stream().noneMatch(c -> !c.equals(0) && !c.equals(1))).isTrue();
        }

    }
}