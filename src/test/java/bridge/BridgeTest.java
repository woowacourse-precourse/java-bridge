package bridge;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class BridgeTest {

    @Test
    @DisplayName("만약 사용자의 답이 맞으면 성공이다.")
    void isTrueIfPlayerAnswerIsCorrect() {
        List<String> bridge = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            bridge.add("U");
        }
        Bridge testBridge = new Bridge(bridge);

        assertThat(testBridge.canMove("U", 0)).isEqualTo(true);
    }
}