package bridge;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BridgeGameTest {

    @DisplayName("다리 건너기에 성공했는지 체크하는 메서드")
    @Test
    void move() {
        BridgeGame bridgeGame = new BridgeGame();
        assertTrue(bridgeGame.move("D", 0));
    }

}