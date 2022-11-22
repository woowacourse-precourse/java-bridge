package bridge.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class BridgeGameTest {

    static BridgeGame bridgeGame = new BridgeGame();

    @Test
    @DisplayName("입력한 다리와 정답이 같은지 확인한다.")
    void checkAnswer() {
        Bridge answer = new Bridge(List.of("U", "D", "U"));
        Bridge input = new Bridge(List.of("U", "D", "U"));
        Bridge input2 = new Bridge(List.of("U", "D", "D"));

        bridgeGame.setUp(answer, input);
        assertThat(bridgeGame.checkAnswer()).isEqualTo(true);

        bridgeGame.setUp(answer, input2);
        assertThat(bridgeGame.checkAnswer()).isEqualTo(false);
    }
}
