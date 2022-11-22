package bridge;

import bridge.game.BridgeGame;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class BridgeGameTest {
    @Test
    @DisplayName("R, Q 외에 다른 것을 입력하면 오류를 던진다.")
    void makeIncorrectInput() {
        List<String> bridge = new ArrayList<>();
        BridgeGame bridgeGame = new BridgeGame(bridge);
        String testCommand = "T";
        assertThatThrownBy(() -> bridgeGame.retry(testCommand)).isInstanceOf(IllegalArgumentException.class);
    }
}