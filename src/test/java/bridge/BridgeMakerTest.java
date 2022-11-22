package bridge;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class BridgeMakerTest {

    BridgeRandomNumberGenerator bridgeRandomNumberGenerator = new BridgeRandomNumberGenerator();
    BridgeMaker bridgeMaker = new BridgeMaker(bridgeRandomNumberGenerator);

    @DisplayName("3 미만 다리 생성")
    @ParameterizedTest(name = "{displayName} : {0}")
    @CsvSource({"2", "1", "0", "-1"})
    void lowerThan3(int size) {
        try {
            bridgeMaker.makeBridge(size);
        } catch (IllegalArgumentException e) {
            assertEquals(Error.OUT_OF_RANGE.toString(), e.getMessage());
        }
    }


    @DisplayName("20 초과 다리 생성")
    @ParameterizedTest(name = "{displayName} : {0}")
    @CsvSource({"20", "33", "66"})
    void upperThan20(int size) {
        try {
            bridgeMaker.makeBridge(size);
        } catch (IllegalArgumentException e) {
            assertEquals(Error.OUT_OF_RANGE.toString(), e.getMessage());
        }
    }

    @DisplayName("정상적인 범위")
    @ParameterizedTest(name = "{displayName} : {0}")
    @CsvSource({"3", "10", "20"})
    void correctValue(int size) {
        List<String> bridge = bridgeMaker.makeBridge(size);
        assertEquals(size, bridge.size());
    }
}
