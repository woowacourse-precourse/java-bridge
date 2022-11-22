package bridge;

import bridge.domain.Bridge;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class BridgeBrokerTest {
    BridgeBroker broker;

    @BeforeEach
    void beforeEach() throws Exception {
        broker = new BridgeBroker();
    }

    @DisplayName("정상 다리 길이 입력")
    @ValueSource(ints = {3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20})
    @ParameterizedTest
    void goodCommand(int n) {
        Bridge bridge = broker.makeBridge(n);
        System.out.println(bridge.toString());
    }

    @DisplayName("비정상 다리 길이 입력")
    @ValueSource(ints = {-1, 0, 1, 2, 21, 22, 210000000})
    @ParameterizedTest
    void badCommand(int n) {
        assertThrows(IllegalArgumentException.class, () -> {
            Bridge bridge = broker.makeBridge(n);
            System.out.println(bridge.toString());
        });
    }
}
