package bridge;

import bridge.domain.Bridge;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;

public class BridgeTest {
    private final int bridgeSize = 3;

    @DisplayName("사용자가 입력한 방향과 건널 수 있는 다리의 칸이 일치하는지 확인")
    @Test
    void checkBridgeDirectionMatcing() {
        assertRandomNumberInRangeTest(() -> {
            Bridge bridge = new Bridge(bridgeSize);
            assertThat(bridge.isCorrectDirection(0, "U")).isTrue();
            assertThat(bridge.isCorrectDirection(0, "D")).isFalse();
            assertThat(bridge.isCorrectDirection(2, "D")).isFalse();
        }, 1, 0, 1);
    }

}
