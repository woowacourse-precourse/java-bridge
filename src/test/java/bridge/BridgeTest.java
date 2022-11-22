package bridge;

import bridge.domain.Bridge;
import bridge.state.BridgeGameState;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

public class BridgeTest {

    @Test
    @DisplayName("다리에서 위치를 이동하는 메소드 테스트")
    void moveTest1() {
        Bridge bridge = new Bridge(List.of("U", "D", "U", "D"));
        bridge.move("U");
        Assertions.assertThat(bridge.getBridgeGameState()).isEqualTo(BridgeGameState.NORMAL);
        bridge.move("D");
        Assertions.assertThat(bridge.getBridgeGameState()).isEqualTo(BridgeGameState.NORMAL);
        bridge.move("U");
        Assertions.assertThat(bridge.getBridgeGameState()).isEqualTo(BridgeGameState.NORMAL);
        bridge.move("D");
        Assertions.assertThat(bridge.getBridgeGameState()).isEqualTo(BridgeGameState.SUCCESS_AND_END);
    }

    @Test
    @DisplayName("다리에서 위치를 이동하는 메소드 테스트2")
    void moveTest2() {
        Bridge bridge = new Bridge(List.of("U", "D", "U", "D"));
        bridge.move("U");
        Assertions.assertThat(bridge.getBridgeGameState()).isEqualTo(BridgeGameState.NORMAL);
        bridge.move("U");
        Assertions.assertThat(bridge.getBridgeGameState()).isEqualTo(BridgeGameState.FAIL);
    }
}
