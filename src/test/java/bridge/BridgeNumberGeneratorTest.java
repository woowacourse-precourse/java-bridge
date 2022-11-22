package bridge;

import camp.nextstep.edu.missionutils.test.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class BridgeNumberGeneratorTest {

    @DisplayName("숫자 생성은 0 또는 1이어야 한다.")
    @Test
    void _0또는1반환(){
        BridgeNumberGenerator bridgeNumberGenerator = new BridgeRandomNumberGenerator();
        Assertions.assertSimpleTest(()-> {
            assertThat(bridgeNumberGenerator.generate()).isBetween(0, 1);
        });
    }

}