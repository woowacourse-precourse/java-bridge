package bridge.model;

import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BridgeTest {

    private Bridge bridge;

    @BeforeEach
    void 다리_설정() {
        bridge = new Bridge(List.of("U", "D", "D"));
    }

    @Test
    void 사용자_이동방향과_비교() {
        Assertions.assertTrue(bridge.isSamePosition(1, Position.DOWN));
        Assertions.assertFalse(bridge.isSamePosition(1, Position.UP));
    }

    @Test
    void 다리_길이_받아오기() {
        Assertions.assertEquals(3, bridge.getBridgeSize());
    }

/*    @Test
    void 최종_성공_테스트() {
        Assertions.assertTrue(bridge.survivedToTheLast(2));
    }*/
}