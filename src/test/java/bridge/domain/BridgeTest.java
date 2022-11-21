package bridge.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BridgeTest {

    @Test
    @DisplayName("이동 성공 여부를 판단한다.")
    void updateMoving() {
        Bridge bridge = new Bridge(3, List.of("U", "U", "D"));
        assertThat(bridge.updateMoving("U")).isEqualTo(true);
        assertThat(bridge.updateMoving("U")).isEqualTo(true);
        assertThat(bridge.updateMoving("D")).isEqualTo(true);
    }

    @Test
    @DisplayName("다리의 끝까지 도달했는지 판단한다.")
    void reachEndOfBridge() {
        Bridge bridge = new Bridge(3, List.of("U", "U", "D"));
        assertThat(bridge.reachEndOfBridge()).isEqualTo(false);
        bridge.updateMoving("U");
        bridge.updateMoving("U");
        bridge.updateMoving("D");
        assertThat(bridge.reachEndOfBridge()).isEqualTo(true);
    }

    @Test
    @DisplayName("이전 기록 초기화 후 길이는 0이다.")
    void clearPlayerMovingHistory() {
        Bridge bridge = new Bridge(3, List.of("U", "U", "D"));
        bridge.clearPlayerMovingHistory();
        assertThat(bridge.getPlayerMovingHistory().size()).isEqualTo(0);
    }
}