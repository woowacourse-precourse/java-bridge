package bridge;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BridgeRandomNumberGeneratorTest {

    @DisplayName("0과 1을 가져오는지 확인")
    @Test
    void generate_테스트() {
        BridgeRandomNumberGenerator bridgeRandomNumberGenerator = new BridgeRandomNumberGenerator();
        List<Integer> testRange = new ArrayList<>();
        for(int i=0; i<100; i++) {
            testRange.add(bridgeRandomNumberGenerator.generate());
        }
        Assertions.assertThat(testRange).containsOnly(1, 0);
    }
}