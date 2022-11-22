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
        //when
        //then
        for (int count = 0; count < testCase; count++) {
            assertThat(bridgeRandomNumberGenerator.generate()).isIn(ZERO_RANGE_BRIDGE, ONE_RANGE_BRIDGE);
        }
    }
}