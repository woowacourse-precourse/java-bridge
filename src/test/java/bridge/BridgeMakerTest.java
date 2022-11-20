package bridge;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class BridgeMakerTest {

    @DisplayName("다리 길이만큼 다리를 생성한다.")
    @ParameterizedTest
    @ValueSource(ints = {6, 12, 8})
    void bridgeMakeTest(int size) {
        BridgeNumberGenerator bridgeNumberGenerator = new MockBridgeNumberGenerator(0);

        BridgeMaker bridgeMaker = new BridgeMaker(bridgeNumberGenerator);

        List<String> bridge = bridgeMaker.makeBridge(size);
        List<String> expected = new LinkedList<>();

        for (int i = 0; i < size; i++) {
            expected.add("D");
        }

        assertTrue(bridge.containsAll(expected));
    }

    class MockBridgeNumberGenerator implements BridgeNumberGenerator {
        private final int mark;

        public MockBridgeNumberGenerator(int mark) {
            this.mark = mark;
        }

        @Override
        public int generate() {
            return mark;
        }
    }
}