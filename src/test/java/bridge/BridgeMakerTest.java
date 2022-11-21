package bridge;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BridgeMakerTest {

    private BridgeMaker bridgeMaker;

    @BeforeEach
    public void setup() {
        BridgeNumberGenerator bridgeNumberGenerator = new TestNumberGenerator(1);
        bridgeMaker = new BridgeMaker(bridgeNumberGenerator);
    }

    @Test
    void 다리만들기_테스트() {
        List<String> bridge = bridgeMaker.makeBridge(3);
        assertEquals(3,bridge.size());
    }

    @Test
    void 숫자_입력시_문자로변환_테스트() {
        assertEquals("U",bridgeMaker.changeNumber(1));
        assertEquals("D",bridgeMaker.changeNumber(0));
    }

    public class TestNumberGenerator implements BridgeNumberGenerator {
        private final int number;

        TestNumberGenerator(int number) {
            this.number = number;
        }

        @Override
        public int generate() {
            return number;
        }
    }
}