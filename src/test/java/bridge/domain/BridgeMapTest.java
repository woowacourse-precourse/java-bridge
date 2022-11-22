package bridge.domain;

import java.util.List;
import java.util.Stack;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BridgeMapTest {
    private BridgeMap bridgeMap;
    private Stack<String> upStairs;
    private Stack<String> downStairs;

    @BeforeEach
    void setUp() {
        bridgeMap = new BridgeMap();
        upStairs = new Stack<>();
        downStairs = new Stack<>();
    }

    @Test
    void makeListToSendTest() {
        List<Stack> stairs = bridgeMap.makeListToSend();
        Assertions.assertThat(stairs).size().isSameAs(2);
    }

    @Test
    void initTest() {
        bridgeMap.init();
        Assertions.assertThat(upStairs).isEmpty();
    }
}