package bridge;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BridgeRandomNumberGeneratorTest {
    private static final int ZERO_RANGE_BRIDGE=0;
    private static final int ONE_RANGE_BRIDGE=1;
    private final BridgeRandomNumberGenerator bridgeRandomNumberGenerator = new BridgeRandomNumberGenerator();

    @Test
    @DisplayName("[generate] 1000번의 시행으로 0 혹은 1값만 생성하는지 테스트 한다.")
    void generate() {
        //given
        int testCase=1000;
        int correctCount=0;
        //when
        int generate = bridgeRandomNumberGenerator.generate();
        for (int count = 0; count < testCase; count++) {
            if (generate == ONE_RANGE_BRIDGE || generate == ZERO_RANGE_BRIDGE) {
                correctCount++;
            }
        }
        //then
        assertThat(correctCount).isEqualTo(testCase);
    }
}