package bridge.domain;

import bridge.domain.user.MoveType;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BridgeTest {

    @Test
    @DisplayName("다리 생성 테스트")
    void createBridgeTest() {
        List<String> bridges = List.of("U", "D", "D", "D", "U");
        Bridge bridge = Bridge.initBridge(bridges);

        Assertions.assertThat(bridge).extracting("bridge").isEqualTo(bridges);
    }

    @Test
    @DisplayName("다리 건너기 테스트 (성공)")
    void canCrossTest() {
        List<String> bridges = List.of("U", "D", "D", "D", "U");
        Bridge bridge = Bridge.initBridge(bridges);

        boolean isCanCross = bridge.canCross(0, MoveType.convertMoveType("U"));
        Assertions.assertThat(isCanCross).isTrue();
    }

    @Test
    @DisplayName("다리 건너기 테스트 (성공)")
    void canCrossWrongTest() {
        List<String> bridges = List.of("U", "D", "D", "D", "U");
        Bridge bridge = Bridge.initBridge(bridges);

        boolean isCanCross = bridge.canCross(0, MoveType.convertMoveType("D"));
        Assertions.assertThat(isCanCross).isFalse();
    }

    @Test
    @DisplayName("다리 사이즈 테스트")
    void getBridgeEndTest() {
        List<String> bridges = List.of("U", "D", "D", "D", "U");
        Bridge bridge = Bridge.initBridge(bridges);

        int bridgeSize = bridge.getBridgeEnd();
        Assertions.assertThat(bridgeSize).isEqualTo(5);
    }
}
