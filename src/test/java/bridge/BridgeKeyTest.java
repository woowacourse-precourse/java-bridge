package bridge;

import bridge.BridgeKey;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class BridgeKeyTest {

    @ParameterizedTest
    @CsvSource(value = {"1,U", "0,D"})
    @DisplayName("1을 입력 받으면 U를, 0을 입력받으면 D를 반환한다.")
    void bridgeKey(String input, String bridgeKey) {
        assertEquals(BridgeKey.bridgeKey(Integer.parseInt(input)), bridgeKey);
    }

    @ParameterizedTest
    @ValueSource(strings = {"U"})
    void findBridgeKey(String bridgeKey) {
        assertEquals(BridgeKey.UP, BridgeKey.findBridgeKey(bridgeKey));
    }
}