package bridge;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class BridgeGameTest {

    @Test
    @DisplayName("만약 사용자의 답이 맞으면 성공이다.")
    void isTrueIfPlayerAnswerIsCorrect() {
        // U U U U
        List<String> bridge = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            bridge.add("U");
        }
        BridgeGame bridgeGame = new BridgeGame(bridge);

        assertThat(bridgeGame.move("U", 0)).isEqualTo(true);
    }
}