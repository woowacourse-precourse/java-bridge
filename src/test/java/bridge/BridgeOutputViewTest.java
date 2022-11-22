package bridge;

import bridge.domain.Bridge;
import bridge.domain.BridgeOutputView;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

public class BridgeOutputViewTest {

    @Test
    @DisplayName("다리 상태 출력메소드 테스트")
    void bridgePrintTest() {
        Bridge bridge = new Bridge(List.of("U", "D", "U", "D"));
        bridge.move("U");
        Assertions.assertThat(BridgeOutputView.bridgePrint(bridge)).isEqualTo("[ O ]\n[   ]");
        bridge.move("D");
        Assertions.assertThat(BridgeOutputView.bridgePrint(bridge)).isEqualTo("[ O |   ]\n[   | O ]");
        bridge.move("U");
        Assertions.assertThat(BridgeOutputView.bridgePrint(bridge)).isEqualTo("[ O |   | O ]\n[   | O |   ]");
        bridge.move("D");
        Assertions.assertThat(BridgeOutputView.bridgePrint(bridge)).isEqualTo("[ O |   | O |   ]\n[   | O |   | O ]");
    }

    @Test
    @DisplayName("다리 상태 출력메소드 FAIL 케이스 테스트")
    void bridgePrintTest2() {
        Bridge bridge = new Bridge(List.of("U", "D", "U", "D"));
        bridge.move("D");
        Assertions.assertThat(BridgeOutputView.bridgePrint(bridge)).isEqualTo("[   ]\n[ X ]");

        bridge = new Bridge(List.of("U", "D", "U", "D"));
        bridge.move("U");
        bridge.move("D");
        bridge.move("D");
        Assertions.assertThat(BridgeOutputView.bridgePrint(bridge)).isEqualTo("[ O |   |   ]\n[   | O | X ]");
    }
}
