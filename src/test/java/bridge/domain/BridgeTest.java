package bridge.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;

import bridge.BridgeNumberGenerator;
import bridge.BridgeRandomNumberGenerator;
import bridge.domain.Bridge;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class BridgeTest {

    @DisplayName("다리길이는 size와 동일하게 생성된다. ")
    @ParameterizedTest
    @CsvSource({
        "3,3", "5,5", "10, 10", "20, 20"
    })
    void 다리_길이_테스트(int size, int expected) {
        BridgeNumberGenerator bridgeNumberGenerator = new BridgeRandomNumberGenerator();
        Bridge bridge = new Bridge(size, bridgeNumberGenerator);
        assertEquals(expected, bridge.get().size());
    }

}
