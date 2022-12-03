package bridge;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BridgeGameTest {

    BridgeGame bridgeGame = new BridgeGame();

    @DisplayName("이동한 칸을 건널 수 있는 경우 잘 건너는지 확인")
    @Test
    void movingIsSuccess() {
        bridgeGame.move("U", "U");
        assertThat(BridgeGame.getUpBridge().toString()).contains("O");
    }

    @DisplayName("이동한 칸을 건널 수 없는 경우 잘 건너는지 확인")
    @Test
    void movingIsFail() {
        bridgeGame.move("D", "U");
        assertThat(BridgeGame.getDownBridge().toString()).contains("X");
    }
}
