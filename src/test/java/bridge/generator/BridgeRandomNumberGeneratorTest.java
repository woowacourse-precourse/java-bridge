package bridge.generator;

import static org.assertj.core.api.Assertions.*;

import java.util.List;

import bridge.BridgeRandomNumberGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;

class BridgeRandomNumberGeneratorTest {
    private final int RANDOM_LOWER_INCLUSIVE = 0;
    private final int RANDOM_UPPER_INCLUSIVE = 1;

    @DisplayName("랜덤으로 아래 위중 건널 수 있는 다리 지정")
    @RepeatedTest(10)
    void generate() {
        //given
        BridgeRandomNumberGenerator bridgeRandomNumberGenerator = new BridgeRandomNumberGenerator();
        //when
        int bridgeRandomNumber = bridgeRandomNumberGenerator.generate();
        //then
        assertThat(List.of(RANDOM_LOWER_INCLUSIVE, RANDOM_UPPER_INCLUSIVE)).contains(bridgeRandomNumber);
    }
}